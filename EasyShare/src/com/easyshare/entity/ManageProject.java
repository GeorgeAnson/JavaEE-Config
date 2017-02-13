package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * ��Ŀ����ʵ��
 * @author Administrator
 *
 */
public class ManageProject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291589700682876922L;

	private int ManageProjectID;//��Ŀ����ID
	private int CommonID;//��ȡ�û�����ID
	private int ProjectID;//��ȡ��ĿID
	private String Logtxt;//һ����Ŀ��־��Ϣ
	private Date ModifyDate;//��ȡ��Ŀ�޸�ʱ��
	private int Status=1;//Ĭ��Ϊ1�����
	
	private CommonUserInfo commonUserInfo;//�����û���Ϣ
	
	private Project project=null;//��Ŀ��Ϣ
	/**
	 * ��ȡ��Ŀ����ID
	 * @return
	 * 		int
	 */
	public int getManageProjectID() {
		return ManageProjectID;
	}


	/**
	 * ������Ŀ����ID
	 * @param manageProjectID
	 * 		int
	 * 			ManageProjectID
	 */
	public void setManageProjectID(int manageProjectID) {
		ManageProjectID = manageProjectID;
	}


	/**
	 * ��ȡ�����û�ID
	 * @return
	 * 		int
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * ���ù����û�ID
	 * @param commonID
	 * 		int
	 * 			CommonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * ��ȡ��ĿID
	 * @return
	 */
	public int getProjectID()
	{
		return ProjectID;
	}
	
	
	/**
	 * ������ĿID
	 * @param projectID
	 */
	public void setProjectID(int projectID)
	{
		ProjectID = projectID;
	}
	
	
	/**
	 * ��ȡһ����Ŀ��־
	 * @return
	 * 		String
	 */
	public String getLogtxt() {
		return Logtxt;
	}


	/**
	 * ����һ����Ŀ��־
	 * @param logtxt
	 */
	public void setLogtxt(String logtxt) {
		Logtxt = logtxt;
	}


	/**
	 * ��ȡ��Ŀ�޸�ʱ��
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * ������Ŀ�޸�ʱ��
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate)
	{
		ModifyDate = modifyDate;
	}

	
	/**
	 * ��ȡ������־״̬
	 * @return
	 * 		int
	 * 			Status
	 * 			1����
	 * 			-1ɾ��
	 */
	public int getStatus() {
		return Status;
	}


	/**
	 * ���ñ�����־״̬
	 * @param status
	 * 		int
	 * 			1����
	 * 			-1ɾ��
	 */
	public void setStatus(int status) {
		Status = status;
	}


	/**
	 * ��ȡ�û�������Ϣ
	 * @return
	 * 		CommonUserInfo
	 */
	public CommonUserInfo getCommonUserInfo() {
		return commonUserInfo;
	}


	/**
	 * ���ù����û���Ϣ
	 * @param commonUserInfo
	 * 		CommonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) {
		this.commonUserInfo = commonUserInfo;
	}


	/**
	 * ��ȡ��Ŀ��Ϣ
	 * @return
	 * 		Project
	 */
	public Project getProject() {
		return project;
	}


	/**
	 * ������Ŀ��Ϣ
	 * @param project
	 * 		Project
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	
}
