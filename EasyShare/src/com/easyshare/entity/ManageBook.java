package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 书籍管理实体
 * @author Administrator
 *
 */
public class ManageBook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8508862906730506862L;

	private int ManageBookID;//数据记录ID
	private int CommonID;//管理员ID
	private int BookID;//书本ID
	private Date BorrowDate;//借书时间
	private Date ReturnDate;//还书时间
	
	private Book book=null;//Book
	
	private String LoginName=null;//用户登录名，对应于CommonID
	
	public String getLoginName() {
		return LoginName;
	}


	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	/**
	 * 获取书本
	 * @return
	 * 		Book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * 设置书本信息
	 * 
	 * @param books
	 * 		Book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * 获取管理员ID
	 * @return
	 */
	public int getManageBookID()
	{
		return ManageBookID;
	}
	
	
	/**
	 * 设置管理员ID
	 * @param adminID
	 */
	public void setManageBookID(int manageBookID)
	{
		ManageBookID = manageBookID;
	}
	
	/**
	 * 返回公共ID
	 * @return
	 * 			CommonID
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * 设置公共ID
	 * @param commonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
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
	 * 获取借书时间
	 * @return
	 * 		Date
	 * 		BorrowDate
	 */
	public Date getBorrowDate() {
		return BorrowDate;
	}


	/**
	 * 设置借书时间
	 * @param borrowDate
	 * 			Date
	 */
	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}


	/**
	 * 获取还书时间
	 * @return
	 * 		Date
	 * 			ReturnDate
	 */
	public Date getReturnDate() {
		return ReturnDate;
	}


	/**
	 * 设置还书时间
	 * @param returnDate
	 * 		Date
	 * 			ReturnDate
	 */
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	
}
