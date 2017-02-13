package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;


/**
 * 人员管理实体
 * @author Administrator
 *
 */
public class ManagePerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -432445775078458177L;

	
	private int AdminID;//管理员ID
	private int UserConnectionID;//用户信息联系ID
	private Date ModifyDate;//信息修改日期
	
	
	
	/**
	 *获取管理员ID 
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
	public void setAdminID(int adminID)
	{
		AdminID = adminID;
	}
	
	
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
	 * 获取信息修改日期
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * 设置信息修改日期
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		ModifyDate = modifyDate;
	}
	
	
}
