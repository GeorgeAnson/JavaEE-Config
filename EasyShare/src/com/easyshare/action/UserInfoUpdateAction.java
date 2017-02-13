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
		System.out.println("执行UserInfoUpdateAction方法");
		Object object=request.getSession().getAttribute(Constant.USER_KEY);
		
		System.out.println("objec空？"+object==null?true:false);
		
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
			
			//验证两次密码是否相同
			if(!checkPwd(oldPassword,object))
			{
				System.out.println("密码不正确");
				request.setAttribute(Constant.ERROR, "密码输入错误！");
				request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
//				response.sendRedirect(request.getContextPath()+"/personalInfoUpdate.html?type=init");
				return;
			}
			
			//更新密码
			Utils.getUserCommonInfo(object).setPassword(Utils.toMD5(newPassword));
			//保存新密码信息
			userDao.update(object);
			
			System.out.println("密码更新成功");
			request.setAttribute(Constant.ERROR, "密码更新成功！");
			request.getSession().removeAttribute(Constant.USER_KEY);
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/personalInfoUpdate.html?type=init");
			return;
		}
		
	}
	
	/**
	 * 更新用户信息
	 * @param request
	 * 			请求
	 * @param response
	 * 			响应
	 * @param object
	 * 			用户对象
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updateUserInfo(HttpServletRequest request, HttpServletResponse response, Object object)
			throws ServletException, IOException {
		
		//获取真实姓名
		String realName=request.getParameter("realName").trim();
		//获取email
		String email=request.getParameter("email").trim();
		//获取性别
		boolean gender=Boolean.parseBoolean(request.getParameter("sex").trim());//类型转换，boolean
		//获取QQ
		String QQ=request.getParameter("QQ").trim();
		//获取微信
		String weChat=request.getParameter("weChat").trim();
		//获取电话
		String phone=request.getParameter("phone").trim();
		//获取地址
		String address=request.getParameter("address").trim();
//		System.out.println(object);//测试是否有数值
		System.out.println("公共信息："+realName+"  "+email+"  "+gender+"  "+QQ+"  "+weChat+"  "+phone+"  "+address);
		//验证手机号或者邮箱的正确性
		if(userService.checkEmailAndPhone(email, phone, object))
		{
			System.out.println("手机号或邮箱同原来相同或已被注册");
			request.getRequestDispatcher("/WEB-INF/pages/userInfo.jsp").forward(request, response);
			return;
		}
		
		if(object instanceof Student)
		{
			String studentNum=request.getParameter("studentNum");
			//获取年级
			String grade=request.getParameter("grade").trim();
			//获取专业
			String major=request.getParameter("major").trim();
			//学生部门
			String apartment = request.getParameter("apartment");
			//获取是否为年段负责人
			int inCharge=Integer.parseInt(request.getParameter("inCharge").trim());
			System.out.println("学生信息 "+grade+"  "+major+"  "+inCharge);
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
			
			//更新信息
			userDao.update(object);
			//更新session
			request.getSession().setAttribute(Constant.USER_KEY, (Student)object);
		}else if(object instanceof Teacher)
		{
			//获取教师职称
			String proffessionalTitle=request.getParameter("proffessionalTitle").trim();
			
			System.out.println("学生信息 "+proffessionalTitle);
			//设置真实姓名
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
	 * 验证密码是否修改后与旧密码重复
	 * @param oldPassword
	 * 				旧密码
	 * @param newPassword
	 * 				新密码
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
