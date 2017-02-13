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
 * 静态类
 * 工具类，为个各类提供服务
 * @author Administrator
 *
 */
public class Utils {

	
	/**
	 * 检查邮箱是否符合邮箱格式
	 * @param content 待检测的字符串
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
	 * 检查陌生人输入的建议是否满足长度要求
	 * @param content 建议内容
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
	 * 检查手机格式是否正确
	 * @param phone 待检测的字符串
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
	 * 将字符串进行MD5加密
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
	 * 将时间字符串转换成sql的Date类型
	 * 
	 * @param ymd
	 * 			获取的表单中的时间
	 * @return
	 * 			sql的Date类型
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
	 * 装换用户类型
	 * @param gender
	 * 		String
	 * @return
	 * 		Boolean
	 * 		0-男，1-女
	 */
	public static boolean changeUserGenderType(String gender) {
		boolean flag=false;
		if(gender.equals("男"))
		{
			flag=false;
		}else
		{
			flag=true;
		}
		return flag;
	}
	
	
	/**
	 * 转换用户负责人类型
	 * @param inCharge
	 * 			String
	 * @return
	 * 		Boolean 0-是，1-否
	 */
	public static int changeInChargeType(String inCharge)
	{
		int flag=0;
		if(inCharge.equals("是"))
		{
			flag=1;
		}else
		{
			flag=0;
		}
		return flag;
	}
	
	
	/**
	 * 生成随机编号
	 * @return
	 * 		String
	 */
	public static String createRandomName()
	{
		DateFormat dateFormat=new SimpleDateFormat("hhmmss");
		return dateFormat.format(new java.util.Date())+(int)(Math.random()*89+10);
	}
	
	/**
	 * 获取公共信息对象
	 * @param object
	 * 			User对象
	 * @return
	 * 		CommonUserInfo对象
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
