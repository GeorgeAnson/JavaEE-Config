package com.easyshare.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class PowerAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8957511547048624900L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		System.out.println("ִ��PowerAction����");
		String initType=request.getParameter("type").trim();
		if("power".equals(initType))
		{
			System.out.println("��ת��Ȩ�޷���ҳ��");
			request.getRequestDispatcher("/WEB-INF/pages/power.jsp").forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
