package com.easyshare.entity;

import java.io.Serializable;

/**
 * 设备实体
 * @author Administrator
 *
 */
public class Equipment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6720389096092389639L;
	
	private int EquipmentID;//设备ID
	private String EquipmentName=null;//设备名称
	private double Price;//设备价格
	private int Amount;//设备数量
	private int Remain;//设备余量
	private int Status;//设备状态
	private String Sketch=null;
	private int Opr;//设备操作
	
	public Equipment()
	{
		
	}
	
	
	public Equipment(int equipmentID)
	{
		this.EquipmentID=equipmentID;
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


	/**
	 * 获取设备名称
	 * @return
	 */
	public String getEquipmentName()
	{
		return EquipmentName;
	}


	/**
	 * 设置设备ID
	 * @param equipmentName
	 */
	public void setEquipmentName(String equipmentName)
	{
		EquipmentName = equipmentName;
	}


	/**
	 * 获取设备价格
	 * @return
	 */
	public double getPrice()
	{
		return Price;
	}


	/**
	 * 设置设备价格
	 * @param price
	 */
	public void setPrice(double price)
	{
		Price = price;
	}


	/**
	 * 获取设备数量
	 * @return
	 */
	public int getAmount()
	{
		return Amount;
	}


	/**
	 * 设置设备数量
	 * @param amount
	 */
	public void setAmount(int amount)
	{
		Amount = amount;
	}


	/**
	 * 获取设备余量
	 * @return
	 * 		Int
	 * 		Remain
	 */
	public int getRemain() {
		return Remain;
	}


	/**
	 * 设置设备余量
	 * @param remain
	 * 		Int
	 */
	public void setRemain(int remain) {
		Remain = remain;
	}


	/**
	 * 获取设备状态
	 * @return
	 * 		Int
	 */
	public int getStatus() {
		return Status;
	}

	
	/**
	 * 设置设备状态
	 * @param status
	 * 		int
	 */
	public void setStatus(int status) {
		Status = status;
	}


	/**
	 * 获取设备简述
	 * @return
	 * 		String   Sketch
	 */
	public String getSketch() {
		return Sketch;
	}


	/**
	 * 设置设备简述
	 * @param sketch
	 * 		String  Sketch
	 */
	public void setSketch(String sketch) {
		Sketch = sketch;
	}


	/**
	 * 获取设备操作
	 * @return
	 * 		int
	 * 			0-添加
	 * 			1-修改
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * 设置设备操作
	 * @param opr
	 * 		int
	 * 			0-添加
	 * 			1-修改
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}
	
	
}
