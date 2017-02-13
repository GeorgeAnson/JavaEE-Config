package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * �豸����ʵ��
 * @author Administrator
 *
 */
public class ManageEquipment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7870950867588660282L;

	private int ManageEquipmentID;//�豸����ID
	private int CommonID;//����ID
	private int EquipmentID;//�豸ID
	private Date BorrowDate=null;//�豸����ʱ��
	private Date ReturnDate=null;//�豸�黹ʱ��
	private Equipment equipment=null;//�豸����
	private Object user=null;//�û�����
	
	
	/**
	 * ��ȡ�豸����ID
	 * @return
	 * 		Int ManageEquipmentID
	 */
	public int getManageEquipmentID() {
		return ManageEquipmentID;
	}


	/**
	 * �����豸����ID
	 * @param manageEquipmentID
	 * 		Int
	 */
	public void setManageEquipmentID(int manageEquipmentID) {
		ManageEquipmentID = manageEquipmentID;
	}


	/**
	 * ��ȡ�û�����ID
	 * @return
	 * 		int	CommonID
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * �����û�����ID
	 * @param commonID
	 * 		Int
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * ��ȡ�豸���ʱ��
	 * @return
	 * 		Date
	 * 			BorrowDate
	 */
	public Date getBorrowDate() {
		return BorrowDate;
	}


	/**
	 * �����豸���ʱ��
	 * @param borrowDate
	 * 		Date
	 */
	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}


	/**
	 * ��ȡ�豸�黹ʱ��
	 * @return
	 * 		Date 	ReturnDate
	 */
	public Date getReturnDate() {
		return ReturnDate;
	}


	/**
	 * �����豸�黹ʱ��
	 * @param returnDate
	 * 		Date 	ReturnDate
	 */
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}


	/**
	 * ��ȡ�豸����
	 * @return
	 * 		Equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}


	/**
	 * �豸�豸����
	 * @param equipment
	 * 		Equipment
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}


	/**
	 * ��ȡ�û�����
	 * @return
	 * 		Object
	 */
	public Object getUser() {
		return user;
	}


	/**
	 * �����豸����
	 * @param user
	 * 			Object
	 */
	public void setUser(Object user) {
		this.user = user;
	}


	/**
	 * ��ȡ�豸ID
	 * @return
	 */
	public int getEquipmentID()
	{
		return EquipmentID;
	}
	
	
	/**
	 * �����豸ID
	 * @param equipmentID
	 */
	public void setEquipmentID(int equipmentID)
	{
		EquipmentID = equipmentID;
	}
}
