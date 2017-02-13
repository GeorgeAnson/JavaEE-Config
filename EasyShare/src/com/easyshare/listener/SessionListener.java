package com.easyshare.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 登录用户创建session
 * @author Administrator
 *
 */
public class SessionListener  implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent session) {
		System.out.println(getTime()+"session创建"+session.getSession().getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent session) {
		session.getSession().invalidate();
		System.out.println(getTime()+"session销毁"+session.getSession().getId());
	}
	
	
	
	private String getTime()
	{
		long l=System.currentTimeMillis();
		Date date=new Date(l);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

}
