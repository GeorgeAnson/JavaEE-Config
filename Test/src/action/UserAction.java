package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UserDao;
import service.impl.UserDaoImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user=new User();
	// login
	public String login(){
		System.out.println("---现在开始核对校验登录---");
		UserDao uDao=new UserDaoImpl(); 
		if (uDao.userLogin(user)) {
			System.out.println("=======登录成功===============");
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
			
		}else {
			System.out.println("000-----失败---------0000000");
			return "login_failure";
		}
	}
	
	
	// logout
	@SkipValidation
	public String logout(){
		if (session.getAttribute("loginUsername")!=null) {
			session.removeAttribute("loginUsername");
		}
		System.out.println("----安全退出-----");
		return "logout_success";
	}
	
	 //validator
		@Override
		public void validate(){
			if ("".equals(user.getUsername().trim())) {
				this.addFieldError("usernameError", "用户名不能为空");
			}
			
			if ("".equals(user.getPassword().trim())) {
				this.addFieldError("passwordError", "密码不能为空");
			}
			 		 
		} 
	@Override
	public User getModel() {
		 
		return this.user;
	}

	 
}
