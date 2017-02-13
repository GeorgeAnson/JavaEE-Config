package com.easyshare.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyshare.dao.BookDao;
import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.BookDaoImpl;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;
import com.easyshare.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao=new BookDaoImpl();
	@Autowired
	private UserDao userDao=new UserDaoImpl();
	
	
	@Override
	public List<ManageBook> getManageBooksInfo(int commonID,List<Book> books) {
		List<ManageBook> manageBooks=new ArrayList<ManageBook>();
		manageBooks=bookDao.getBookByBorrowUserCommonID(commonID);
		for(ManageBook item:manageBooks)
		{
			for(Book bitem:books)
			{
				if(bitem.getBookID()==item.getBookID())
				{
					item.setBook(bitem);
				}
			}
		}
		return manageBooks;
	}


	@Override
	public boolean isExistBook(int bookID,ManageBook manageBook) {
		Book book=bookDao.getBookById(bookID);
		if(book!=null&&book.getRemain()!=0)
		{
			book.setRemain(book.getRemain()-1);
			if(book.getRemain()==0)
			{
				book.setStatus(0);
			}else
			{
				book.setStatus(1);
			}
			book.setModifyDate(new Date(new java.util.Date().getTime()));
			manageBook.setBook(book);
			return true;
		}
		return false;
	}


	@Override
	public boolean isExistBook(Book book) {
		Book checkBook=bookDao.getBookById(book.getBookID());
		if(checkBook!=null)
		{
			if(book.getRemain()>0)
			{
				book.setStatus(1);
			}else
			{
				book.setStatus(0);
			}
			book.setModifyDate(new Date(new java.util.Date().getTime()));
			return true;
		}
		return false;
	}


	@Override
	public ManageBook manageBookReturn(int manageBookID) {
		//获取借书信息
		ManageBook manageBook=bookDao.getManageBookByManageBookID(manageBookID);
		//若借书信息存在，则获取所借的书本信息
		if(manageBook!=null)
		{
			Book book=bookDao.getBookById(manageBook.getBookID());
			//若所借的书本信息村在，则更新信息，还书
			if(book!=null)
			{
				book.setRemain(book.getRemain()+1);//书本余量增加1
				
				if(book.getRemain()==1)//若余量从0增加1为1，则修改书本库存状态
				{
					book.setStatus(1);
				}
				//如果还书余量超过总量，则将余量默认与总量一致
				if(book.getRemain()>book.getAmount())
				{
					book.setRemain(book.getAmount());
				}
			manageBook.setBook(book);//保存书本信息与借书管理信息
				manageBook.setReturnDate(new java.sql.Date(new java.util.Date().getTime()));//设置还书时间
			}
		}
		return manageBook;
	}


	@Override
	public List<ManageBook> getManageBooksInfo(List<ManageBook> manageBooks, List<Book> books) {
		
		for(ManageBook item:manageBooks)
		{
			item.setLoginName(userDao.getUserInfoByCommonId(item.getCommonID()).getLoginName());
			for(Book bitem:books)
			{
				if(bitem.getBookID()==item.getBookID())
				{
					item.setBook(bitem);
				}
			}
		}
		return manageBooks;
	}

}
