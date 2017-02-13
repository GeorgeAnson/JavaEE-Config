package com.easyshare.service;

import java.util.List;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Fund;

public interface FundService {
	
	
	/**
	 * ���ʽ���Ϣ�뽻������Ϣ��������
	 * 		���������Ϣ������״̬Ϊ
	 * @param funds
	 * 		List<Fund>
	 * @param commonUserInfos
	 * 		List<CommonUserInfo>
	 * @return
	 * 		List<Fund>
	 */
	List<Fund> combineFundInfo(List<Fund> funds, List<CommonUserInfo> commonUserInfos);

	
	/**
	 * ���ʽ���Ϣ�뽻������Ϣ��������
	 * 		���˱�ɾ�������ݣ����ų�status==-1������
	 * @param funds
	 * 		List<Fund>
	 * @param commonUserInfos
	 * 		List<CommonUserInfo>
	 * @param status
	 * 		Object
	 * 			null || -1 || 1
	 * 			�޲�  || ��ɾ�� || �������
	 * @return
	 * 		List<Fund>
	 */
	List<Fund> combineFundInfo(List<Fund> funds, List<CommonUserInfo> commonUserInfos,Object status);
	
	
	/**
	 * ��齻�׽���Ƿ�Ϸ�
	 * 		��֧���������ʱ--false
	 * 		����--true
	 * @param fund
	 * 		Fund
	 * @return
	 * 		Boolean
	 * 			false-֧���������
	 * 			true-֧��С�ڵ������
	 */
	boolean isTransationOk(Fund fund, boolean flag);
}
