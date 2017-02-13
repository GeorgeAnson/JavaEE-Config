package com.easyshare.entity;

import java.io.Serializable;


/**
 * 杂物实体
 * @author Administrator
 *
 */
public class DebrisProperty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6303401028531228374L;

	
	
	private int DebrisID;//杂物ID
	private String DebrisName=null;//杂物名称
	private int Amount;//数量
	
	
	public DebrisProperty()
	{
		
	}
	
	public DebrisProperty(int debrisID)
	{
		this.DebrisID=debrisID;
	}

	
	/**
	 * 获取杂物ID
	 * @return
	 */
	public int getDebrisID()
	{
		return DebrisID;
	}

	
	
	/**
	 * 设置杂物ID
	 * @param debrisID
	 */
	public void setDebrisID(int debrisID)
	{
		DebrisID = debrisID;
	}

	
	
	/**
	 * 获取杂物名称
	 * @return
	 */
	public String getDebrisName()
	{
		return DebrisName;
	}

	
	
	/**
	 * 设置杂物ID
	 * @param debrisName
	 */
	public void setDebrisName(String debrisName)
	{
		DebrisName = debrisName;
	}

	
	
	/**
	 * 获取该杂物数量
	 * @return
	 */
	public int getAmount()
	{
		return Amount;
	}

	
	/**
	 * 设置该杂物数量
	 * @param amount
	 */
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	
	
	
}
