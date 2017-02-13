package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 项目管理实体
 * @author Administrator
 *
 */
public class ManageProject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291589700682876922L;

	private int ManageProjectID;//项目管理ID
	private int CommonID;//获取用户公共ID
	private int ProjectID;//获取项目ID
	private String Logtxt;//一条项目日志信息
	private Date ModifyDate;//获取项目修改时间
	private int Status=1;//默认为1，添加
	
	private CommonUserInfo commonUserInfo;//公共用户信息
	
	private Project project=null;//项目信息
	/**
	 * 获取项目管理ID
	 * @return
	 * 		int
	 */
	public int getManageProjectID() {
		return ManageProjectID;
	}


	/**
	 * 设置项目管理ID
	 * @param manageProjectID
	 * 		int
	 * 			ManageProjectID
	 */
	public void setManageProjectID(int manageProjectID) {
		ManageProjectID = manageProjectID;
	}


	/**
	 * 获取公共用户ID
	 * @return
	 * 		int
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * 设置公共用户ID
	 * @param commonID
	 * 		int
	 * 			CommonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
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
	 * 获取一条项目日志
	 * @return
	 * 		String
	 */
	public String getLogtxt() {
		return Logtxt;
	}


	/**
	 * 设置一条项目日志
	 * @param logtxt
	 */
	public void setLogtxt(String logtxt) {
		Logtxt = logtxt;
	}


	/**
	 * 获取项目修改时间
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * 设置项目修改时间
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate)
	{
		ModifyDate = modifyDate;
	}

	
	/**
	 * 获取本条日志状态
	 * @return
	 * 		int
	 * 			Status
	 * 			1增加
	 * 			-1删除
	 */
	public int getStatus() {
		return Status;
	}


	/**
	 * 设置本条日志状态
	 * @param status
	 * 		int
	 * 			1增加
	 * 			-1删除
	 */
	public void setStatus(int status) {
		Status = status;
	}


	/**
	 * 获取用户公共信息
	 * @return
	 * 		CommonUserInfo
	 */
	public CommonUserInfo getCommonUserInfo() {
		return commonUserInfo;
	}


	/**
	 * 设置公共用户信息
	 * @param commonUserInfo
	 * 		CommonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) {
		this.commonUserInfo = commonUserInfo;
	}


	/**
	 * 获取项目信息
	 * @return
	 * 		Project
	 */
	public Project getProject() {
		return project;
	}


	/**
	 * 设置项目信息
	 * @param project
	 * 		Project
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	
}
