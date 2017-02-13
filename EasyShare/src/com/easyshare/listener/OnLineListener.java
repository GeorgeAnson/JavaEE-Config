package com.easyshare.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.easyshare.globle.Constant;
import com.easyshare.utils.Utils;

/**
 * 单用户登录状态，排除多客户端同时在线
 * @author Administrator
 *
 */
public class OnLineListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 添加用户
		String name=event.getName();
		if(name.equals(Constant.USER_KEY))
		{
			Object object=event.getValue();
			String userCommonID=null;
			userCommonID=Utils.getUserCommonInfo(object).getCommonID()+"";
			addToApplication(userCommonID, event.getSession());
		}
		
		
	}

	//添加在线新用户到session队列中
	@SuppressWarnings("unchecked")
	private void addToApplication(String userCommonID, HttpSession session) {
		//获取application作用域
		ServletContext servletContext=session.getServletContext();
		
		//若在线用户为空，初始化
		if(servletContext.getAttribute(Constant.ONLINE_USERS)==null)
		{
			//初始化一个队列
			servletContext.setAttribute(Constant.ONLINE_USERS, new HashMap<String, String>());
		}
		
		//存放入session中
		HashMap<String,String> userMap=(HashMap<String, String>) servletContext.getAttribute(Constant.ONLINE_USERS);
		userMap.put(userCommonID, session.getId());
	}

	//注销时清除
	@SuppressWarnings("unchecked")
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		String name=event.getName();
		if(name.equals(Constant.USER_KEY))
		{
			//session中移除用户
			Object object=event.getValue();
			String userCommonID=null;
			userCommonID=Utils.getUserCommonInfo(object)+"";
			HashMap<String,String>userMap=(HashMap<String, String>) event.getSession().getServletContext().getAttribute(Constant.ONLINE_USERS);
			userMap.remove(userCommonID);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
