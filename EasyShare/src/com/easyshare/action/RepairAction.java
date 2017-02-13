package com.easyshare.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class RepairAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5509173832993579275L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行RepairAction方法");
		String initType=request.getParameter("type").trim();
		if("repair".equals(initType))
		{
			System.out.println("跳转到服务维修页面");
			request.getRequestDispatcher("/WEB-INF/pages/repair.jsp").forward(request, response);
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
}
