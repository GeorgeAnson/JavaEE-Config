package com.easyshare.entity;

import java.io.Serializable;

/**
 * Stranger实体
 * 存储联系我们模块的信息
 * @author Administrator
 *
 */
public class Stranger implements Serializable{

	private static final long serialVersionUID = 2220814450013184817L;

	private int StrangerID=-1;//陌生人发送人ID
	private String StrangerName=null;//陌生人姓名
	private String StrangerEmail=null;//陌生人邮箱
	private String Content=null;//发送的内容
	
	
	
	public Stranger()
	{
		
	}
	
	
	public Stranger(int strangerID)
	{
		this.StrangerID=strangerID;
	}
	
	
	/**
	 * 获取陌生人ID号
	 * @return
	 */
	public int getStrangerID()
	{
		return StrangerID;
	}
	
	
	/**
	 * 获取陌生人姓名
	 * @return
	 */
	public String getStrangerName()
	{
		return StrangerName;
	}


	/**
	 * 设置陌生人姓名
	 * @param strangerName
	 */
	public void setStrangerName(String strangerName)
	{
		StrangerName = strangerName;
	}


	/**
	 * 设置陌生人ID号
	 * @param strangerID
	 */
	public void setStrangerID(int strangerID)
	{
		StrangerID = strangerID;
	}
	
	
	/**
	 * 获取陌生人邮箱
	 * @return
	 */
	public String getStrangerEmail()
	{
		return StrangerEmail;
	}
	
	
	/**
	 * 设置陌生人邮箱
	 * @param strangerEmail
	 */
	public void setStrangerEmail(String strangerEmail)
	{
		StrangerEmail = strangerEmail;
	}
	
	
	/**
	 * 获取发送的内容
	 * @return
	 */
	public String getContent()
	{
		return Content;
	}
	
	
	/**
	 * 设置发送的内容
	 * @param content
	 */
	public void setContent(String content)
	{
		Content = content;
	}
	
	
}
