package com.easyshare.entity;

import java.io.Serializable;


/**
 * 教师实体
 * @author Administrator
 *
 */
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -899103423352010273L;
	
	private int TeacherID;//教师ID
	private String ProffessionalTitle=null;//教师职称
	private CommonUserInfo commonUserInfo=null;//公共信息表实体
	private UserConnection userConnection=null;//联系表实体
	
	public Teacher()
	{
		
	}
	
	
	public Teacher(int teacherID)
	{
		this.TeacherID=teacherID;
	}

	
	public Teacher(CommonUserInfo commonUserInfo)
	{
		this.commonUserInfo=commonUserInfo;
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
	 * 获取教师职称
	 * @return
	 */
	public String getProffessionalTitle()
	{
		return ProffessionalTitle;
	}

	
	/**
	 * 设置教师职称
	 * @param proffessionalTitle
	 */
	public void setProffessionalTitle(String proffessionalTitle)
	{
		ProffessionalTitle = proffessionalTitle;
	}

	
	/**
	 * 获取公共信息实体
	 * @return
	 */
	public CommonUserInfo getCommonUserInfo()
	{
		return commonUserInfo;
	}

	
	/**
	 * 设置公共信息实体
	 * @param commonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) 
	{
		this.commonUserInfo = commonUserInfo;
	}


	/**
	 * 获取用户连接实体
	 * @return
	 */
	public UserConnection getUserConnection() {
		return userConnection;
	}


	/**
	 * 设置用户连接实体
	 * @param userConnection
	 */
	public void setUserConnection(UserConnection userConnection) {
		this.userConnection = userConnection;
	}
	
	
	

}
