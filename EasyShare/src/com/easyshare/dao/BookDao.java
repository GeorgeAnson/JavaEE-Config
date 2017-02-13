package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;

public interface BookDao {

	
	/**
	 * 通过书本id查找书本信息
	 * @param bookID
	 * 			书本ID
	 * @return
	 * 			Book对象
	 */
	Book getBookById(int bookID);
	
	
	/**
	 * 通过书本名称或者书本作者查找书本对象
	 * 若是根据作者条件检索到的书本可能不止一类
	 * @param condition
	 * 			书本名称或者书本作者
	 * @return
	 * 			List<Book>集合
	 */
	List<Book> getBookByCondition(String condition);
	
	
	/**
	 * 查找书本管理信息
	 * @param commonID
	 * 			int	
	 * 			当前用户的CommonID
	 * @return
	 * 		List<ManageBook>
	 */
	List<ManageBook> getBookByBorrowUserCommonID(int commonID);
	
	
	/**
	 * 保存一类书本信息
	 * @param book
	 * 			Book对象
	 */
	void save(Book book);
	
	
	/**
	 * 更新一类书本的信息
	 * @param book
	 * 			Book对象
	 */
	void update(Book book);
	
	/**
	 * 保存一条借书信息
	 * @param manageBook
	 * 			ManageBook
	 */
	void saveManageBook(ManageBook manageBook);
	
	/**
	 * 更新管理书本表
	 * @param manageBook
	 * 		ManageBook
	 */
	void update(ManageBook manageBook);
	
	
	/**
	 * 通过借书序列ID号查找借书信息
	 * @param manageBookID
	 * 			int
	 * @return
	 * 			ManageBook
	 */
	ManageBook getManageBookByManageBookID(int manageBookID);
	
}
