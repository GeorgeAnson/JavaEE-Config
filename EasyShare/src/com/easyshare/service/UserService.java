package com.easyshare.service;


public interface UserService {

	
	/**
	 * �����֤���Ƿ�һ��
	 * @param rightCode ��ȷ����֤��
	 * @param code �û��������֤��
	 * @return
	 */
	boolean checkCode(String rightCode,String code);
	
	
	
	/**
	 * ���û��޸�����ʱ
	 * ��֤�ֻ��ź������Ψһ��
	 * @param email ����
	 * @param phone �ֻ���
	 * @param object �û�����
	 * @return
	 */
	boolean checkEmailAndPhone(String email,String phone,Object object);
	
	
	
	/**
	 * �����û�����
	 * @param sList ���������û���Ϣ������
	 * @return
	 */
	boolean registerUser(Object object);
	
}
