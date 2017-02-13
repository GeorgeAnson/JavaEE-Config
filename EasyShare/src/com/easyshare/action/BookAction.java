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
		
		//查询所有书本信息
		List<Book> books = bookDao.getBookByCondition(null);
		
		//查找所有书籍管理信息
		List<ManageBook> allBorrowedBooks=bookDao.getBookByBorrowUserCommonID(-1);
		//查询当前用户所借书本的信息		
		List<ManageBook> manageBooks=bookService.getManageBooksInfo(getUserCommonID(user),books);
		//将书本信息保存到session中
		request.getSession().setAttribute("books", books);
		request.getSession().setAttribute("borrowedBooks", manageBooks);
		
		if("book".equals(initType))
		{
			request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
			return;
		}else if("borrowBooks".equals(initType))
		{
			System.out.println("跳转至借书页");
			
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
			System.out.println("归还书本");
			updateManageBookInfo(request,response,user);
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
			return;
		}else if("addbook".equals(initType))
		{
			if(((Utils.getUserCommonInfo(user)).getAdminType()==2||(Utils.getUserCommonInfo(user)).getAdminType()==0))
			{
				System.out.println("执行添加书本操作,用户为系统管理员或者书籍管理员");
				addBook(request,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
			return;
		}else if("update".equals(initType))
		{
			System.out.println("修改书本信息");
			if((Utils.getUserCommonInfo(user)).getAdminType()==2||(Utils.getUserCommonInfo(user)).getAdminType()==0)
			{
				System.out.println("执行书本信息修改操作");
				updateBookInfo(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/books.html?type=book");
		}else if("delete".equals(initType))
		{
			String tmpId=request.getParameter("id").trim();
			if("".equals(tmpId)||tmpId==null)
			{
				System.out.println("没有需要删除的数据");
				request.setAttribute(Constant.ERROR, "没有需要删除的数据");
			}else
			{
				if((Utils.getUserCommonInfo(user)).getAdminType()==2||(Utils.getUserCommonInfo(user)).getAdminType()==0)
				{
					int bookID=Integer.parseInt(tmpId);
					deleteBook(request,response,bookID);
				}else
				{
					request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
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
	 * 删除书本信息
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param bookID
	 * 			书本编号
	 * 				int
	 */
	private void deleteBook(HttpServletRequest request, HttpServletResponse response, int bookID) {
		Book book=bookDao.getBookById(bookID);
		book.setStatus(-1);
		bookDao.update(book);
	}

	/**
	 * 归还书本
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
		//是否有这条借书信息，没有则返回
		if(manageBook==null)
		{
			System.out.println("没有当前借书记录");
			return;
		}
	
		//更新借书信息
		bookDao.update(manageBook);
	}

	/**
	 * 修改书本信息
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
		
		//若用户输入剩余书本数量大于总数，则默认为总数
		if(bookAmount<bookRemain)
		{
			bookRemain=bookAmount;
		}
		
		//保存书本信息
		Book book=new Book();
		book.setBookID(bookID);
		book.setBookName(bookName);
		book.setAuthor(bookAuthor);
		book.setPrice(bookPrice);
		book.setPublishCompany(bookPubCompany);
		book.setRemain(bookRemain);
		book.setAmount(bookAmount);
		book.setOpr(1);
		
		//检验书本书否存在
		if(!bookService.isExistBook(book))
		{
			System.out.println("书本不存在，无法修改");
			return;
		}
		
		System.out.println(book.getModifyDate()+"time time");
		
		//保存信息
		bookDao.update(book);
	}

	/**
	 * 借书操作，书本信息更新
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
			System.out.println("书本不可借或者不存在");
			return;
		}
		
		manageBook.setBookID(bookID);
		manageBook.setCommonID(getUserCommonID(user));
		manageBook.setBorrowDate(borrowDate);
		manageBook.setReturnDate(returnDate);
		
		//保存借书还书信息
		bookDao.saveManageBook(manageBook);
	}

	/**
	 * 获取user的CommonID
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
	 * 添加一本书的信息
	 * @param request
	 * 			HttpServletRequest
	 * @param user
	 * 			Object
	 */
	private void addBook(HttpServletRequest request, Object user) {
		String bookName=request.getParameter("bookName").trim();//获取书本名称
		String author=request.getParameter("author").trim();//获取书本作者
		double price=Double.parseDouble(request.getParameter("price").trim());
		String publishCompany=request.getParameter("publishCompany").trim();
		int amount=Integer.parseInt(request.getParameter("amount").trim());
		int status=Integer.parseInt(request.getParameter("status").trim());
		
		//book的所有属性此处不用判断是否为空，js需判断价格，书本名称，作者，以及状态
		Book book=new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPrice(price);
		book.setPublishCompany(publishCompany);
		book.setAmount(amount);
		book.setRemain(amount);//入库余量等于库存
		book.setModifyDate(new Date(new java.util.Date().getTime()));
		book.setStatus(status);
		book.setOpr(0);//添加操作
		
		//保存书本
		bookDao.save(book);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
