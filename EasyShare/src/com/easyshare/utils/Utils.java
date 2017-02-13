package com.easyshare.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;


/**
 * ��̬��
 * �����࣬Ϊ�������ṩ����
 * @author Administrator
 *
 */
public class Utils {

	
	/**
	 * ��������Ƿ���������ʽ
	 * @param content �������ַ���
	 * @return
	 */
	public static boolean isEmail(String email)
	{
		String rule = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern=Pattern.compile(rule);
		Matcher matcher=pattern.matcher(email);
		return matcher.matches();
	}
	
	
	/**
	 * ���İ��������Ľ����Ƿ����㳤��Ҫ��
	 * @param content ��������
	 * @return
	 */
	public static boolean isContentLengthOK(String content)
	{
		boolean flag=false;
		if(content.length()>=20)
		{
			flag=true;
		}
		return flag;
	}
	
	
	/**
	 * ����ֻ���ʽ�Ƿ���ȷ
	 * @param phone �������ַ���
	 * @return
	 */
	public static boolean isPhone(String phone)
	{
		String rule="(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}";
		Pattern pattern=Pattern.compile(rule);
		Matcher matcher=pattern.matcher(phone);
		return matcher.matches();
	}
	
	
	/**
	 * ���ַ�������MD5����
	 */
	public static String toMD5(String secur)
	{
		String result=null;
		try 
		{
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(secur.getBytes());
			result=new BigInteger(1, md.digest()).toString(32);
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * ��ʱ���ַ���ת����sql��Date����
	 * 
	 * @param ymd
	 * 			��ȡ�ı��е�ʱ��
	 * @return
	 * 			sql��Date����
	 */
	public static final Date stringToDate(String ymd)
	{
		Date sqlDate=null;
		try 
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date;
			date = sdf.parse(ymd);
			sqlDate=new Date(date.getTime());
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	/**
	 * װ���û�����
	 * @param gender
	 * 		String
	 * @return
	 * 		Boolean
	 * 		0-�У�1-Ů
	 */
	public static boolean changeUserGenderType(String gender) {
		boolean flag=false;
		if(gender.equals("��"))
		{
			flag=false;
		}else
		{
			flag=true;
		}
		return flag;
	}
	
	
	/**
	 * ת���û�����������
	 * @param inCharge
	 * 			String
	 * @return
	 * 		Boolean 0-�ǣ�1-��
	 */
	public static int changeInChargeType(String inCharge)
	{
		int flag=0;
		if(inCharge.equals("��"))
		{
			flag=1;
		}else
		{
			flag=0;
		}
		return flag;
	}
	
	
	/**
	 * ����������
	 * @return
	 * 		String
	 */
	public static String createRandomName()
	{
		DateFormat dateFormat=new SimpleDateFormat("hhmmss");
		return dateFormat.format(new java.util.Date())+(int)(Math.random()*89+10);
	}
	
	/**
	 * ��ȡ������Ϣ����
	 * @param object
	 * 			User����
	 * @return
	 * 		CommonUserInfo����
	 */
	public static CommonUserInfo getUserCommonInfo(Object object) {
		CommonUserInfo commonUserInfo=null;
		if(object instanceof Student)
		{
			commonUserInfo=((Student) object).getCommonUserInfo();
		}else if(object instanceof Teacher)
		{
			commonUserInfo=((Teacher) object).getCommonUserInfo();
		}
		return commonUserInfo;
	}
}
