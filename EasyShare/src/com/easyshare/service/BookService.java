package com.easyshare.service;

import java.util.List;

import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;


public interface BookService {

	/**
	 * ��ȡ�鱾��Ϣ���鱾������Ϣ
	 * @param commonID
	 * 			int
	 * 			CommonID
	 * @return
	 * 		List<ManageBook>
	 */
	List<ManageBook> getManageBooksInfo(int commonID,List<Book> books);
	
	/**
	 * �����Ƿ�����Ȿ�����Ƿ�ɽ�
	 * @param bookID
	 * 			int
	 * @return
	 * 		boolean
	 */
	boolean isExistBook(int bookID,ManageBook manageBook);
	
	
	/**
	 * �����鱾�Ƿ����
	 * @param book
	 * 		Book
	 * @return
	 * 		Boolean
	 */
	boolean isExistBook(Book book);
	
	/**
	 * ����ĳһ��������Ϣ
	 * @param manageBoosID
	 * 		ManageBookID
	 * @return
	 * 		ManageBook
	 */
	ManageBook manageBookReturn(int manageBoosID);
	
	/**
	 * ������н��������Ϣ���鱾��Ϣ
	 * @param manageBooks
	 * @param books
	 * @return
	 */
	List<ManageBook> getManageBooksInfo(List<ManageBook> manageBooks, List<Book> books);
	
}
