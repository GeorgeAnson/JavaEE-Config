package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 款项流动管理实体
 * @author Administrator
 *
 */
public class ManageFlow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5721580542464276666L;

	
	private int AdminID;//管理员ID
	private int CashFlowID;//款项ID
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
	 * 获取款项ID
	 * @return
	 */
	public int getCashFlowID()
	{
		return CashFlowID;
	}
	
	
	/**
	 * 设置款项ID
	 * @param cashFlowID
	 */
	public void setCashFlowID(int cashFlowID)
	{
		CashFlowID = cashFlowID;
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
