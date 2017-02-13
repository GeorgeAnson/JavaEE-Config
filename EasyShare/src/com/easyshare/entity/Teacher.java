package com.easyshare.entity;

import java.io.Serializable;


/**
 * ��ʦʵ��
 * @author Administrator
 *
 */
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -899103423352010273L;
	
	private int TeacherID;//��ʦID
	private String ProffessionalTitle=null;//��ʦְ��
	private CommonUserInfo commonUserInfo=null;//������Ϣ��ʵ��
	private UserConnection userConnection=null;//��ϵ��ʵ��
	
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
	 * ��ȡ��ʦID
	 * @return
	 */
	public int getTeacherID()
	{
		return TeacherID;
	}

	
	/**
	 * ���ý�ʦID
	 * @param teacherID
	 */
	public void setTeacherID(int teacherID)
	{
		TeacherID = teacherID;
	}

	
	/**
	 * ��ȡ��ʦְ��
	 * @return
	 */
	public String getProffessionalTitle()
	{
		return ProffessionalTitle;
	}

	
	/**
	 * ���ý�ʦְ��
	 * @param proffessionalTitle
	 */
	public void setProffessionalTitle(String proffessionalTitle)
	{
		ProffessionalTitle = proffessionalTitle;
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
	 * ��ȡ�û�����ʵ��
	 * @return
	 */
	public UserConnection getUserConnection() {
		return userConnection;
	}


	/**
	 * �����û�����ʵ��
	 * @param userConnection
	 */
	public void setUserConnection(UserConnection userConnection) {
		this.userConnection = userConnection;
	}
	
	
	

}
