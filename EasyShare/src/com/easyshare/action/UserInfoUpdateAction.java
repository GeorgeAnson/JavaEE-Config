package com.easyshare.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.globle.Constant;
import com.easyshare.service.UserService;
import com.easyshare.service.impl.UserServiceImpl;
import com.easyshare.utils.Utils;

@Component
public class UserInfoUpdateAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3741191361328071573L;
	
	@Autowired
	private UserService userService=new UserServiceImpl();
	
	@Autowired
	private UserDao userDao=new UserDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		System.out.println("ִ��UserInfoUpdateAction����");
		Object object=request.getSession().getAttribute(Constant.USER_KEY);
		
		System.out.println("objec�գ�"+object==null?true:false);
		
		String initType=request.getParameter("type");
		if("init".equals(initType))
		{
			request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
		}else if("userInfo".equals(initType))
		{
			updateUserInfo(request,response,object);
			request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
		}else if("userPwd".equals(initType))
		{
			String oldPassword=request.getParameter("oldPassword").trim();
			String newPassword=request.getParameter("newPassword").trim();
			
			System.out.println(oldPassword+" "+newPassword);
			
			//��֤���������Ƿ���ͬ
			if(!checkPwd(oldPassword,object))
			{
				System.out.println("���벻��ȷ");
				request.setAttribute(Constant.ERROR, "�����������");
				request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
//				response.sendRedirect(request.getContextPath()+"/personalInfoUpdate.html?type=init");
				return;
			}
			
			//��������
			Utils.getUserCommonInfo(object).setPassword(Utils.toMD5(newPassword));
			//������������Ϣ
			userDao.update(object);
			
			System.out.println("������³ɹ�");
			request.setAttribute(Constant.ERROR, "������³ɹ���");
			request.getSession().removeAttribute(Constant.USER_KEY);
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/personalInfoUpdate.html?type=init");
			return;
		}
		
	}
	
	/**
	 * �����û���Ϣ
	 * @param request
	 * 			����
	 * @param response
	 * 			��Ӧ
	 * @param object
	 * 			�û�����
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updateUserInfo(HttpServletRequest request, HttpServletResponse response, Object object)
			throws ServletException, IOException {
		
		//��ȡ��ʵ����
		String realName=request.getParameter("realName").trim();
		//��ȡemail
		String email=request.getParameter("email").trim();
		//��ȡ�Ա�
		boolean gender=Boolean.parseBoolean(request.getParameter("sex").trim());//����ת����boolean
		//��ȡQQ
		String QQ=request.getParameter("QQ").trim();
		//��ȡ΢��
		String weChat=request.getParameter("weChat").trim();
		//��ȡ�绰
		String phone=request.getParameter("phone").trim();
		//��ȡ��ַ
		String address=request.getParameter("address").trim();
//		System.out.println(object);//�����Ƿ�����ֵ
		System.out.println("������Ϣ��"+realName+"  "+email+"  "+gender+"  "+QQ+"  "+weChat+"  "+phone+"  "+address);
		//��֤�ֻ��Ż����������ȷ��
		if(userService.checkEmailAndPhone(email, phone, object))
		{
			System.out.println("�ֻ��Ż�����ͬԭ����ͬ���ѱ�ע��");
			request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
			return;
		}
		
		if(object instanceof Student)
		{
			String studentNum=request.getParameter("studentNum");
			//��ȡ�꼶
			String grade=request.getParameter("grade").trim();
			//��ȡרҵ
			String major=request.getParameter("major").trim();
			//ѧ������
			String apartment = request.getParameter("apartment");
			//��ȡ�Ƿ�Ϊ��θ�����
			int inCharge=Integer.parseInt(request.getParameter("inCharge").trim());
			System.out.println("ѧ����Ϣ "+grade+"  "+major+"  "+inCharge);
			((Student) object).getCommonUserInfo().setRealName(realName);
//			((Student) object).getCommonUserInfo().setHeadPic(headPic);
			((Student) object).getCommonUserInfo().setEmail(email);
			((Student) object).getCommonUserInfo().setGender(gender);
			((Student) object).getCommonUserInfo().setQQ(QQ);
			((Student) object).getCommonUserInfo().setWeChat(weChat);
			((Student) object).getCommonUserInfo().setPhone(phone);
			((Student) object).getCommonUserInfo().setAddress(address);
			((Student) object).getCommonUserInfo().setIsLeader(inCharge);
			((Student) object).setStudentNum(studentNum);
			((Student) object).setGrade(grade);
			((Student) object).setMajor(major);
			((Student) object).setApartment(apartment);
			
			//������Ϣ
			userDao.update(object);
			//����session
			request.getSession().setAttribute(Constant.USER_KEY, (Student)object);
		}else if(object instanceof Teacher)
		{
			//��ȡ��ʦְ��
			String proffessionalTitle=request.getParameter("proffessionalTitle").trim();
			
			System.out.println("ѧ����Ϣ "+proffessionalTitle);
			//������ʵ����
			((Teacher) object).getCommonUserInfo().setRealName(realName);
//			((Teacher) object).getCommonUserInfo().setHeadPic(headPic);
			((Teacher) object).getCommonUserInfo().setEmail(email);
			((Teacher) object).getCommonUserInfo().setGender(gender);
			((Teacher) object).getCommonUserInfo().setQQ(QQ);
			((Teacher) object).getCommonUserInfo().setWeChat(weChat);
			((Teacher) object).getCommonUserInfo().setPhone(phone);
			((Teacher) object).getCommonUserInfo().setAddress(address);
			((Teacher) object).setProffessionalTitle(proffessionalTitle);
			userDao.update(object);
			request.getSession().setAttribute(Constant.USER_KEY, (Teacher)object);
		}
	}


	
	/**
	 * ��֤�����Ƿ��޸ĺ���������ظ�
	 * @param oldPassword
	 * 				������
	 * @param newPassword
	 * 				������
	 * @return
	 * 				Boolean
	 */
	private boolean checkPwd(String oldPassword, Object object) {
		boolean flag=false;
		if(object instanceof Student &&
		Utils.toMD5(oldPassword).equals(((Student) object).getCommonUserInfo().getPassword()))
		{
			flag=true;
		}else if(object instanceof Teacher &&
		Utils.toMD5(oldPassword).equals(((Teacher) object).getCommonUserInfo().getPassword()))
		{
			flag=true;
		}
		return flag;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
