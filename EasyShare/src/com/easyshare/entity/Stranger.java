package com.easyshare.entity;

import java.io.Serializable;

/**
 * Strangerʵ��
 * �洢��ϵ����ģ�����Ϣ
 * @author Administrator
 *
 */
public class Stranger implements Serializable{

	private static final long serialVersionUID = 2220814450013184817L;

	private int StrangerID=-1;//İ���˷�����ID
	private String StrangerName=null;//İ��������
	private String StrangerEmail=null;//İ��������
	private String Content=null;//���͵�����
	
	
	
	public Stranger()
	{
		
	}
	
	
	public Stranger(int strangerID)
	{
		this.StrangerID=strangerID;
	}
	
	
	/**
	 * ��ȡİ����ID��
	 * @return
	 */
	public int getStrangerID()
	{
		return StrangerID;
	}
	
	
	/**
	 * ��ȡİ��������
	 * @return
	 */
	public String getStrangerName()
	{
		return StrangerName;
	}


	/**
	 * ����İ��������
	 * @param strangerName
	 */
	public void setStrangerName(String strangerName)
	{
		StrangerName = strangerName;
	}


	/**
	 * ����İ����ID��
	 * @param strangerID
	 */
	public void setStrangerID(int strangerID)
	{
		StrangerID = strangerID;
	}
	
	
	/**
	 * ��ȡİ��������
	 * @return
	 */
	public String getStrangerEmail()
	{
		return StrangerEmail;
	}
	
	
	/**
	 * ����İ��������
	 * @param strangerEmail
	 */
	public void setStrangerEmail(String strangerEmail)
	{
		StrangerEmail = strangerEmail;
	}
	
	
	/**
	 * ��ȡ���͵�����
	 * @return
	 */
	public String getContent()
	{
		return Content;
	}
	
	
	/**
	 * ���÷��͵�����
	 * @param content
	 */
	public void setContent(String content)
	{
		Content = content;
	}
	
	
}
