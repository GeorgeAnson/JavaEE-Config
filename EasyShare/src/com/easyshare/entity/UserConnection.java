package com.easyshare.entity;

import java.io.Serializable;

/**
 * 用户信息联系实体
 * @author Administrator
 *
 */
public class UserConnection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7631810144951046347L;

	
	private int UserConnectionID;//用户信息联系ID
	private int CommonID;//公共信息ID
	private int StudentID;//学生ID
	private int TeacherID;//教师ID
	private int AdminID;//管理员ID
	
	
	/**
	 * 获取用户信息联系ID
	 * @return
	 */
	public int getUserConnectionID()
	{
		return UserConnectionID;
	}
	
	
	/**
	 * 设置用户信息联系ID
	 * @param userConnectionID
	 */
	public void setUserConnectionID(int userConnectionID)
	{
		UserConnectionID = userConnectionID;
	}
	
	
	/**
	 * 获取公共信息ID
	 * @return
	 */
	public int getCommonID()
	{
		return CommonID;
	}
	
	
	/**
	 * 设置公共信息联系ID
	 * @param commonID
	 */
	public void setCommonID(int commonID)
	{
		CommonID = commonID;
	}
	
	
	/**
	 * 获取学生ID
	 * @return
	 */
	public int getStudentID()
	{
		return StudentID;
	}
	
	
	/**
	 * 设置学生ID
	 * @param studentID
	 */
	public void setStudentID(int studentID)
	{
		StudentID = studentID;
	}
	
	
	/**
	 * 获取教师ID
	 * @return
	 */
	public int getTeacherID()
	{
		return TeacherID;
	}
	
	
	/**
	 * 设置教师ID
	 * @param teacherID
	 */
	public void setTeacherID(int teacherID)
	{
		TeacherID = teacherID;
	}
	
	
	/**
	 * 获取管理员ID
	 * @return
	 */
	public int getAdminID()
	{
		return AdminID;
	}
	
	
	/**
	 * 设置管理员ID
	 * @param adminID
	 */
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	
	
	
}
