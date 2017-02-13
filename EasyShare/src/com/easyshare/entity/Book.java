package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 书本实体
 * @author Administrator
 *
 */
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2170442828810809534L;

	
	private int BookID;//书本ID
	private String BookName=null;//书本名称
	private String Author=null;//作者
	private String PublishCompany=null;//出版社名称
	private int Amount;//库存总量
	private int Remain;//库存余量
	private double Price;//书本价格
	private Date ModifyDate;//修改时间
	private int Status;//书本状态
	private int Opr;//书本操作


	public Book()
	{
		
	}
	
	
	public Book(int bookID)
	{
		this.BookID=bookID;
	}


	/**
	 * 获取书本ID
	 * @return
	 */
	public int getBookID()
	{
		return BookID;
	}


	/**
	 * 设置书本ID
	 * @param bookID
	 */
	public void setBookID(int bookID)
	{
		BookID = bookID;
	}


	/**
	 * 获取书本名称
	 * @return
	 */
	public String getBookName()
	{
		return BookName;
	}


	/**
	 * 设置书本名称
	 * @param bookName
	 */
	public void setBookName(String bookName)
	{
		BookName = bookName;
	}


	/**
	 * 获取作者名
	 * @return
	 */
	public String getAuthor()
	{
		return Author;
	}


	/**
	 * 设置作者名
	 * @param author
	 */
	public void setAuthor(String author) 
	{
		Author = author;
	}


	/**
	 * 获取出版社名称
	 * @return
	 */
	public String getPublishCompany() 
	{
		return PublishCompany;
	}


	/**
	 * 设置出版社名称
	 * @param publishCompany
	 */
	public void setPublishCompany(String publishCompany)
	{
		PublishCompany = publishCompany;
	}


	/**
	 * 获取书本数量
	 * @return
	 */
	public int getAmount()
	{
		return Amount;
	}


	/**
	 * 设置书本数量
	 * @param amount
	 */
	public void setAmount(int amount)
	{
		Amount = amount;
	}


	/**
	 * 获取库存余量
	 * @return
	 * 		int
	 * 		Remain
	 */
	public int getRemain() {
		return Remain;
	}


	/**
	 * 设置库存余量
	 * @param remain
	 * 		int
	 * 			Remain
	 */
	public void setRemain(int remain) {
		Remain = remain;
	}


	/**
	 * 获取书本价格
	 * @return
	 */
	public double getPrice()
	{
		return Price;
	}


	/**
	 * 设置书本价格
	 * @param price
	 */
	public void setPrice(double price)
	{
		Price = price;
	}
	
	
	/**
	 * 获取修改时间
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * 设置修改时间
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) 
	{
		ModifyDate = modifyDate;
	}


	/**
	 * 获取书本状态
	 * @return
	 */
	public int getStatus()
	{
		return Status;
	}


	/**
	 * 设置书本状态
	 * @param status
	 */
	public void setStatus(int status)
	{
		Status = status;
	}


	/**
	 * 对书本的操作
	 * @return
	 * 		int
	 * 			0-添加
	 * 			1-修改
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * 设置对书本的操作
	 * @param opr
	 * 		int
	 * 			0-添加
	 * 			1-修改
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}
	
	
	
	
}
