package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * �������ʵ��
 * @author Administrator
 *
 */
public class ManageDebris  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5592484998042158249L;

	
	private int AdminID;//����ԱID
	private int Debris;//����ID
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
	public int getDebris()
	{
		return Debris;
	}
	
	
	
	/**
	 * ��������ID
	 * @param debris
	 */
	public void setDebris(int debris)
	{
		Debris = debris;
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
