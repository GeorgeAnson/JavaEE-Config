package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 杂物管理实体
 * @author Administrator
 *
 */
public class ManageDebris  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5592484998042158249L;

	
	private int AdminID;//管理员ID
	private int Debris;//杂物ID
	private Date ModifyDate;//修改时间
	
	
	
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
	public void setAdminID(int adminID)
	{
		AdminID = adminID;
	}
	
	
	
	/**
	 * 获取杂物ID
	 * @return
	 */
	public int getDebris()
	{
		return Debris;
	}
	
	
	
	/**
	 * 设置杂物ID
	 * @param debris
	 */
	public void setDebris(int debris)
	{
		Debris = debris;
	}
	
	
	/**
	 * 获取修改时间
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * 设置修改时间
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate)
	{
		ModifyDate = modifyDate;
	}
	
	
	
}
