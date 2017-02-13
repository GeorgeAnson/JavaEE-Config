package com.easyshare.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ��¼�û�����session
 * @author Administrator
 *
 */
public class SessionListener  implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent session) {
		System.out.println(getTime()+"session����"+session.getSession().getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent session) {
		session.getSession().invalidate();
		System.out.println(getTime()+"session����"+session.getSession().getId());
	}
	
	
	
	private String getTime()
	{
		long l=System.currentTimeMillis();
		Date date=new Date(l);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

}
