package com.easyshare.entity;

import java.io.Serializable;


/**
 * 学生实体
 * @author Administrator
 *
 */
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244157062253263431L;
	
	
	private int StudentID;//学生ID
	private String StudentNum=null;//学生学号
	private String Grade=null;//年级
	private String Major=null;//专业
	private String Apartment=null;//部门信息
	private CommonUserInfo commonUserInfo=null;//公共信息实体
	private UserConnection userConnection=null;//用户信息联系表
	
	
	public Student()
	{
		
	}
	
	
	/**
	 * 构造函数
	 * 设置学生系统编号
	 * @param studentID
	 * 		int
	 */
	public Student(int studentID)
	{
		this.StudentID=studentID;
	}


	/**
	 * 获取学生学号
	 * @return
	 * 		String
	 * 			StudentNum
	 */
	public String getStudentNum() {
		return StudentNum;
	}


	/**
	 * 设置学生学号
	 * @param studentNum
	 * 			String
	 */
	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}


	/**
	 * 设置学生公共信息
	 * @param commonUserInfo
	 * 		CommonUserInfo
	 */
	public Student(CommonUserInfo commonUserInfo)
	{
		this.commonUserInfo=commonUserInfo;
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
	 * 获取学生年级
	 * @return
	 */
	public String getGrade()
	{
		return Grade;
	}


	/**
	 * 设置年级
	 * @param grade
	 */
	public void setGrade(String grade)
	{
		Grade = grade;
	}


	/**
	 * 获取专业
	 * @return
	 */
	public String getMajor() {
		return Major;
	}


	/**
	 * 设置专业
	 * @param major
	 */
	public void setMajor(String major) {
		Major = major;
	}


	/**
	 * 获取学生部门信息
	 * @return
	 * 		String
	 * 			Apartment
	 */
	public String getApartment() {
		return Apartment;
	}


	/**
	 * 设置学生部门信息
	 * @param apartment
	 * 			String
	 */
	public void setApartment(String apartment) {
		Apartment = apartment;
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
	 * 获取用户信息联系实体
	 * @return
	 */
	public UserConnection getUserConnection() {
		return userConnection;
	}


	/**
	 * 设置用户信息联系实体
	 * @param userConnection
	 */
	public void setUserConnection(UserConnection userConnection) {
		this.userConnection = userConnection;
	}
	
	
	

}
