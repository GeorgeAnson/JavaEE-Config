package com.easyshare.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.BookDao;
import com.easyshare.dao.jdbc.BookDaoImpl;
import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.globle.Constant;
import com.easyshare.service.BookService;
import com.easyshare.service.impl.BookServiceImpl;
import com.easyshare.utils.Utils;

@Component
public class BookAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4772382750423969670L;
	
	@Autowired
	private BookDao bookDao=new BookDaoImpl();
	
	private BookService bookService=new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String initType=request.getParameter("type");
		
		Object user=request.getSession().getAttribute(Constant.USER_KEY);
		
		//��ѯ�����鱾��Ϣ
		List<Book> books = bookDao.getBookByCondition(null);
		
		//���������鼮������Ϣ
		List<ManageBook> allBorrowedBooks=bookDao.getBookByBorrowUserCommonID(-1);
		//��ѯ��ǰ�û������鱾����Ϣ		
		List<ManageBook> manageBooks=bookService.getManageBooksInfo(getUserCommonID(user),books);
		//���鱾��Ϣ���浽session��
		request.getSession().setAttribute("books", books);
		request.getSession().setAttribute("borrowedBooks", manageBooks);
		
		if("book".equals(initType))
		{
			request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
			return;
		}else if("borrowBooks".equals(initType))
		{
			System.out.println("��ת������ҳ");
			
			allBorrowedBooks=bookService.getManageBooksInfo(allBorrowedBooks, books);
			request.getSession().setAttribute("allBorrowedBooks", allBorrowedBooks);
			request.getRequestDispatcher("/WEB-INF/pages/borrowedBooks.jsp").forward(request, response);
			return;
		}else if("borrow".equals(initType))
		{
			addManageBookInfo(request,response,user);
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
			return;
		}else if("return".equals(initType))
		{
			System.out.println("�黹�鱾");
			updateManageBookInfo(request,response,user);
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
			return;
		}else if("addbook".equals(initType))
		{
			if(((Utils.getUserCommonInfo(user)).getAdminType()==2||(Utils.getUserCommonInfo(user)).getAdminType()==0))
			{
				System.out.println("ִ������鱾����,�û�Ϊϵͳ����Ա�����鼮����Ա");
				addBook(request,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
			return;
		}else if("update".equals(initType))
		{
			System.out.println("�޸��鱾��Ϣ");
			if((Utils.getUserCommonInfo(user)).getAdminType()==2||(Utils.getUserCommonInfo(user)).getAdminType()==0)
			{
				System.out.println("ִ���鱾��Ϣ�޸Ĳ���");
				updateBookInfo(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
		}else if("delete".equals(initType))
		{
			String tmpId=request.getParameter("id").trim();
			if("".equals(tmpId)||tmpId==null)
			{
				System.out.println("û����Ҫɾ��������");
				request.setAttribute(Constant.ERROR, "û����Ҫɾ��������");
			}else
			{
				if((Utils.getUserCommonInfo(user)).getAdminType()==2||(Utils.getUserCommonInfo(user)).getAdminType()==0)
				{
					int bookID=Integer.parseInt(tmpId);
					deleteBook(request,response,bookID);
				}else
				{
					request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
					System.out.println(request.getAttribute(Constant.ERROR));
				}
			}
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
			return;
		}
	}
	
	/**
	 * ɾ���鱾��Ϣ
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param bookID
	 * 			�鱾���
	 * 				int
	 */
	private void deleteBook(HttpServletRequest request, HttpServletResponse response, int bookID) {
		Book book=bookDao.getBookById(bookID);
		book.setStatus(-1);
		bookDao.update(book);
	}

	/**
	 * �黹�鱾
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 */
	private void updateManageBookInfo(HttpServletRequest request, HttpServletResponse response, Object user) {
		
		int manageBookID=Integer.parseInt(request.getParameter("id").trim());
		ManageBook manageBook=bookService.manageBookReturn(manageBookID);
		//�Ƿ�������������Ϣ��û���򷵻�
		if(manageBook==null)
		{
			System.out.println("û�е�ǰ�����¼");
			return;
		}
	
		//���½�����Ϣ
		bookDao.update(manageBook);
	}

	/**
	 * �޸��鱾��Ϣ
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 */
	private void updateBookInfo(HttpServletRequest request, HttpServletResponse response, Object user) {
		
		int bookID=Integer.parseInt(request.getParameter("bookID").trim());
		String bookName=request.getParameter("bookName").trim();
		String bookAuthor=request.getParameter("bookAuthor").trim();
		double bookPrice=Double.parseDouble(request.getParameter("bookPrice").trim());
		String bookPubCompany=request.getParameter("bookPubCompany").trim();
		int bookAmount=Integer.parseInt(request.getParameter("bookAmount").trim());
		int bookRemain=Integer.parseInt(request.getParameter("bookNum").trim());
		
		//���û�����ʣ���鱾����������������Ĭ��Ϊ����
		if(bookAmount<bookRemain)
		{
			bookRemain=bookAmount;
		}
		
		//�����鱾��Ϣ
		Book book=new Book();
		book.setBookID(bookID);
		book.setBookName(bookName);
		book.setAuthor(bookAuthor);
		book.setPrice(bookPrice);
		book.setPublishCompany(bookPubCompany);
		book.setRemain(bookRemain);
		book.setAmount(bookAmount);
		book.setOpr(1);
		
		//�����鱾������
		if(!bookService.isExistBook(book))
		{
			System.out.println("�鱾�����ڣ��޷��޸�");
			return;
		}
		
		System.out.println(book.getModifyDate()+"time time");
		
		//������Ϣ
		bookDao.update(book);
	}

	/**
	 * ����������鱾��Ϣ����
	 * @param request 
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addManageBookInfo(HttpServletRequest request,HttpServletResponse response, Object user) {
		int bookID=Integer.parseInt(request.getParameter("bookID"));
		Date borrowDate=new Date(new java.util.Date().getTime());
		Date returnDate=null;
		ManageBook manageBook=new ManageBook();
		if(!bookService.isExistBook(bookID,manageBook))
		{
			System.out.println("�鱾���ɽ���߲�����");
			return;
		}
		
		manageBook.setBookID(bookID);
		manageBook.setCommonID(getUserCommonID(user));
		manageBook.setBorrowDate(borrowDate);
		manageBook.setReturnDate(returnDate);
		
		//������黹����Ϣ
		bookDao.saveManageBook(manageBook);
	}

	/**
	 * ��ȡuser��CommonID
	 * @param user
	 * 			Object User
	 * @return
	 * 			int  CommonID
	 */
	private int getUserCommonID(Object user) {
		int commonID = -1;
		if(user instanceof Student)
		{
			commonID=((Student) user).getCommonUserInfo().getCommonID();
		}else if(user instanceof Teacher)
		{
			commonID=((Teacher) user).getCommonUserInfo().getCommonID();
		}
		return commonID;
	}


	/**
	 * ���һ�������Ϣ
	 * @param request
	 * 			HttpServletRequest
	 * @param user
	 * 			Object
	 */
	private void addBook(HttpServletRequest request, Object user) {
		String bookName=request.getParameter("bookName").trim();//��ȡ�鱾����
		String author=request.getParameter("author").trim();//��ȡ�鱾����
		double price=Double.parseDouble(request.getParameter("price").trim());
		String publishCompany=request.getParameter("publishCompany").trim();
		int amount=Integer.parseInt(request.getParameter("amount").trim());
		int status=Integer.parseInt(request.getParameter("status").trim());
		
		//book���������Դ˴������ж��Ƿ�Ϊ�գ�js���жϼ۸��鱾���ƣ����ߣ��Լ�״̬
		Book book=new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPrice(price);
		book.setPublishCompany(publishCompany);
		book.setAmount(amount);
		book.setRemain(amount);//����������ڿ��
		book.setModifyDate(new Date(new java.util.Date().getTime()));
		book.setStatus(status);
		book.setOpr(0);//��Ӳ���
		
		//�����鱾
		bookDao.save(book);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
