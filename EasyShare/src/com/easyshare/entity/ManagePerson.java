package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;


/**
 * ��Ա����ʵ��
 * @author Administrator
 *
 */
public class ManagePerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -432445775078458177L;

	
	private int AdminID;//����ԱID
	private int UserConnectionID;//�û���Ϣ��ϵID
	private Date ModifyDate;//��Ϣ�޸�����
	
	
	
	/**
	 *��ȡ����ԱID 
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
	 * ��ȡ�û���Ϣ��ϵID
	 * @return
	 */
	public int getUserConnectionID()
	{
		return UserConnectionID;
	}
	
	
	/**
	 * �����û���Ϣ��ϵID
	 * @param userConnectionID
	 */
	public void setUserConnectionID(int userConnectionID)
	{
		UserConnectionID = userConnectionID;
	}
	
	
	/**
	 * ��ȡ��Ϣ�޸�����
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * ������Ϣ�޸�����
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		ModifyDate = modifyDate;
	}
	
	
}
