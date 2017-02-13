package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * �鱾ʵ��
 * @author Administrator
 *
 */
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2170442828810809534L;

	
	private int BookID;//�鱾ID
	private String BookName=null;//�鱾����
	private String Author=null;//����
	private String PublishCompany=null;//����������
	private int Amount;//�������
	private int Remain;//�������
	private double Price;//�鱾�۸�
	private Date ModifyDate;//�޸�ʱ��
	private int Status;//�鱾״̬
	private int Opr;//�鱾����


	public Book()
	{
		
	}
	
	
	public Book(int bookID)
	{
		this.BookID=bookID;
	}


	/**
	 * ��ȡ�鱾ID
	 * @return
	 */
	public int getBookID()
	{
		return BookID;
	}


	/**
	 * �����鱾ID
	 * @param bookID
	 */
	public void setBookID(int bookID)
	{
		BookID = bookID;
	}


	/**
	 * ��ȡ�鱾����
	 * @return
	 */
	public String getBookName()
	{
		return BookName;
	}


	/**
	 * �����鱾����
	 * @param bookName
	 */
	public void setBookName(String bookName)
	{
		BookName = bookName;
	}


	/**
	 * ��ȡ������
	 * @return
	 */
	public String getAuthor()
	{
		return Author;
	}


	/**
	 * ����������
	 * @param author
	 */
	public void setAuthor(String author) 
	{
		Author = author;
	}


	/**
	 * ��ȡ����������
	 * @return
	 */
	public String getPublishCompany() 
	{
		return PublishCompany;
	}


	/**
	 * ���ó���������
	 * @param publishCompany
	 */
	public void setPublishCompany(String publishCompany)
	{
		PublishCompany = publishCompany;
	}


	/**
	 * ��ȡ�鱾����
	 * @return
	 */
	public int getAmount()
	{
		return Amount;
	}


	/**
	 * �����鱾����
	 * @param amount
	 */
	public void setAmount(int amount)
	{
		Amount = amount;
	}


	/**
	 * ��ȡ�������
	 * @return
	 * 		int
	 * 		Remain
	 */
	public int getRemain() {
		return Remain;
	}


	/**
	 * ���ÿ������
	 * @param remain
	 * 		int
	 * 			Remain
	 */
	public void setRemain(int remain) {
		Remain = remain;
	}


	/**
	 * ��ȡ�鱾�۸�
	 * @return
	 */
	public double getPrice()
	{
		return Price;
	}


	/**
	 * �����鱾�۸�
	 * @param price
	 */
	public void setPrice(double price)
	{
		Price = price;
	}
	
	
	/**
	 * ��ȡ�޸�ʱ��
	 * @return
	 */
	public Date getModifyDate()
	{
		return ModifyDate;
	}
	
	
	/**
	 * �����޸�ʱ��
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) 
	{
		ModifyDate = modifyDate;
	}


	/**
	 * ��ȡ�鱾״̬
	 * @return
	 */
	public int getStatus()
	{
		return Status;
	}


	/**
	 * �����鱾״̬
	 * @param status
	 */
	public void setStatus(int status)
	{
		Status = status;
	}


	/**
	 * ���鱾�Ĳ���
	 * @return
	 * 		int
	 * 			0-���
	 * 			1-�޸�
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * ���ö��鱾�Ĳ���
	 * @param opr
	 * 		int
	 * 			0-���
	 * 			1-�޸�
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}
	
	
	
	
}
