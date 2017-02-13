package com.easyshare.action;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.bean.LoginInfo;
import com.easyshare.dao.UserDao;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.globle.Constant;
import com.easyshare.service.UserService;
import com.easyshare.utils.Utils;


@Component
public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 4837570311699346456L;

	// ��¼ʧ����ת��url
	private static String ERROR_URL;
	// ��½�ɹ���ת��url
	private static String OK_URL;
	
	private String condition="";
	private String password="";
	private String codeNumbers="";
	private int type=-1;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ERROR_URL = super.getServletContext().getInitParameter("error_url");
		OK_URL = super.getServletContext().getInitParameter("index_url");
		System.out.println("ok: "+OK_URL+" error: "+ERROR_URL);
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String initType=request.getParameter("type").trim();
		
		if(!"".equals(initType) && "login".equals(initType))
		{
			this.condition=request.getParameter("condition").trim();
			this.password=request.getParameter("password").trim();
			this.codeNumbers=request.getParameter("code").trim();
			this.type=Integer.parseInt(request.getParameter("options").trim());
			
			System.out.println(type);
			System.out.println("password"+password+"  "+condition+"  jdoiasad ");
			//����û������������֤��Ϊ������תΪ��¼ҳ��
			if(this.codeNumbers==null||"".equals(this.codeNumbers)
					||this.condition==null||"".equals(this.condition)
					||this.password==null||"".equals(this.password))
			{
				System.out.println("�û������������֤��Ϊ��");
				forword(request, response, true, null);
				return;
			}
			
			// session�����õ���ǰ��ȷ����֤��
			String rightCode = (String) request.getSession().getAttribute(Constant.CHECK_NUMBER_NAME);

			System.out.println(rightCode+"  "+codeNumbers);
			
			//��֤��֤�����ȷ��
			if(!userService.checkCode(rightCode, codeNumbers))
			{
				request.setAttribute(Constant.ERROR, "��֤�벻��ȷ");
				System.out.println("��֤�벻��ȷ");
				forword(request, response, true, null);
				return;
			}
			
			//ͨ���û��������û�����
			//������û���Ϊemail����phone
			Object object=userDao.getUserByCondition(condition, type);
			
			if(object==null)
			{
				request.setAttribute(Constant.ERROR, "��δע�ᣡ");
				System.out.println("��δע�ᣡ");
				forword(request, response, true, null);
				return;
			}
			//��ȡ������Ϣ
			CommonUserInfo commonUserInfo=Utils.getUserCommonInfo(object);
			//�ж��û������Ƿ�������ȷ
			if(commonUserInfo.getUserType()!=type)
			{
				request.setAttribute(Constant.ERROR, "�û����ʹ���");
				System.out.println("�û����ʹ���");
				forword(request, response, true, null);
				return;
			}
			
			//�ж��˺��Ƿ񱻶���
			if(object!=null && Utils.getUserCommonInfo(object).getStatus()!=1)
			{
				request.setAttribute(Constant.ERROR, "�˺���������У�");
				System.out.println("�˺���������У�");
				forword(request, response, true, null);
				return;
			}
			
			//��֤�û���������
			if(object!=null && !commonUserInfo.getPassword().equals(Utils.toMD5(password)))
			{
				request.setAttribute(Constant.ERROR, "�û������������");
				System.out.println("�û������������");
				forword(request, response, true, null);
				return;
			}
			
			System.out.println("ִ������");
			
			// ��½�ɹ���������ת
			forword(request, response, false, object);
		}else
		{
			//��ֹurl���⴫��
			forword(request, response, true, null);
			return;
		}
	}

	private void forword(HttpServletRequest request, HttpServletResponse response, boolean isError,Object object)
			throws ServletException, IOException {
		// ��ȡsession�е���ȷ��ת���URL �����תǰ�д洢ҳ�����ӣ�����ת����½ǰ��ҳ�� ���û�У�����ת����ҳ
		String okUrl = getUrl(Constant.OK_URL, request);
		// ��δʵ�ִ���������ת
		String errUrl = getUrl(Constant.ERR_URL, request);

		if (okUrl == null)
		{
			okUrl = OK_URL;
		}

		if (errUrl == null)
		{
			errUrl = ERROR_URL;	
		}

		if (object != null && !isError)
		{
			// �����û��������Ϣ���û���Ϣ�����ʼ�¼����¼��Ϣ��
			System.out.println("�����û���Ϣ");
			saveUserInfo(request, object);
		}

		if (isError)
		{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		else
		{
			System.out.println(okUrl);
			response.sendRedirect(request.getContextPath()+okUrl);
		}
		
	}

	
	/**
	 * ���Դ������л�ȡ��Ӧ��URLֵ
	 * 
	 * @param key
	 *            �洢URL�ļ�ֵ
	 * @param request
	 *            �������
	 * @return ��ȡ����URL��ַ
	 */
	private String getUrl(String key, HttpServletRequest request) {

		String url = request.getParameter(key);

		if (url != null && !"".equals(url.trim())) {
			request.setAttribute(key, url);
			return url;
		}

		url = (String) request.getAttribute(key);
		if (url != null && !"".equals(url.trim()))
			return url;

		url = (String) request.getSession().getAttribute(key);
		if (url != null && !"".equals(url.trim())) {
			request.getSession().removeAttribute(key);
			return url;
		}

		return url;
	}
	
	
	private void saveUserInfo(HttpServletRequest request, Object object) {
		// ���¿���session����������û���¼ʱ��
		request.getSession().invalidate();
		HttpSession session = request.getSession();

		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setIp(request.getRemoteAddr());
		loginInfo.setLoginName(Utils.getUserCommonInfo(object).getLoginName());
		loginInfo.setLoginTime(new Date());
		session.setAttribute("loginInfo", loginInfo);
		
		//�����û���¼��Ϣ
		CommonUserInfo commonUserInfo=Utils.getUserCommonInfo(object);
		commonUserInfo.setLoginTimes(commonUserInfo.getLoginTimes()+1);
		commonUserInfo.setRecentlyLogin(new java.sql.Date(new java.util.Date().getTime()));
		commonUserInfo.setIP(loginInfo.getIp());
		
		//������Ϣ,��¼�û���¼��ip��ַ����¼ʱ�䣬��¼����
		userDao.update(object);
		
		// ���û�״̬����session��
		if(object instanceof Student)
		{
			session.setAttribute(Constant.USER_KEY, (Student)object);
			//���û����ʹ���session��
		}else if(object instanceof Teacher)
		{
			session.setAttribute(Constant.USER_KEY, (Teacher)object);
			//���û����ʹ���session��
		}
		
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
