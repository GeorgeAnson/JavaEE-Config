package com.easyshare.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.entity.UserFactory;
import com.easyshare.globle.Constant;
import com.easyshare.service.UserService;
import com.easyshare.service.impl.UserServiceImpl;
import com.easyshare.utils.Utils;

@Component
public class MemberAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 686784262681330866L;

	@Autowired
	UserService userService=new UserServiceImpl();
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("执行MemberAction方法");
		String initType=request.getParameter("type");
		Object user=session.getAttribute(Constant.USER_KEY);
		if("member".equals(initType))
		{
			System.out.println("跳转到成员管理页面");
			request.getRequestDispatcher("/WEB-INF/pages/members.jsp").forward(request, response);
		}else if("student".equals(initType))
		{
			System.out.println("跳转到学生管理页面");
			List<Student> students=userDao.getStudentByCondition("");
			session.setAttribute("students", students);
			request.getRequestDispatcher("/WEB-INF/pages/studentsMgr.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			System.out.println("执行添加成员操作");
			addUser(request,response,user);
			
		}else if("update".equals(initType))
		{
			System.out.println("执行删除成员操作");
			updateUser(request,response,user);
		}else if("delete".equals(initType))
		{
			System.out.println("执行删除成员操作");
			delUser(request,response,user);
			
		}else if("teacher".equals(initType))
		{
			System.out.println("跳转到教师管理页面");
			List<Teacher> teachers=userDao.getTeacherByContidion("");
			session.setAttribute("teachers", teachers);
			request.getRequestDispatcher("/WEB-INF/pages/teachersMgr.jsp").forward(request, response);
		}
	}
	
	
	/**
	 * 删除用户
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 * @throws IOException
	 */
	private void delUser(HttpServletRequest request, HttpServletResponse response, Object user)
			throws IOException {
		
		int userID=Integer.parseInt(request.getParameter("id").trim());
		int userType=Integer.parseInt(request.getParameter("userType").trim());
		//判断用户权限
		if((Utils.getUserCommonInfo(user)).getAdminType()!=1 && (Utils.getUserCommonInfo(user)).getAdminType()!=0)
		{
			request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			System.out.println(request.getAttribute(Constant.ERROR));
			
			//执行跳转
			if(1==userType)
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
			}else
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=student");
			}
			return;
		}
		
		Object object=userDao.getUserById(userID, userType);
		
		if(1==userType)
		{
			//教师
			((Teacher)object).getCommonUserInfo().setStatus(-1);//账号状态为删除
			
		}else if(2==userType)
		{
			//学生
			((Student)object).getCommonUserInfo().setStatus(-1);//账号状态为删除
		}
		
		//更新信息
		userDao.update(object);
		
		//执行跳转
		if(1==userType)
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=student");
		}
	}


	/**
	 * 更新用户信息
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 * @throws IOException
	 */
	private void updateUser(HttpServletRequest request, HttpServletResponse response, Object user)
			throws IOException {
		int userType=Integer.parseInt(request.getParameter("userType"));
		int userID=Integer.parseInt(request.getParameter("userID").trim());
		System.out.println("bianhaobnianhao "+userID);
		String realName=request.getParameter("memberName").trim();
		String phone=request.getParameter("phone").trim();
		Boolean gender=Boolean.parseBoolean(request.getParameter("newSex").trim());System.out.println("dengdengdengdendgedneer   "+gender);
		int adminType=Integer.parseInt(request.getParameter("adminType").trim());
		int status=Integer.parseInt(request.getParameter("menberStatus"));
		//判断用户权限
		if((Utils.getUserCommonInfo(user)).getAdminType()!=1 && (Utils.getUserCommonInfo(user)).getAdminType()!=0)
		{
			request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			System.out.println(request.getAttribute(Constant.ERROR));
			
			//执行跳转
			if(1==userType)
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
			}else
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=student");
			}
			return;
		}
		
		Object object=userDao.getUserById(userID, userType);
		
		if(1==userType)
		{
			//教师
			String professionalTitle=request.getParameter("professionalTitle");
			((Teacher)object).setTeacherID(userID);
			if(!"未填写".equals(professionalTitle)&&!"".equals(professionalTitle))
			{
				((Teacher)object).setProffessionalTitle(professionalTitle);
			}
			((Teacher)object).getCommonUserInfo().setRealName(realName);
			if(!"未填写".equals(phone)&&!"".equals(phone))
			{
				((Teacher)object).getCommonUserInfo().setPhone(phone);
			}
			((Teacher)object).getCommonUserInfo().setGender(gender);
			((Teacher)object).getCommonUserInfo().setAdminType(adminType);
			((Teacher)object).getCommonUserInfo().setStatus(status);
			((Teacher)object).getCommonUserInfo().setUserType(userType);
			((Teacher)object).getCommonUserInfo().setOpr(1);
		}else if(2==userType)
		{
			//学生
			String studentNum=request.getParameter("studentNum").trim();
			String studentClass=request.getParameter("studentClass");
			boolean isGraduate=Boolean.parseBoolean(request.getParameter("isGraduated").trim());
			((Student)object).setStudentID(userID);
			
			if(!"未填写".equals(studentNum)&&!"".equals(studentNum))
			{
				((Student)object).setStudentNum(studentNum);
			}
			if(!"未填写".equals(studentClass)&&!"".equals(studentClass))
			{
				((Student)object).setGrade(studentClass);
			}
			((Student)object).getCommonUserInfo().setIsGraduate(isGraduate);
			((Student)object).getCommonUserInfo().setRealName(realName);
			if(!"未填写".equals(phone)&&!"".equals(phone))
			{
				((Student)object).getCommonUserInfo().setPhone(phone);
			}
			((Student)object).getCommonUserInfo().setGender(gender);
			((Student)object).getCommonUserInfo().setAdminType(adminType);
			((Student)object).getCommonUserInfo().setStatus(status);
			((Student)object).getCommonUserInfo().setUserType(userType);
			((Student)object).getCommonUserInfo().setOpr(1);
		}
		
		//更新信息
		userDao.update(object);
		
		//执行跳转
		if(1==userType)
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=student");
		}
	}


	/**
	 * 添加新用户
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 * @throws IOException
	 */
	private void addUser(HttpServletRequest request, HttpServletResponse response, Object user)
			throws IOException {
		int userType=Integer.parseInt(request.getParameter("userType"));
		
		String realName=request.getParameter("newRealName").trim();
		String phone=request.getParameter("newPhone").trim();
		String email=request.getParameter("newEmail").trim();
		Boolean gender=Boolean.parseBoolean(request.getParameter("sex").trim());
		int adminType=Integer.parseInt(request.getParameter("newAdminType").trim());
		//判断用户权限
		if((Utils.getUserCommonInfo(user)).getAdminType()!=1 && (Utils.getUserCommonInfo(user)).getAdminType()!=0)
		{
			request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			System.out.println(request.getAttribute(Constant.ERROR));
			
			//执行跳转
			if(1==userType)
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
			}else
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=student");
			}
			return;
		}
		//创建公共信息类
		CommonUserInfo commonUserInfo=new CommonUserInfo();
		commonUserInfo.setRealName(realName);
		commonUserInfo.setLoginName(realName);//默认用户名与真实姓名相同
		commonUserInfo.setPhone(phone);
		commonUserInfo.setEmail(email);
		commonUserInfo.setGender(gender);
		commonUserInfo.setAdminType(adminType);
		commonUserInfo.setUserType(userType);
		commonUserInfo.setCreateDate(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		commonUserInfo.setPassword(Utils.toMD5("123456"));
		commonUserInfo.setStatus(1);//正常使用
		commonUserInfo.setOpr(0);//添加标志
		
		UserFactory userFactory=new UserFactory();
		Object object=userFactory.getUser(commonUserInfo);
		
		if(1==userType)
		{
			//教师
			String professionalTitle=request.getParameter("newProfessionalTitle");
			((Teacher)object).setProffessionalTitle(professionalTitle);
		}else if(2==userType)
		{
			//学生
			String studentNum=request.getParameter("newStudentNum").trim();
			boolean isGraduate=Boolean.parseBoolean(request.getParameter("graduated").trim());
			((Student)object).setStudentNum(studentNum);
			((Student)object).getCommonUserInfo().setIsGraduate(isGraduate);
		}
		
		//注册用户
		userService.registerUser(object);
		
		//执行跳转
		if(1==userType)
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=student");
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
