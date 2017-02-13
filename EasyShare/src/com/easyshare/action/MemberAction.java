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
		System.out.println("ִ��MemberAction����");
		String initType=request.getParameter("type");
		Object user=session.getAttribute(Constant.USER_KEY);
		if("member".equals(initType))
		{
			System.out.println("��ת����Ա����ҳ��");
			request.getRequestDispatcher("/WEB-INF/pages/members.jsp").forward(request, response);
		}else if("student".equals(initType))
		{
			System.out.println("��ת��ѧ������ҳ��");
			List<Student> students=userDao.getStudentByCondition("");
			session.setAttribute("students", students);
			request.getRequestDispatcher("/WEB-INF/pages/studentsMgr.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			System.out.println("ִ����ӳ�Ա����");
			addUser(request,response,user);
			
		}else if("update".equals(initType))
		{
			System.out.println("ִ��ɾ����Ա����");
			updateUser(request,response,user);
		}else if("delete".equals(initType))
		{
			System.out.println("ִ��ɾ����Ա����");
			delUser(request,response,user);
			
		}else if("teacher".equals(initType))
		{
			System.out.println("��ת����ʦ����ҳ��");
			List<Teacher> teachers=userDao.getTeacherByContidion("");
			session.setAttribute("teachers", teachers);
			request.getRequestDispatcher("/WEB-INF/pages/teachersMgr.jsp").forward(request, response);
		}
	}
	
	
	/**
	 * ɾ���û�
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
		//�ж��û�Ȩ��
		if((Utils.getUserCommonInfo(user)).getAdminType()!=1 && (Utils.getUserCommonInfo(user)).getAdminType()!=0)
		{
			request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			System.out.println(request.getAttribute(Constant.ERROR));
			
			//ִ����ת
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
			//��ʦ
			((Teacher)object).getCommonUserInfo().setStatus(-1);//�˺�״̬Ϊɾ��
			
		}else if(2==userType)
		{
			//ѧ��
			((Student)object).getCommonUserInfo().setStatus(-1);//�˺�״̬Ϊɾ��
		}
		
		//������Ϣ
		userDao.update(object);
		
		//ִ����ת
		if(1==userType)
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=student");
		}
	}


	/**
	 * �����û���Ϣ
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
		//�ж��û�Ȩ��
		if((Utils.getUserCommonInfo(user)).getAdminType()!=1 && (Utils.getUserCommonInfo(user)).getAdminType()!=0)
		{
			request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			System.out.println(request.getAttribute(Constant.ERROR));
			
			//ִ����ת
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
			//��ʦ
			String professionalTitle=request.getParameter("professionalTitle");
			((Teacher)object).setTeacherID(userID);
			if(!"δ��д".equals(professionalTitle)&&!"".equals(professionalTitle))
			{
				((Teacher)object).setProffessionalTitle(professionalTitle);
			}
			((Teacher)object).getCommonUserInfo().setRealName(realName);
			if(!"δ��д".equals(phone)&&!"".equals(phone))
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
			//ѧ��
			String studentNum=request.getParameter("studentNum").trim();
			String studentClass=request.getParameter("studentClass");
			boolean isGraduate=Boolean.parseBoolean(request.getParameter("isGraduated").trim());
			((Student)object).setStudentID(userID);
			
			if(!"δ��д".equals(studentNum)&&!"".equals(studentNum))
			{
				((Student)object).setStudentNum(studentNum);
			}
			if(!"δ��д".equals(studentClass)&&!"".equals(studentClass))
			{
				((Student)object).setGrade(studentClass);
			}
			((Student)object).getCommonUserInfo().setIsGraduate(isGraduate);
			((Student)object).getCommonUserInfo().setRealName(realName);
			if(!"δ��д".equals(phone)&&!"".equals(phone))
			{
				((Student)object).getCommonUserInfo().setPhone(phone);
			}
			((Student)object).getCommonUserInfo().setGender(gender);
			((Student)object).getCommonUserInfo().setAdminType(adminType);
			((Student)object).getCommonUserInfo().setStatus(status);
			((Student)object).getCommonUserInfo().setUserType(userType);
			((Student)object).getCommonUserInfo().setOpr(1);
		}
		
		//������Ϣ
		userDao.update(object);
		
		//ִ����ת
		if(1==userType)
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/members.html?type=student");
		}
	}


	/**
	 * ������û�
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
		//�ж��û�Ȩ��
		if((Utils.getUserCommonInfo(user)).getAdminType()!=1 && (Utils.getUserCommonInfo(user)).getAdminType()!=0)
		{
			request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			System.out.println(request.getAttribute(Constant.ERROR));
			
			//ִ����ת
			if(1==userType)
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=teacher");
			}else
			{
				response.sendRedirect(request.getContextPath()+"/members.html?type=student");
			}
			return;
		}
		//����������Ϣ��
		CommonUserInfo commonUserInfo=new CommonUserInfo();
		commonUserInfo.setRealName(realName);
		commonUserInfo.setLoginName(realName);//Ĭ���û�������ʵ������ͬ
		commonUserInfo.setPhone(phone);
		commonUserInfo.setEmail(email);
		commonUserInfo.setGender(gender);
		commonUserInfo.setAdminType(adminType);
		commonUserInfo.setUserType(userType);
		commonUserInfo.setCreateDate(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		commonUserInfo.setPassword(Utils.toMD5("123456"));
		commonUserInfo.setStatus(1);//����ʹ��
		commonUserInfo.setOpr(0);//��ӱ�־
		
		UserFactory userFactory=new UserFactory();
		Object object=userFactory.getUser(commonUserInfo);
		
		if(1==userType)
		{
			//��ʦ
			String professionalTitle=request.getParameter("newProfessionalTitle");
			((Teacher)object).setProffessionalTitle(professionalTitle);
		}else if(2==userType)
		{
			//ѧ��
			String studentNum=request.getParameter("newStudentNum").trim();
			boolean isGraduate=Boolean.parseBoolean(request.getParameter("graduated").trim());
			((Student)object).setStudentNum(studentNum);
			((Student)object).getCommonUserInfo().setIsGraduate(isGraduate);
		}
		
		//ע���û�
		userService.registerUser(object);
		
		//ִ����ת
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
