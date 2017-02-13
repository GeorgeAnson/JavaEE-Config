package com.easyshare.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.BookDao;
import com.easyshare.dao.EquipmentDao;
import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.BookDaoImpl;
import com.easyshare.dao.jdbc.EquipmentDaoImpl;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.Book;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Equipment;
import com.easyshare.entity.ManageBook;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.globle.Constant;
import com.easyshare.service.BookService;
import com.easyshare.service.impl.BookServiceImpl;

@Component
public class IndexAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268185363846767574L;
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	@Autowired
	EquipmentDao equipmentDao=new EquipmentDaoImpl();
	
	@Autowired
	BookService bookService=new BookServiceImpl();
	
	@Autowired
	BookDao bookDao=new BookDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String initType=request.getParameter("type");
		
		if("init".equals(initType))
		{
			//��ѯ�����豸��Ϣ
			List<Equipment> equipments=equipmentDao.getEquipmentByName("");
			//����������Ա������Ϣ
			List<CommonUserInfo> commonUserInfos=userDao.getAllCommonUserInfo();
			//���������鼮������Ϣ
			List<ManageBook> allBorrowedBooks=bookDao.getBookByBorrowUserCommonID(-1);
			//��ѯ�����鱾��Ϣ
			List<Book> books = bookDao.getBookByCondition(null);
			//��ȡ�����鱾������Ϣ
			allBorrowedBooks=bookService.getManageBooksInfo(allBorrowedBooks, books);
			
			//�����豸��Ϣֵsession
			request.getSession().setAttribute(Constant.EQUIPMENTS, equipments);
			//�����鱾������Ϣ��session
			request.getSession().setAttribute(Constant.ALL_BORROWED_BOOKS, allBorrowedBooks);
			//���������û��Ĺ�����Ϣ
			request.getSession().setAttribute(Constant.COMMON_USER_INFO, commonUserInfos);
			
			//��ȡ��Ա��Ϣ
			List<Student> students=userDao.getStudentByCondition("");
			request.getSession().setAttribute(Constant.STUDENTS, students);
			List<Teacher> teachers=userDao.getTeacherByContidion("");
			request.getSession().setAttribute(Constant.TEACHERS, teachers);
			
			request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
			return;
		}
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	

}
