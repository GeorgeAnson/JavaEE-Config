package com.easyshare.entity;

import java.io.Serializable;

/**
 * �û���Ϣ��ϵʵ��
 * @author Administrator
 *
 */
public class UserConnection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7631810144951046347L;

	
	private int UserConnectionID;//�û���Ϣ��ϵID
	private int CommonID;//������ϢID
	private int StudentID;//ѧ��ID
	private int TeacherID;//��ʦID
	private int AdminID;//����ԱID
	
	
	/**
	 * ��ȡ�û���Ϣ��ϵID
	 * @return
	 */
	public int getUserConnectionID()
	{
		return UserConnectionID;
	}
	
	
	/**
	 * �����û���Ϣ��ϵID
	 * @param userConnectionID
	 */
	public void setUserConnectionID(int userConnectionID)
	{
		UserConnectionID = userConnectionID;
	}
	
	
	/**
	 * ��ȡ������ϢID
	 * @return
	 */
	public int getCommonID()
	{
		return CommonID;
	}
	
	
	/**
	 * ���ù�����Ϣ��ϵID
	 * @param commonID
	 */
	public void setCommonID(int commonID)
	{
		CommonID = commonID;
	}
	
	
	/**
	 * ��ȡѧ��ID
	 * @return
	 */
	public int getStudentID()
	{
		return StudentID;
	}
	
	
	/**
	 * ����ѧ��ID
	 * @param studentID
	 */
	public void setStudentID(int studentID)
	{
		StudentID = studentID;
	}
	
	
	/**
	 * ��ȡ��ʦID
	 * @return
	 */
	public int getTeacherID()
	{
		return TeacherID;
	}
	
	
	/**
	 * ���ý�ʦID
	 * @param teacherID
	 */
	public void setTeacherID(int teacherID)
	{
		TeacherID = teacherID;
	}
	
	
	/**
	 * ��ȡ����ԱID
	 * @return
	 */
	public int getAdminID()
	{
		return AdminID;
	}
	
	
	/**
	 * ���ù���ԱID
	 * @param adminID
	 */
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	
	
	
}
