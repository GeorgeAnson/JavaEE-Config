package com.easyshare.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.UserDao;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.UserFactory;
import com.easyshare.globle.Constant;
import com.easyshare.service.UserService;
import com.easyshare.utils.Utils;

@Component
public class RegisterAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3430486340475762825L;

	private String loginName="";
	private String password="";
	private String email="";
	private String phone="";
	private int type=-1;
	private CommonUserInfo commonUserInfo=new CommonUserInfo();
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("执行RegisterAction方法");
		//获取用户注册信息
		loginName=request.getParameter("loginName").trim();
		password=request.getParameter("password").trim();
		email=request.getParameter("email").trim();
		phone=request.getParameter("phone").trim();
		type=Integer.parseInt(request.getParameter("type").trim());
		System.out.println(loginName+"   "+password+"   "+email+"   "+phone+"   "+type);
		boolean flag=false;
		
		//创建对象保存信息
				if(Utils.isEmail(email)&&Utils.isPhone(phone))
				{
					System.out.println("邮箱和电话正确");
					if(isUserExisted(email,type)&&type!=-1)
					{
						System.out.println("类型正确");
						//保存共有信息
						commonUserInfo.setLoginName(loginName);
						commonUserInfo.setPassword(Utils.toMD5(password));
						commonUserInfo.setEmail(email);
						commonUserInfo.setPhone(phone);
						commonUserInfo.setCreateDate(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
						commonUserInfo.setUserType(type);
						commonUserInfo.setStatus(0);//默认账户冻结
						commonUserInfo.setOpr(0);//添加操作
						System.out.println("OK phone");
						System.out.println("OK email");
						
						UserFactory userFactory=new UserFactory();
						Object object=userFactory.getUser(commonUserInfo);
						userService.registerUser(object);
						System.out.println("注册成功");
						flag=true;
					}
					else
					{
						request.setAttribute(Constant.ERROR, "用户已经存在或者注册类型不对");
						System.out.println("用户已经存在或者注册类型不对");
					}
					
				}
				else
				{
					request.setAttribute(Constant.ERROR, "邮箱或者密码不符合要求");
					System.out.println("邮箱或者密码不符合要求");
				}
				
				
				//根据注册结果执行跳转
				if(flag)
				{
					response.sendRedirect(request.getContextPath()+"/msg.jsp");
				}else
				{
					forward(request, response);
				}
	}
	
	
	
	/**
	 * 判断用户是否已经存在
	 * @param email
	 * @return
	 */
	private boolean isUserExisted(String email,int type) {
		Object object=null;
		
		if(2==type)
		{
			//学生
			object=userDao.getUserByCondition(email,type);
		}
		else if(1==type)
		{
			//教师
			object=userDao.getUserByCondition(email,type);
		}
		else if(0==type)
		{
			//管理员
			object=userDao.getUserByCondition(email,type);
		}
		
		return object==null;
	}
	
	
	/**
	 * 执行页面跳转
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void forward(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
