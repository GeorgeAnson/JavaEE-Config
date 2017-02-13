package com.easyshare.service;

import java.util.List;

import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;


public interface BookService {

	/**
	 * 获取书本信息及书本管理信息
	 * @param commonID
	 * 			int
	 * 			CommonID
	 * @return
	 * 		List<ManageBook>
	 */
	List<ManageBook> getManageBooksInfo(int commonID,List<Book> books);
	
	/**
	 * 查找是否存在这本书且是否可借
	 * @param bookID
	 * 			int
	 * @return
	 * 		boolean
	 */
	boolean isExistBook(int bookID,ManageBook manageBook);
	
	
	/**
	 * 查找书本是否存在
	 * @param book
	 * 		Book
	 * @return
	 * 		Boolean
	 */
	boolean isExistBook(Book book);
	
	/**
	 * 查找某一条还书信息
	 * @param manageBoosID
	 * 		ManageBookID
	 * @return
	 * 		ManageBook
	 */
	ManageBook manageBookReturn(int manageBoosID);
	
	/**
	 * 配对所有借书管理信息与书本信息
	 * @param manageBooks
	 * @param books
	 * @return
	 */
	List<ManageBook> getManageBooksInfo(List<ManageBook> manageBooks, List<Book> books);
	
}
