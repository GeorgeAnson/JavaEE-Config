package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * ������������ʵ��
 * @author Administrator
 *
 */
public class ManageFlow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5721580542464276666L;

	
	private int AdminID;//����ԱID
	private int CashFlowID;//����ID
	private Date ModifyDate;//�޸�ʱ��
	
	
	
	/**
	 * ��ȡ����ԱID
	 * @return
	 */
	public int getAdminID()
	{
		return AdminID;
	}
	
	
	/**
	 * ���ù���ԱID
	 * @param adminID
	 */
	public void setAdminID(int adminID)
	{
		AdminID = adminID;
	}
	
	
	/**
	 * ��ȡ����ID
	 * @return
	 */
	public int getCashFlowID()
	{
		return CashFlowID;
	}
	
	
	/**
	 * ���ÿ���ID
	 * @param cashFlowID
	 */
	public void setCashFlowID(int cashFlowID)
	{
		CashFlowID = cashFlowID;
	}
	
	
	/**
	 * ��ȡ�޸�ʱ��
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * �����޸�ʱ��
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate)
	{
		ModifyDate = modifyDate;
	}
	
	
	
}
