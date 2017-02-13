package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 项目实体
 * @author Administrator
 *
 */
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3691506768009037485L;
	
	
	
	private int ProjectID;//项目ID
	private String ProjectName=null;//项目名称
	private String Client=null;//客户
	private int ProjectType=0;//项目类型，默认为学生科研项目
	private Date StartDate=null;//项目开始时间
	private Date EndDate=null;//项目结束时间
	private int CommonID;//负责人公共ID
	private int IsContract;//是否签订合同
	private String proBook=null;//项目计划书链接
	private int Status=1;//项目当前状态,状态1位正常进行中
	private int Opr;//操作类型，0添加，1修改
	
	private Object user=null;//项目负责人信息
	
	private CommonUserInfo commonUserInfo=null;//获取项目负责人公共信息
	
	public Project()
	{
		
	}
	
	
	public Project(int projectID)
	{
		this.ProjectID=projectID;
	}


	/**
	 * 获取项目ID
	 * @return
	 */
	public int getProjectID()
	{
		return ProjectID;
	}


	/**
	 * 设置项目ID
	 * @param projectID
	 */
	public void setProjectID(int projectID)
	{
		ProjectID = projectID;
	}


	/**
	 * 获取项目名称
	 * @return
	 */
	public String getProjectName()
	{
		return ProjectName;
	}


	/**
	 * 设置项目名称
	 * @param projectName
	 */
	public void setProjectName(String projectName)
	{
		ProjectName = projectName;
	}


	/**
	 * 获取项目开始时间
	 * @return
	 */
	public Date getStartDate() 
	{
		return StartDate;
	}


	/**
	 * 设置项目开始时间
	 * @param startDate
	 */
	public void setStartDate(Date startDate)
	{
		StartDate = startDate;
	}


	/**
	 * 获取项目结束时间
	 * @return
	 */
	public Date getEndDate()
	{
		return EndDate;
	}


	/**
	 * 设置项目结束时间
	 * @param endDate
	 */
	public void setEndDate(Date endDate)
	{
		EndDate = endDate;
	}


	/**
	 * 获取项目需求方姓名
	 * @return
	 * 		String
	 * 			Client
	 */
	public String getClient() {
		return Client;
	}


	/**
	 * 设置项目需求方姓名
	 * @param client
	 * 		String
	 */
	public void setClient(String client) {
		Client = client;
	}


	/**
	 * 获取项目类型
	 * @return
	 * 		Int
	 * 			ProjectType
	 */
	public int getProjectType() {
		return ProjectType;
	}


	/**
	 * 设置项目类型
	 * @param projectType
	 * 		int
	 * 			projectType
	 */
	public void setProjectType(int projectType) {
		ProjectType = projectType;
	}


	/**
	 * 获取项目负责人公共ID
	 * @return
	 * 		int
	 * 			CommonID
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * 设置项目负责人公共ID
	 * @param commonID
	 * 			int
	 * 				CommonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * 获取项目是否签订合同
	 * @return
	 * 		int
	 * 			isContract
	 */
	public int getIsContract() {
		return IsContract;
	}


	/**
	 * 设置项目是否签订合同
	 * @param isContract
	 * 		int
	 * 			ISContract
	 */
	public void setIsContract(int isContract) {
		IsContract = isContract;
	}


	/**
	 * 获取项目书链接
	 * @return
	 * 		String
	 * 			ProBook
	 */
	public String getProBook() {
		return proBook;
	}


	/**
	 * 设置项目书链接
	 * @param proBook
	 * 		String
	 * 			ProBook
	 */
	public void setProBook(String proBook) {
		this.proBook = proBook;
	}


	/**
	 * 获取项目状态
	 * @return
	 * 		int	
	 * 			Status
	 */
	public int getStatus() {
		return Status;
	}


	/**
	 * 设置项目状态
	 * @param status
	 * 		int
	 * 			Status
	 */
	public void setStatus(int status) {
		Status = status;
	}

	
	/**
	 * 获取操作类型
	 * @return
	 * 		int
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * 设置操作类型
	 * @param opr
	 * 		int
	 * 			Opr
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}


	/**
	 * 获取项目负责人对象
	 * @return
	 * 		Object
	 * 			User
	 */
	public Object getUser() {
		return user;
	}


	/**
	 * 设置项目负责人对象
	 * @param user
	 * 		Object
	 * 			User
	 */
	public void setUser(Object user) {
		this.user = user;
	}


	/**
	 * 获取项目负责人公共信息
	 * @return
	 * 		CommonUserInfo
	 */
	public CommonUserInfo getCommonUserInfo() {
		return commonUserInfo;
	}


	/**
	 * 设置项目负责人公共信息
	 * @param commonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) {
		this.commonUserInfo = commonUserInfo;
	}
	
	
	
	
}
