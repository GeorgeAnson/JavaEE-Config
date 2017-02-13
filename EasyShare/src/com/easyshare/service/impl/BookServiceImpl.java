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
		//��ȡ������Ϣ
		ManageBook manageBook=bookDao.getManageBookByManageBookID(manageBookID);
		//��������Ϣ���ڣ����ȡ������鱾��Ϣ
		if(manageBook!=null)
		{
			Book book=bookDao.getBookById(manageBook.getBookID());
			//��������鱾��Ϣ���ڣ��������Ϣ������
			if(book!=null)
			{
				book.setRemain(book.getRemain()+1);//�鱾��������1
				
				if(book.getRemain()==1)//��������0����1Ϊ1�����޸��鱾���״̬
				{
					book.setStatus(1);
				}
				//���������������������������Ĭ��������һ��
				if(book.getRemain()>book.getAmount())
				{
					book.setRemain(book.getAmount());
				}
			manageBook.setBook(book);//�����鱾��Ϣ����������Ϣ
				manageBook.setReturnDate(new java.sql.Date(new java.util.Date().getTime()));//���û���ʱ��
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
