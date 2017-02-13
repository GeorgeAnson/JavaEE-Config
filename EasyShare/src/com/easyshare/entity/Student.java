package com.easyshare.entity;

import java.io.Serializable;


/**
 * ѧ��ʵ��
 * @author Administrator
 *
 */
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244157062253263431L;
	
	
	private int StudentID;//ѧ��ID
	private String StudentNum=null;//ѧ��ѧ��
	private String Grade=null;//�꼶
	private String Major=null;//רҵ
	private String Apartment=null;//������Ϣ
	private CommonUserInfo commonUserInfo=null;//������Ϣʵ��
	private UserConnection userConnection=null;//�û���Ϣ��ϵ��
	
	
	public Student()
	{
		
	}
	
	
	/**
	 * ���캯��
	 * ����ѧ��ϵͳ���
	 * @param studentID
	 * 		int
	 */
	public Student(int studentID)
	{
		this.StudentID=studentID;
	}


	/**
	 * ��ȡѧ��ѧ��
	 * @return
	 * 		String
	 * 			StudentNum
	 */
	public String getStudentNum() {
		return StudentNum;
	}


	/**
	 * ����ѧ��ѧ��
	 * @param studentNum
	 * 			String
	 */
	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}


	/**
	 * ����ѧ��������Ϣ
	 * @param commonUserInfo
	 * 		CommonUserInfo
	 */
	public Student(CommonUserInfo commonUserInfo)
	{
		this.commonUserInfo=commonUserInfo;
	}


	/**
	 * ��ȡѧ��ID
	 * @return
	 */
	public int getStudentID()
	{
		return StudentID;
	}


	/**
	 * ����ѧ��ID
	 * @param studentID
	 */
	public void setStudentID(int studentID)
	{
		StudentID = studentID;
	}


	/**
	 * ��ȡѧ���꼶
	 * @return
	 */
	public String getGrade()
	{
		return Grade;
	}


	/**
	 * �����꼶
	 * @param grade
	 */
	public void setGrade(String grade)
	{
		Grade = grade;
	}


	/**
	 * ��ȡרҵ
	 * @return
	 */
	public String getMajor() {
		return Major;
	}


	/**
	 * ����רҵ
	 * @param major
	 */
	public void setMajor(String major) {
		Major = major;
	}


	/**
	 * ��ȡѧ��������Ϣ
	 * @return
	 * 		String
	 * 			Apartment
	 */
	public String getApartment() {
		return Apartment;
	}


	/**
	 * ����ѧ��������Ϣ
	 * @param apartment
	 * 			String
	 */
	public void setApartment(String apartment) {
		Apartment = apartment;
	}


	/**
	 * ��ȡ������Ϣʵ��
	 * @return
	 */
	public CommonUserInfo getCommonUserInfo() 
	{
		return commonUserInfo;
	}


	/**
	 * ���ù�����Ϣʵ��
	 * @param commonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo)
	{
		this.commonUserInfo = commonUserInfo;
	}


	/**
	 * ��ȡ�û���Ϣ��ϵʵ��
	 * @return
	 */
	public UserConnection getUserConnection() {
		return userConnection;
	}


	/**
	 * �����û���Ϣ��ϵʵ��
	 * @param userConnection
	 */
	public void setUserConnection(UserConnection userConnection) {
		this.userConnection = userConnection;
	}
	
	
	

}
