package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * ��Ŀʵ��
 * @author Administrator
 *
 */
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3691506768009037485L;
	
	
	
	private int ProjectID;//��ĿID
	private String ProjectName=null;//��Ŀ����
	private String Client=null;//�ͻ�
	private int ProjectType=0;//��Ŀ���ͣ�Ĭ��Ϊѧ��������Ŀ
	private Date StartDate=null;//��Ŀ��ʼʱ��
	private Date EndDate=null;//��Ŀ����ʱ��
	private int CommonID;//�����˹���ID
	private int IsContract;//�Ƿ�ǩ����ͬ
	private String proBook=null;//��Ŀ�ƻ�������
	private int Status=1;//��Ŀ��ǰ״̬,״̬1λ����������
	private int Opr;//�������ͣ�0��ӣ�1�޸�
	
	private Object user=null;//��Ŀ��������Ϣ
	
	private CommonUserInfo commonUserInfo=null;//��ȡ��Ŀ�����˹�����Ϣ
	
	public Project()
	{
		
	}
	
	
	public Project(int projectID)
	{
		this.ProjectID=projectID;
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
	 * ��ȡ��Ŀ����
	 * @return
	 */
	public String getProjectName()
	{
		return ProjectName;
	}


	/**
	 * ������Ŀ����
	 * @param projectName
	 */
	public void setProjectName(String projectName)
	{
		ProjectName = projectName;
	}


	/**
	 * ��ȡ��Ŀ��ʼʱ��
	 * @return
	 */
	public Date getStartDate() 
	{
		return StartDate;
	}


	/**
	 * ������Ŀ��ʼʱ��
	 * @param startDate
	 */
	public void setStartDate(Date startDate)
	{
		StartDate = startDate;
	}


	/**
	 * ��ȡ��Ŀ����ʱ��
	 * @return
	 */
	public Date getEndDate()
	{
		return EndDate;
	}


	/**
	 * ������Ŀ����ʱ��
	 * @param endDate
	 */
	public void setEndDate(Date endDate)
	{
		EndDate = endDate;
	}


	/**
	 * ��ȡ��Ŀ��������
	 * @return
	 * 		String
	 * 			Client
	 */
	public String getClient() {
		return Client;
	}


	/**
	 * ������Ŀ��������
	 * @param client
	 * 		String
	 */
	public void setClient(String client) {
		Client = client;
	}


	/**
	 * ��ȡ��Ŀ����
	 * @return
	 * 		Int
	 * 			ProjectType
	 */
	public int getProjectType() {
		return ProjectType;
	}


	/**
	 * ������Ŀ����
	 * @param projectType
	 * 		int
	 * 			projectType
	 */
	public void setProjectType(int projectType) {
		ProjectType = projectType;
	}


	/**
	 * ��ȡ��Ŀ�����˹���ID
	 * @return
	 * 		int
	 * 			CommonID
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * ������Ŀ�����˹���ID
	 * @param commonID
	 * 			int
	 * 				CommonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * ��ȡ��Ŀ�Ƿ�ǩ����ͬ
	 * @return
	 * 		int
	 * 			isContract
	 */
	public int getIsContract() {
		return IsContract;
	}


	/**
	 * ������Ŀ�Ƿ�ǩ����ͬ
	 * @param isContract
	 * 		int
	 * 			ISContract
	 */
	public void setIsContract(int isContract) {
		IsContract = isContract;
	}


	/**
	 * ��ȡ��Ŀ������
	 * @return
	 * 		String
	 * 			ProBook
	 */
	public String getProBook() {
		return proBook;
	}


	/**
	 * ������Ŀ������
	 * @param proBook
	 * 		String
	 * 			ProBook
	 */
	public void setProBook(String proBook) {
		this.proBook = proBook;
	}


	/**
	 * ��ȡ��Ŀ״̬
	 * @return
	 * 		int	
	 * 			Status
	 */
	public int getStatus() {
		return Status;
	}


	/**
	 * ������Ŀ״̬
	 * @param status
	 * 		int
	 * 			Status
	 */
	public void setStatus(int status) {
		Status = status;
	}

	
	/**
	 * ��ȡ��������
	 * @return
	 * 		int
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * ���ò�������
	 * @param opr
	 * 		int
	 * 			Opr
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}


	/**
	 * ��ȡ��Ŀ�����˶���
	 * @return
	 * 		Object
	 * 			User
	 */
	public Object getUser() {
		return user;
	}


	/**
	 * ������Ŀ�����˶���
	 * @param user
	 * 		Object
	 * 			User
	 */
	public void setUser(Object user) {
		this.user = user;
	}


	/**
	 * ��ȡ��Ŀ�����˹�����Ϣ
	 * @return
	 * 		CommonUserInfo
	 */
	public CommonUserInfo getCommonUserInfo() {
		return commonUserInfo;
	}


	/**
	 * ������Ŀ�����˹�����Ϣ
	 * @param commonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) {
		this.commonUserInfo = commonUserInfo;
	}
	
	
	
	
}
