package com.easyshare.entity;

public interface IUser {

	/**
	 * 获取用户实体
	 * @param commonUserInfo
	 * 				公共信息
	 * @return
	 * 			object对象，教师或者学生或者管理员
	 */
	Object getUser(CommonUserInfo commonUserInfo);
}
