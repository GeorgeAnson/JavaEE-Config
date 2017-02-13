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

	// 登录失败跳转的url
	private static String ERROR_URL;
	// 登陆成功跳转的url
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
			//如果用户名或密码或验证码为空则跳转为登录页面
			if(this.codeNumbers==null||"".equals(this.codeNumbers)
					||this.condition==null||"".equals(this.condition)
					||this.password==null||"".equals(this.password))
			{
				System.out.println("用户名或密码或验证码为空");
				forword(request, response, true, null);
				return;
			}
			
			// session域中拿到当前正确的验证码
			String rightCode = (String) request.getSession().getAttribute(Constant.CHECK_NUMBER_NAME);

			System.out.println(rightCode+"  "+codeNumbers);
			
			//验证验证码的正确性
			if(!userService.checkCode(rightCode, codeNumbers))
			{
				request.setAttribute(Constant.ERROR, "验证码不正确");
				System.out.println("验证码不正确");
				forword(request, response, true, null);
				return;
			}
			
			//通过用户名查找用户对象
			//这里的用户名为email或者phone
			Object object=userDao.getUserByCondition(condition, type);
			
			if(object==null)
			{
				request.setAttribute(Constant.ERROR, "尚未注册！");
				System.out.println("尚未注册！");
				forword(request, response, true, null);
				return;
			}
			//获取公共信息
			CommonUserInfo commonUserInfo=Utils.getUserCommonInfo(object);
			//判断用户类型是否输入正确
			if(commonUserInfo.getUserType()!=type)
			{
				request.setAttribute(Constant.ERROR, "用户类型错误！");
				System.out.println("用户类型错误！");
				forword(request, response, true, null);
				return;
			}
			
			//判断账号是否被冻结
			if(object!=null && Utils.getUserCommonInfo(object).getStatus()!=1)
			{
				request.setAttribute(Constant.ERROR, "账号正在审核中！");
				System.out.println("账号正在审核中！");
				forword(request, response, true, null);
				return;
			}
			
			//验证用户名和密码
			if(object!=null && !commonUserInfo.getPassword().equals(Utils.toMD5(password)))
			{
				request.setAttribute(Constant.ERROR, "用户名或密码错误！");
				System.out.println("用户名或密码错误！");
				forword(request, response, true, null);
				return;
			}
			
			System.out.println("执行正常");
			
			// 登陆成功，进行跳转
			forword(request, response, false, object);
		}else
		{
			//禁止url任意传参
			forword(request, response, true, null);
			return;
		}
	}

	private void forword(HttpServletRequest request, HttpServletResponse response, boolean isError,Object object)
			throws ServletException, IOException {
		// 获取session中的正确跳转后的URL 如果跳转前有存储页面链接，则跳转到登陆前的页面 如果没有，则跳转到首页
		String okUrl = getUrl(Constant.OK_URL, request);
		// 暂未实现错误链接跳转
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
			// 保存用户的相关信息（用户信息、访问记录、登录信息）
			System.out.println("保存用户信息");
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
	 * 尝试从请求中获取对应的URL值
	 * 
	 * @param key
	 *            存储URL的键值
	 * @param request
	 *            请求对象
	 * @return 获取到的URL地址
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
		// 重新开启session，方便计算用户登录时间
		request.getSession().invalidate();
		HttpSession session = request.getSession();

		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setIp(request.getRemoteAddr());
		loginInfo.setLoginName(Utils.getUserCommonInfo(object).getLoginName());
		loginInfo.setLoginTime(new Date());
		session.setAttribute("loginInfo", loginInfo);
		
		//保存用户登录信息
		CommonUserInfo commonUserInfo=Utils.getUserCommonInfo(object);
		commonUserInfo.setLoginTimes(commonUserInfo.getLoginTimes()+1);
		commonUserInfo.setRecentlyLogin(new java.sql.Date(new java.util.Date().getTime()));
		commonUserInfo.setIP(loginInfo.getIp());
		
		//更新信息,记录用户登录的ip地址，登录时间，登录次数
		userDao.update(object);
		
		// 把用户状态存入session中
		if(object instanceof Student)
		{
			session.setAttribute(Constant.USER_KEY, (Student)object);
			//将用户类型存入session中
		}else if(object instanceof Teacher)
		{
			session.setAttribute(Constant.USER_KEY, (Teacher)object);
			//将用户类型存入session中
		}
		
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
