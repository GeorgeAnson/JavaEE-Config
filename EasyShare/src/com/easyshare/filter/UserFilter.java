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

	//免验证的URL
	private String check=null;
	private String error_url=null;
	private String userConstants=null;
	private Object user=null;
	@Override
	public void init(FilterConfig config) throws ServletException {
		//获取初始化参数
		this.check=config.getInitParameter("check");
		this.error_url=config.getInitParameter("error_url");
		this.userConstants=config.getInitParameter("userConstants");
		System.out.println("Filter:"+error_url+"  UserConstants: "+userConstants+"  check: "+this.check);
	}

	

	@Override
	public void doFilter(ServletRequest s_request, ServletResponse s_response, FilterChain chain)
			throws IOException, ServletException {
		//HttpServlet类型转换
		HttpServletRequest request=(HttpServletRequest) s_request;
		HttpServletResponse response=(HttpServletResponse) s_response;
		
		
//		System.out.println("接收请求："+request.getRequestURI());
		user= request.getSession().getAttribute(userConstants);
		String URL=request.getRequestURI();
		
		String[] checked=check.split(";");
		
		System.out.println("用户是否为空"+user!=null?true:false);
		
		if(isChecked(request,checked,URL)&&user!=null)
		{
//			System.out.println("用户不空，检验通过");
			chain.doFilter(request, response);
			return;
		}
		
		if(!isChecked(request,checked,URL))
		{
//			System.out.println("验证通过");
			chain.doFilter(request, response);
			return;
		}
		System.out.println("错误");
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
//	 * 拒绝多设备登录情况
//	 * @param request
//	 * @return
//	 */
//	private boolean isAvailable(HttpServletRequest request) {
//		
//		System.out.println("检查单击登录");
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
//			session.setAttribute(Constant.ERROR, "您的账号在其他地方登录，您被迫下线");
//			System.out.println("您的账号在其他地方登录，您被迫下线");
//			session.removeAttribute(Constant.USER_KEY);
//			return false;
//		}
//		return true;
//	}
//
//
//
//	/**
//	 * 验证用户是否已登录
//	 * @param request
//	 * @return
//	 */
//	private boolean checkUser(HttpServletRequest request) {
//		Object object=request.getSession().getAttribute(Constant.USER_KEY);
//		
//		System.out.println("检查用户登录状态");
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
//	 * 判断验证是否通过
//	 * @param permit 
//	 * 				单个可通过链接
//	 * @param url 
//	 * 				需验证的url地址
//	 * @param request
//	 * 			请求流
//	 * @return
//	 * 		返回判断结果标识
//	 * 			可通过：true
//	 * 			拦截：false
//	 */
//	private boolean isPassable(String checkedURL, String url, HttpServletRequest request) {
//		
//		
//		System.out.println("checked："+checkedURL);
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
