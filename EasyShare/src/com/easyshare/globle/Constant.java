package com.easyshare.globle;

import java.awt.Color;
import java.awt.Font;
public class Constant {

	/**
	 * 验证码长度
	 */
	public static final Integer IMAGE_WIDTH=120;
	/**
	 * 验证码宽度
	 */
	public static final Integer IMAGE_HEIGHT=40;
	
	/**
	 * 验证码字体
	 */
	public static Font[] codeFont={new Font("Times New Roman",Font.PLAIN,30),
			new Font("Times New Roman",Font.PLAIN,30),new Font("Times New Roman",Font.PLAIN,30),
			new Font("Times New Roman",Font.PLAIN,30),new Font("Times New Roman",Font.PLAIN,30)};
	
	/**
	 * 验证码每个字符颜色
	 */
	public static Color[] color={Color.BLACK,Color.BLUE,Color.RED,Color.DARK_GRAY};
	
	/**
	 * 验证码字库
	 */
	public static final String IMAGE_CHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	
	
	/**
	 * session中的用户
	 */
	public static String USER_KEY = "user";
	
	
	/**
	 * 错误提示信息
	 */
	public static String ERROR= "error_message";
	
	/**
	 * 保存在ServletContext中用户列表
	 */
	public static String ONLINE_USERS="com.easyshare.listener.onLineListener.Map";
	
	
	/**
	 * 登陆跳转成功的链接
	 */
	public static String OK_URL = "com.easyshare.utils.Constant.ok_url";

	/**
	 * 登陆跳转失败的链接
	 */
	public static String ERR_URL = "com.easyshare.utils.Constant.err_url";
	
	/**
	 * 验证码
	 */
	public static String CHECK_NUMBER_NAME = "identify_code";

	
	/**
	 * 保存需设备信息
	 */
	public static String EQUIPMENTS="equipments";
	
	/**
	 * 保存借书信息
	 */
	public static String ALL_BORROWED_BOOKS="allBorrowedBooks";
	
	/**
	 * 保存用户公共信息
	 */
	public static String COMMON_USER_INFO="userInfo";
	
	/**
	 * 保存学生信息
	 */
	public static String STUDENTS="students";
	
	
	/**
	 * 保存教师信息
	 */
	public static String TEACHERS="teachers";
}
