package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;

public interface BookDao {

	
	/**
	 * ͨ���鱾id�����鱾��Ϣ
	 * @param bookID
	 * 			�鱾ID
	 * @return
	 * 			Book����
	 */
	Book getBookById(int bookID);
	
	
	/**
	 * ͨ���鱾���ƻ����鱾���߲����鱾����
	 * ���Ǹ��������������������鱾���ܲ�ֹһ��
	 * @param condition
	 * 			�鱾���ƻ����鱾����
	 * @return
	 * 			List<Book>����
	 */
	List<Book> getBookByCondition(String condition);
	
	
	/**
	 * �����鱾������Ϣ
	 * @param commonID
	 * 			int	
	 * 			��ǰ�û���CommonID
	 * @return
	 * 		List<ManageBook>
	 */
	List<ManageBook> getBookByBorrowUserCommonID(int commonID);
	
	
	/**
	 * ����һ���鱾��Ϣ
	 * @param book
	 * 			Book����
	 */
	void save(Book book);
	
	
	/**
	 * ����һ���鱾����Ϣ
	 * @param book
	 * 			Book����
	 */
	void update(Book book);
	
	/**
	 * ����һ��������Ϣ
	 * @param manageBook
	 * 			ManageBook
	 */
	void saveManageBook(ManageBook manageBook);
	
	/**
	 * ���¹����鱾��
	 * @param manageBook
	 * 		ManageBook
	 */
	void update(ManageBook manageBook);
	
	
	/**
	 * ͨ����������ID�Ų��ҽ�����Ϣ
	 * @param manageBookID
	 * 			int
	 * @return
	 * 			ManageBook
	 */
	ManageBook getManageBookByManageBookID(int manageBookID);
	
}
