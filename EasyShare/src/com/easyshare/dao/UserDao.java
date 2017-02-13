package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;

/**
 * ��������û�����İ����
 * @author Administrator
 *
 */
public interface UserDao {

	/**
	 * ͨ����������ֻ��Ų���
	 * @param condition ��������ֻ���
	 * @return �����û�����
	 */
	Object getUserByCondition(String condition,int userType);
	
	
	/**
	 * ����ע����û�����
	 * @param �û�����
	 */
	void save(Object object);
	
	
	/**
	 * ������߸���User����
	 * @param object
	 */
	void update(Object object);
	
	
	/**
	 * ͨ���û�ID�Ų����û�����
	 * @param userID
	 * @return �����û��������
	 */
	Object getUserById(int userID,int userType);
	
	/**
	 * ͨ���û���CommonID�����û���Ϣ
	 * @param commonID
	 * 			Int
	 * @return
	 * 			Object
	 */
	CommonUserInfo getUserInfoByCommonId(int commonID);

	
	/**
	 * ͨ���ؼ��������û�ͨ����Ϣ
	 * �ؼ����޶�Ϊ�ֻ���������
	 *
	 * 
	 */
	List<CommonUserInfo> getAllCommonUserInfo();
	
	
	/**
	 * ͨ��ѧ����ѧ�Ż���ѧ�����꼶����ѧ���Ķ���������ѧ����Ϣ
	 * 
	 * 				ģ������	
	 * 
	 * 			��Ϊ�գ���Ĭ����������ѧ����Ϣ
	 * 
	 * @param condition
	 * 			StudentNum		ѧ��ѧ��
	 * 			Grdae			�꼶
	 * 			Major			רҵ
	 * 			Apartment 		����
	 * @return
	 * 		List<Student>
	 */
	List<Student> getStudentByCondition(String condition);
	
	
	/**
	 * ͨ����ʦ����Ϣ������ʦ
	 * 		ģ������
	 * 			
	 * @param condition
	 * 			ProfessionalTitle   ��ʦְ��
	 * 			Phone			��ʦ�绰
	 * 			Email			��ʦ����
	 * @return
	 * 
	 * 			List<Teacher>
	 */
	List<Teacher> getTeacherByContidion(String condition);
	
}
