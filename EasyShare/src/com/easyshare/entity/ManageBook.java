package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * �鼮����ʵ��
 * @author Administrator
 *
 */
public class ManageBook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8508862906730506862L;

	private int ManageBookID;//���ݼ�¼ID
	private int CommonID;//����ԱID
	private int BookID;//�鱾ID
	private Date BorrowDate;//����ʱ��
	private Date ReturnDate;//����ʱ��
	
	private Book book=null;//Book
	
	private String LoginName=null;//�û���¼������Ӧ��CommonID
	
	public String getLoginName() {
		return LoginName;
	}


	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	/**
	 * ��ȡ�鱾
	 * @return
	 * 		Book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * �����鱾��Ϣ
	 * 
	 * @param books
	 * 		Book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * ��ȡ����ԱID
	 * @return
	 */
	public int getManageBookID()
	{
		return ManageBookID;
	}
	
	
	/**
	 * ���ù���ԱID
	 * @param adminID
	 */
	public void setManageBookID(int manageBookID)
	{
		ManageBookID = manageBookID;
	}
	
	/**
	 * ���ع���ID
	 * @return
	 * 			CommonID
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * ���ù���ID
	 * @param commonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
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
	 * ��ȡ����ʱ��
	 * @return
	 * 		Date
	 * 		BorrowDate
	 */
	public Date getBorrowDate() {
		return BorrowDate;
	}


	/**
	 * ���ý���ʱ��
	 * @param borrowDate
	 * 			Date
	 */
	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}


	/**
	 * ��ȡ����ʱ��
	 * @return
	 * 		Date
	 * 			ReturnDate
	 */
	public Date getReturnDate() {
		return ReturnDate;
	}


	/**
	 * ���û���ʱ��
	 * @param returnDate
	 * 		Date
	 * 			ReturnDate
	 */
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	
}
