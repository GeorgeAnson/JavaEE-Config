package com.easyshare.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.easyshare.globle.Constant;
import com.easyshare.utils.Utils;

/**
 * ���û���¼״̬���ų���ͻ���ͬʱ����
 * @author Administrator
 *
 */
public class OnLineListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// ����û�
		String name=event.getName();
		if(name.equals(Constant.USER_KEY))
		{
			Object object=event.getValue();
			String userCommonID=null;
			userCommonID=Utils.getUserCommonInfo(object).getCommonID()+"";
			addToApplication(userCommonID, event.getSession());
		}
		
		
	}

	//����������û���session������
	@SuppressWarnings("unchecked")
	private void addToApplication(String userCommonID, HttpSession session) {
		//��ȡapplication������
		ServletContext servletContext=session.getServletContext();
		
		//�������û�Ϊ�գ���ʼ��
		if(servletContext.getAttribute(Constant.ONLINE_USERS)==null)
		{
			//��ʼ��һ������
			servletContext.setAttribute(Constant.ONLINE_USERS, new HashMap<String, String>());
		}
		
		//�����session��
		HashMap<String,String> userMap=(HashMap<String, String>) servletContext.getAttribute(Constant.ONLINE_USERS);
		userMap.put(userCommonID, session.getId());
	}

	//ע��ʱ���
	@SuppressWarnings("unchecked")
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		String name=event.getName();
		if(name.equals(Constant.USER_KEY))
		{
			//session���Ƴ��û�
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
