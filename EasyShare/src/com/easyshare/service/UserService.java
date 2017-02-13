package com.easyshare.service;


public interface UserService {

	
	/**
	 * 检查验证码是否一致
	 * @param rightCode 正确的验证码
	 * @param code 用户输入的验证码
	 * @return
	 */
	boolean checkCode(String rightCode,String code);
	
	
	
	/**
	 * 在用户修改数据时
	 * 验证手机号和邮箱的唯一性
	 * @param email 邮箱
	 * @param phone 手机号
	 * @param object 用户对象
	 * @return
	 */
	boolean checkEmailAndPhone(String email,String phone,Object object);
	
	
	
	/**
	 * 保存用户对象
	 * @param sList 保存有新用户信息的数组
	 * @return
	 */
	boolean registerUser(Object object);
	
}
