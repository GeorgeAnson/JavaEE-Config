package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.Fund;

/**
 * 交易资金管理服务
 * @author Administrator
 *
 */
public interface FundDao {

	
	/**
	 * 通过交易名称获取交易数据
	 * 		针对后期的分类检索
	 * @param transationName
	 */
	List<Fund> getFundByTransationName(String transationName);
	
	
	/**
	 * 保存一条交易记录
	 * @param fund
	 * 		Fund
	 */
	void save(Fund fund);
	
	
	/**
	 * 更新一条交易记录
	 * @param fund
	 * 		Fund
	 */
	void update(Fund fund);
	
	/**
	 * 通过交易ID号查找交易记录
	 * @param fundID
	 * 			int
	 * @return
	 * 		Fund
	 */
	Fund getFundByFundID(int fundID);
}
