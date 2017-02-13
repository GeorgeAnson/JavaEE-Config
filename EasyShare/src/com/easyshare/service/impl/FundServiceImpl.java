package com.easyshare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyshare.dao.FundDao;
import com.easyshare.dao.jdbc.FundDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Fund;
import com.easyshare.service.FundService;

@Service("fundService")
public class FundServiceImpl implements FundService {

	@Autowired
	private FundDao fundDao=new FundDaoImpl();
	
	@Override
	public List<Fund> combineFundInfo(List<Fund> funds, List<CommonUserInfo> commonUserInfos) {
		
		return combineFundInfo(funds,commonUserInfos,null);
	}

	@Override
	public List<Fund> combineFundInfo(List<Fund> funds, List<CommonUserInfo> commonUserInfos, Object status) {
		//匹配并绑定所有资金记录与交易人
		List<Fund> allFunds=new ArrayList<Fund>();
		
		//余额计算
		double balance=0;
		double outcome=0;
		//遍历交易数据
		for(Fund item: funds)
		{
			//针对已完成的交易
			if(item.getStatus()==0)
			{
				if(item.getFundType()==1)
				{
					//交易类型为收入
					balance+=item.getTransationSum();
				}else
				{
					//交易为支出
					outcome+=item.getTransationSum();
					balance-=item.getTransationSum();
				}
			}
			//设置余额及消费总额
			item.setBalance(balance);
			item.setOutcome(outcome);
			//遍历注册成员信息
			for(CommonUserInfo commonUserInfo:commonUserInfos)
			{
				//若公共ID匹配，则当前公共信息为交易人信息
				if(item.getCommonID()==commonUserInfo.getCommonID())
				{
					//绑定交易人信息
					item.setCommonUserInfo(commonUserInfo);
					//获取该绑定数据，非null，按条件绑定已删除类型记录或正常交易数据
					if(status!=null && (Integer)status==item.getStatus())
					{
						allFunds.add(item);
					}
					//status为null，commonID相同，绑定
					if(status==null)
					{
						allFunds.add(item);
					}
				}
			}	
		}
		return allFunds;
	}

	@Override
	public boolean isTransationOk(Fund fund, boolean flag) {
		double balance=0;
		List<Fund> funds=fundDao.getFundByTransationName("");
		//计算当前余额
		for(Fund item:funds)
		{
			//针对已完成的的交易
			if(item.getStatus()==0)
			{
				//判断交易类型
				if(item.getFundType()==1)
				{
					//若为收入
					balance+=item.getTransationSum();
				}else
				{
					//若为支出
					balance-=item.getTransationSum();
				}
			}
			
			//当参数为true时，计算balance时，排除本身记录
			if(item.getFundID()==fund.getFundID() && flag)
			{
				if(item.getStatus()==0)
				{
					if(item.getFundType()==1)
					{
						//若之前计算时为收入，则减去
						balance-=item.getTransationSum();
					}else
					{
						//若为支出，则加上
						balance+=item.getTransationSum();
					}
				}
			}
		}
		
		//若为收入，则通过
		if(fund.getFundType()==1)
		{
			return true;
		}
		
		//当交易情况为支出时,余额大于等于交易金额，通过
		if(fund.getTransationSum()<=balance)
		{
			return true;
		}
		
		return false;
	}

}
