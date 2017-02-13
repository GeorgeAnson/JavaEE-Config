package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;

/**
 * 针对所有用户，除陌生人
 * @author Administrator
 *
 */
public interface UserDao {

	/**
	 * 通过邮箱或者手机号查找
	 * @param condition 邮箱或者手机号
	 * @return 返回用户对象
	 */
	Object getUserByCondition(String condition,int userType);
	
	
	/**
	 * 保存注册的用户对象
	 * @param 用户对象
	 */
	void save(Object object);
	
	
	/**
	 * 保存或者更新User对象
	 * @param object
	 */
	void update(Object object);
	
	
	/**
	 * 通过用户ID号查找用户对象
	 * @param userID
	 * @return 返回用户对象对象
	 */
	Object getUserById(int userID,int userType);
	
	/**
	 * 通过用户的CommonID查找用户信息
	 * @param commonID
	 * 			Int
	 * @return
	 * 			Object
	 */
	CommonUserInfo getUserInfoByCommonId(int commonID);

	
	/**
	 * 通过关键字搜索用户通用信息
	 * 关键字限定为手机或者邮箱
	 *
	 * 
	 */
	List<CommonUserInfo> getAllCommonUserInfo();
	
	
	/**
	 * 通过学生的学号或者学生的年级或者学生的饿部门搜索学生信息
	 * 
	 * 				模糊检索	
	 * 
	 * 			若为空，则默认搜索所有学生信息
	 * 
	 * @param condition
	 * 			StudentNum		学生学号
	 * 			Grdae			年级
	 * 			Major			专业
	 * 			Apartment 		部门
	 * @return
	 * 		List<Student>
	 */
	List<Student> getStudentByCondition(String condition);
	
	
	/**
	 * 通过教师的信息搜索教师
	 * 		模糊检索
	 * 			
	 * @param condition
	 * 			ProfessionalTitle   教师职称
	 * 			Phone			教师电话
	 * 			Email			教师邮箱
	 * @return
	 * 
	 * 			List<Teacher>
	 */
	List<Teacher> getTeacherByContidion(String condition);
	
}
