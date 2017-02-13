package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 设备管理实体
 * @author Administrator
 *
 */
public class ManageEquipment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7870950867588660282L;

	private int ManageEquipmentID;//设备管理ID
	private int CommonID;//公共ID
	private int EquipmentID;//设备ID
	private Date BorrowDate=null;//设备借用时间
	private Date ReturnDate=null;//设备归还时间
	private Equipment equipment=null;//设备对象
	private Object user=null;//用户对象
	
	
	/**
	 * 获取设备管理ID
	 * @return
	 * 		Int ManageEquipmentID
	 */
	public int getManageEquipmentID() {
		return ManageEquipmentID;
	}


	/**
	 * 设置设备管理ID
	 * @param manageEquipmentID
	 * 		Int
	 */
	public void setManageEquipmentID(int manageEquipmentID) {
		ManageEquipmentID = manageEquipmentID;
	}


	/**
	 * 获取用户公共ID
	 * @return
	 * 		int	CommonID
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * 设置用户公共ID
	 * @param commonID
	 * 		Int
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * 获取设备借出时间
	 * @return
	 * 		Date
	 * 			BorrowDate
	 */
	public Date getBorrowDate() {
		return BorrowDate;
	}


	/**
	 * 设置设备借出时间
	 * @param borrowDate
	 * 		Date
	 */
	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}


	/**
	 * 获取设备归还时间
	 * @return
	 * 		Date 	ReturnDate
	 */
	public Date getReturnDate() {
		return ReturnDate;
	}


	/**
	 * 设置设备归还时间
	 * @param returnDate
	 * 		Date 	ReturnDate
	 */
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}


	/**
	 * 获取设备对象
	 * @return
	 * 		Equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}


	/**
	 * 设备设备对象
	 * @param equipment
	 * 		Equipment
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}


	/**
	 * 获取用户对象
	 * @return
	 * 		Object
	 */
	public Object getUser() {
		return user;
	}


	/**
	 * 设置设备对象
	 * @param user
	 * 			Object
	 */
	public void setUser(Object user) {
		this.user = user;
	}


	/**
	 * 获取设备ID
	 * @return
	 */
	public int getEquipmentID()
	{
		return EquipmentID;
	}
	
	
	/**
	 * 设置设备ID
	 * @param equipmentID
	 */
	public void setEquipmentID(int equipmentID)
	{
		EquipmentID = equipmentID;
	}
}
