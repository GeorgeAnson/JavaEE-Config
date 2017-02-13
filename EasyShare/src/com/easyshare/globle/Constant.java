package com.easyshare.globle;

import java.awt.Color;
import java.awt.Font;
public class Constant {

	/**
	 * ��֤�볤��
	 */
	public static final Integer IMAGE_WIDTH=120;
	/**
	 * ��֤����
	 */
	public static final Integer IMAGE_HEIGHT=40;
	
	/**
	 * ��֤������
	 */
	public static Font[] codeFont={new Font("Times New Roman",Font.PLAIN,30),
			new Font("Times New Roman",Font.PLAIN,30),new Font("Times New Roman",Font.PLAIN,30),
			new Font("Times New Roman",Font.PLAIN,30),new Font("Times New Roman",Font.PLAIN,30)};
	
	/**
	 * ��֤��ÿ���ַ���ɫ
	 */
	public static Color[] color={Color.BLACK,Color.BLUE,Color.RED,Color.DARK_GRAY};
	
	/**
	 * ��֤���ֿ�
	 */
	public static final String IMAGE_CHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	
	
	/**
	 * session�е��û�
	 */
	public static String USER_KEY = "user";
	
	
	/**
	 * ������ʾ��Ϣ
	 */
	public static String ERROR= "error_message";
	
	/**
	 * ������ServletContext���û��б�
	 */
	public static String ONLINE_USERS="com.easyshare.listener.onLineListener.Map";
	
	
	/**
	 * ��½��ת�ɹ�������
	 */
	public static String OK_URL = "com.easyshare.utils.Constant.ok_url";

	/**
	 * ��½��תʧ�ܵ�����
	 */
	public static String ERR_URL = "com.easyshare.utils.Constant.err_url";
	
	/**
	 * ��֤��
	 */
	public static String CHECK_NUMBER_NAME = "identify_code";

	
	/**
	 * �������豸��Ϣ
	 */
	public static String EQUIPMENTS="equipments";
	
	/**
	 * ���������Ϣ
	 */
	public static String ALL_BORROWED_BOOKS="allBorrowedBooks";
	
	/**
	 * �����û�������Ϣ
	 */
	public static String COMMON_USER_INFO="userInfo";
	
	/**
	 * ����ѧ����Ϣ
	 */
	public static String STUDENTS="students";
	
	
	/**
	 * �����ʦ��Ϣ
	 */
	public static String TEACHERS="teachers";
}
