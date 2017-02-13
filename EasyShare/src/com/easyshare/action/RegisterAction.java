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
		
		System.out.println("ִ��RegisterAction����");
		//��ȡ�û�ע����Ϣ
		loginName=request.getParameter("loginName").trim();
		password=request.getParameter("password").trim();
		email=request.getParameter("email").trim();
		phone=request.getParameter("phone").trim();
		type=Integer.parseInt(request.getParameter("type").trim());
		System.out.println(loginName+"   "+password+"   "+email+"   "+phone+"   "+type);
		boolean flag=false;
		
		//�������󱣴���Ϣ
				if(Utils.isEmail(email)&&Utils.isPhone(phone))
				{
					System.out.println("����͵绰��ȷ");
					if(isUserExisted(email,type)&&type!=-1)
					{
						System.out.println("������ȷ");
						//���湲����Ϣ
						commonUserInfo.setLoginName(loginName);
						commonUserInfo.setPassword(Utils.toMD5(password));
						commonUserInfo.setEmail(email);
						commonUserInfo.setPhone(phone);
						commonUserInfo.setCreateDate(Utils.stringToDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
						commonUserInfo.setUserType(type);
						commonUserInfo.setStatus(0);//Ĭ���˻�����
						commonUserInfo.setOpr(0);//��Ӳ���
						System.out.println("OK phone");
						System.out.println("OK email");
						
						UserFactory userFactory=new UserFactory();
						Object object=userFactory.getUser(commonUserInfo);
						userService.registerUser(object);
						System.out.println("ע��ɹ�");
						flag=true;
					}
					else
					{
						request.setAttribute(Constant.ERROR, "�û��Ѿ����ڻ���ע�����Ͳ���");
						System.out.println("�û��Ѿ����ڻ���ע�����Ͳ���");
					}
					
				}
				else
				{
					request.setAttribute(Constant.ERROR, "����������벻����Ҫ��");
					System.out.println("����������벻����Ҫ��");
				}
				
				
				//����ע����ִ����ת
				if(flag)
				{
					response.sendRedirect(request.getContextPath()+"/msg.jsp");
				}else
				{
					forward(request, response);
				}
	}
	
	
	
	/**
	 * �ж��û��Ƿ��Ѿ�����
	 * @param email
	 * @return
	 */
	private boolean isUserExisted(String email,int type) {
		Object object=null;
		
		if(2==type)
		{
			//ѧ��
			object=userDao.getUserByCondition(email,type);
		}
		else if(1==type)
		{
			//��ʦ
			object=userDao.getUserByCondition(email,type);
		}
		else if(0==type)
		{
			//����Ա
			object=userDao.getUserByCondition(email,type);
		}
		
		return object==null;
	}
	
	
	/**
	 * ִ��ҳ����ת
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
