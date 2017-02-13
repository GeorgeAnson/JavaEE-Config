package com.easyshare.service;

import java.util.List;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Fund;

public interface FundService {
	
	
	/**
	 * 将资金信息与交易人信息进行捆绑
	 * 		针对所有信息，包括状态为
	 * @param funds
	 * 		List<Fund>
	 * @param commonUserInfos
	 * 		List<CommonUserInfo>
	 * @return
	 * 		List<Fund>
	 */
	List<Fund> combineFundInfo(List<Fund> funds, List<CommonUserInfo> commonUserInfos);

	
	/**
	 * 将资金信息与交易人信息进行捆绑
	 * 		除了被删除的数据，及排除status==-1的数据
	 * @param funds
	 * 		List<Fund>
	 * @param commonUserInfos
	 * 		List<CommonUserInfo>
	 * @param status
	 * 		Object
	 * 			null || -1 || 1
	 * 			无参  || 已删除 || 正常完成
	 * @return
	 * 		List<Fund>
	 */
	List<Fund> combineFundInfo(List<Fund> funds, List<CommonUserInfo> commonUserInfos,Object status);
	
	
	/**
	 * 检查交易金额是否合法
	 * 		当支出金额超过余额时--false
	 * 		否则--true
	 * @param fund
	 * 		Fund
	 * @return
	 * 		Boolean
	 * 			false-支出金额超出余额
	 * 			true-支出小于等于余额
	 */
	boolean isTransationOk(Fund fund, boolean flag);
}
