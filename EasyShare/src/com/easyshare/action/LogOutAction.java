package com.easyshare.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.globle.Constant;


@Component
public class LogOutAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -656101347536747169L;

	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String initType=request.getParameter("type");
		if("logout".equals(initType))
		{
			HttpSession session=request.getSession();
			Object User=session.getAttribute(Constant.USER_KEY);
			if(User==null)
			{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
			
			session.removeAttribute(Constant.USER_KEY);//移除session内容
			session.invalidate();//强制销毁session
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
