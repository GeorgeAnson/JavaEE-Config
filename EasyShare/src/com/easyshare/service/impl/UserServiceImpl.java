package com.easyshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.service.UserService;

/**
 * 存储用户信息的表的service类
 * @author Administrator
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 验证验证码的正确性
	 * @param rightCode 争取的验证码
	 * @param code User输入的验证码
	 * @return
	 */
	@Override
	public boolean checkCode(String rightCode, String code) {
		boolean flag=false;
		try
		{
			//这里的if条件仅判断正确的验证码是否为空，用户输入的验证码是否为空由JS判断
			if((rightCode!=null)||(!"".equals(rightCode)))
			{
				rightCode=rightCode.toUpperCase();
				code=code.toUpperCase();
				//如果正确，则返回true
				if(rightCode.equals(code))
				{
					flag=true;
				}
			}
		}catch(Exception e)
		{
			
		}
		return flag;
	}

	
	/**
	 * 在User修改数据时
	 * 检查User手机号以及邮箱的唯一性
	 * @param email 邮箱
	 * @param phone 手机号
	 * @param object Student/Teacher/Admin对象
	 * @return
	 */
	@Override
	public boolean checkEmailAndPhone(String email, String phone,Object object) {
		
		boolean flag=false;
		CommonUserInfo commonUserInfo=null;
		
		try
		{
			boolean isPhone=false,isEmail=false;
			if(object instanceof Student)
			{
				Student student=(Student) object;
				commonUserInfo=student.getCommonUserInfo();
				
			}else if(object instanceof Teacher)
			{
				Teacher teacher=(Teacher)object;
				commonUserInfo=teacher.getCommonUserInfo();
			}
			
			
			System.out.println(commonUserInfo.getPhone());//测试是否有数值
			
			//输入的手机号不同于原来的
			if(!phone.equals(commonUserInfo.getPhone()))
			{
				//并且在数据库中没有重复的
				if(userDao.getUserByCondition(phone,commonUserInfo.getUserType())==null)
				{
					isEmail=true;
				}
			}
			
			if(!email.equals(commonUserInfo.getEmail()))
			{
				if(userDao.getUserByCondition(email,commonUserInfo.getUserType())==null)
				{
					isPhone=true;
				}
			}
			
			
			if(isEmail&&isPhone)
			{
				flag=true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	
	/**
	 * 保存User对象至数据库
	 */
	@Override
	public boolean registerUser(Object object) {
		boolean flag=false;
		try
		{
			userDao.save(object);
			flag=true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("在UserServiceImpl中注册失败");
		}
		return flag;
	}

}
