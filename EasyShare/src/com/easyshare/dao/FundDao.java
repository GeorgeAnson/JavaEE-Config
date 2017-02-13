package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.Fund;

/**
 * �����ʽ�������
 * @author Administrator
 *
 */
public interface FundDao {

	
	/**
	 * ͨ���������ƻ�ȡ��������
	 * 		��Ժ��ڵķ������
	 * @param transationName
	 */
	List<Fund> getFundByTransationName(String transationName);
	
	
	/**
	 * ����һ�����׼�¼
	 * @param fund
	 * 		Fund
	 */
	void save(Fund fund);
	
	
	/**
	 * ����һ�����׼�¼
	 * @param fund
	 * 		Fund
	 */
	void update(Fund fund);
	
	/**
	 * ͨ������ID�Ų��ҽ��׼�¼
	 * @param fundID
	 * 			int
	 * @return
	 * 		Fund
	 */
	Fund getFundByFundID(int fundID);
}
