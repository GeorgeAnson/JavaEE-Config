package com.easyshare.entity;

import java.io.Serializable;

/**
 * �豸ʵ��
 * @author Administrator
 *
 */
public class Equipment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6720389096092389639L;
	
	private int EquipmentID;//�豸ID
	private String EquipmentName=null;//�豸����
	private double Price;//�豸�۸�
	private int Amount;//�豸����
	private int Remain;//�豸����
	private int Status;//�豸״̬
	private String Sketch=null;
	private int Opr;//�豸����
	
	public Equipment()
	{
		
	}
	
	
	public Equipment(int equipmentID)
	{
		this.EquipmentID=equipmentID;
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


	/**
	 * ��ȡ�豸����
	 * @return
	 */
	public String getEquipmentName()
	{
		return EquipmentName;
	}


	/**
	 * �����豸ID
	 * @param equipmentName
	 */
	public void setEquipmentName(String equipmentName)
	{
		EquipmentName = equipmentName;
	}


	/**
	 * ��ȡ�豸�۸�
	 * @return
	 */
	public double getPrice()
	{
		return Price;
	}


	/**
	 * �����豸�۸�
	 * @param price
	 */
	public void setPrice(double price)
	{
		Price = price;
	}


	/**
	 * ��ȡ�豸����
	 * @return
	 */
	public int getAmount()
	{
		return Amount;
	}


	/**
	 * �����豸����
	 * @param amount
	 */
	public void setAmount(int amount)
	{
		Amount = amount;
	}


	/**
	 * ��ȡ�豸����
	 * @return
	 * 		Int
	 * 		Remain
	 */
	public int getRemain() {
		return Remain;
	}


	/**
	 * �����豸����
	 * @param remain
	 * 		Int
	 */
	public void setRemain(int remain) {
		Remain = remain;
	}


	/**
	 * ��ȡ�豸״̬
	 * @return
	 * 		Int
	 */
	public int getStatus() {
		return Status;
	}

	
	/**
	 * �����豸״̬
	 * @param status
	 * 		int
	 */
	public void setStatus(int status) {
		Status = status;
	}


	/**
	 * ��ȡ�豸����
	 * @return
	 * 		String   Sketch
	 */
	public String getSketch() {
		return Sketch;
	}


	/**
	 * �����豸����
	 * @param sketch
	 * 		String  Sketch
	 */
	public void setSketch(String sketch) {
		Sketch = sketch;
	}


	/**
	 * ��ȡ�豸����
	 * @return
	 * 		int
	 * 			0-���
	 * 			1-�޸�
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * �����豸����
	 * @param opr
	 * 		int
	 * 			0-���
	 * 			1-�޸�
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}
	
	
}
