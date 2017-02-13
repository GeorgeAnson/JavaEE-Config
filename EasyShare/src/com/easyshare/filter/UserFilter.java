package com.easyshare.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserFilter implements Filter{

	//����֤��URL
	private String check=null;
	private String error_url=null;
	private String userConstants=null;
	private Object user=null;
	@Override
	public void init(FilterConfig config) throws ServletException {
		//��ȡ��ʼ������
		this.check=config.getInitParameter("check");
		this.error_url=config.getInitParameter("error_url");
		this.userConstants=config.getInitParameter("userConstants");
		System.out.println("Filter:"+error_url+"  UserConstants: "+userConstants+"  check: "+this.check);
	}

	

	@Override
	public void doFilter(ServletRequest s_request, ServletResponse s_response, FilterChain chain)
			throws IOException, ServletException {
		//HttpServlet����ת��
		HttpServletRequest request=(HttpServletRequest) s_request;
		HttpServletResponse response=(HttpServletResponse) s_response;
		
		
//		System.out.println("��������"+request.getRequestURI());
		user= request.getSession().getAttribute(userConstants);
		String URL=request.getRequestURI();
		
		String[] checked=check.split(";");
		
		System.out.println("�û��Ƿ�Ϊ��"+user!=null?true:false);
		
		if(isChecked(request,checked,URL)&&user!=null)
		{
//			System.out.println("�û����գ�����ͨ��");
			chain.doFilter(request, response);
			return;
		}
		
		if(!isChecked(request,checked,URL))
		{
//			System.out.println("��֤ͨ��");
			chain.doFilter(request, response);
			return;
		}
		System.out.println("����");
		response.sendRedirect(request.getContextPath()+this.error_url);
		return;
		
	}

	
	private boolean isChecked(HttpServletRequest request, String[] checked, String uRL) {
		
		for(String item:checked)
		{
			if((request.getContextPath()+item).equals(uRL))
			{
				return true;
			}
		}
		return false;
	}
	
	
//	/**
//	 * �ܾ����豸��¼���
//	 * @param request
//	 * @return
//	 */
//	private boolean isAvailable(HttpServletRequest request) {
//		
//		System.out.println("��鵥����¼");
//		
//		ServletContext servletContext=request.getServletContext();
//		@SuppressWarnings("unchecked")
//		HashMap<String,String>userMap=(HashMap<String, String>) servletContext.getAttribute(Constant.ONLINE_USERS);
//		
//		HttpSession session=request.getSession();
//		Object object=session.getAttribute(userConstants);
//		String userCommonID=Utils.getUserCommonInfo(object).getCommonID()+"";
//		
//		System.out.println(userCommonID+"yonghucommonID");
//		
//		if(!"".equals(userCommonID) && userMap.get(userCommonID)!=null && userMap.get(userCommonID)!=session.getId())
//		{
//			session.setAttribute(Constant.ERROR, "�����˺��������ط���¼������������");
//			System.out.println("�����˺��������ط���¼������������");
//			session.removeAttribute(Constant.USER_KEY);
//			return false;
//		}
//		return true;
//	}
//
//
//
//	/**
//	 * ��֤�û��Ƿ��ѵ�¼
//	 * @param request
//	 * @return
//	 */
//	private boolean checkUser(HttpServletRequest request) {
//		Object object=request.getSession().getAttribute(Constant.USER_KEY);
//		
//		System.out.println("����û���¼״̬");
//		return object!=null?true:false;
//	}
//
//
//
//	private boolean isCheckAble(HttpServletRequest request) {
//		
//		if(this.check==null)
//		{
//			return false;
//		}
//		
//		String url=request.getRequestURI();
//		String[] checked=this.check.split(";");
//		
//		for(String item : checked)
//		{
//			if(isPassable(request.getContextPath()+item,url,request))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//
//
//
//	/**
//	 * �ж���֤�Ƿ�ͨ��
//	 * @param permit 
//	 * 				������ͨ������
//	 * @param url 
//	 * 				����֤��url��ַ
//	 * @param request
//	 * 			������
//	 * @return
//	 * 		�����жϽ����ʶ
//	 * 			��ͨ����true
//	 * 			���أ�false
//	 */
//	private boolean isPassable(String checkedURL, String url, HttpServletRequest request) {
//		
//		
//		System.out.println("checked��"+checkedURL);
//		if(url.equals(request.getContextPath()+"/login.jsp")||url.equals(request.getContextPath()+"/index.jsp"))
//		{
//			return true;
//		}
//		return checkedURL.equals(url)?true:false;
//	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
