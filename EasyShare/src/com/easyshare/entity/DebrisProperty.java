package com.easyshare.entity;

import java.io.Serializable;


/**
 * ����ʵ��
 * @author Administrator
 *
 */
public class DebrisProperty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6303401028531228374L;

	
	
	private int DebrisID;//����ID
	private String DebrisName=null;//��������
	private int Amount;//����
	
	
	public DebrisProperty()
	{
		
	}
	
	public DebrisProperty(int debrisID)
	{
		this.DebrisID=debrisID;
	}

	
	/**
	 * ��ȡ����ID
	 * @return
	 */
	public int getDebrisID()
	{
		return DebrisID;
	}

	
	
	/**
	 * ��������ID
	 * @param debrisID
	 */
	public void setDebrisID(int debrisID)
	{
		DebrisID = debrisID;
	}

	
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public String getDebrisName()
	{
		return DebrisName;
	}

	
	
	/**
	 * ��������ID
	 * @param debrisName
	 */
	public void setDebrisName(String debrisName)
	{
		DebrisName = debrisName;
	}

	
	
	/**
	 * ��ȡ����������
	 * @return
	 */
	public int getAmount()
	{
		return Amount;
	}

	
	/**
	 * ���ø���������
	 * @param amount
	 */
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	
	
	
}
