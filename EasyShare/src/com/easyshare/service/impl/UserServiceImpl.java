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
 * �洢�û���Ϣ�ı��service��
 * @author Administrator
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * ��֤��֤�����ȷ��
	 * @param rightCode ��ȡ����֤��
	 * @param code User�������֤��
	 * @return
	 */
	@Override
	public boolean checkCode(String rightCode, String code) {
		boolean flag=false;
		try
		{
			//�����if�������ж���ȷ����֤���Ƿ�Ϊ�գ��û��������֤���Ƿ�Ϊ����JS�ж�
			if((rightCode!=null)||(!"".equals(rightCode)))
			{
				rightCode=rightCode.toUpperCase();
				code=code.toUpperCase();
				//�����ȷ���򷵻�true
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
	 * ��User�޸�����ʱ
	 * ���User�ֻ����Լ������Ψһ��
	 * @param email ����
	 * @param phone �ֻ���
	 * @param object Student/Teacher/Admin����
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
			
			
			System.out.println(commonUserInfo.getPhone());//�����Ƿ�����ֵ
			
			//������ֻ��Ų�ͬ��ԭ����
			if(!phone.equals(commonUserInfo.getPhone()))
			{
				//���������ݿ���û���ظ���
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
	 * ����User���������ݿ�
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
			System.out.println("��UserServiceImpl��ע��ʧ��");
		}
		return flag;
	}

}
