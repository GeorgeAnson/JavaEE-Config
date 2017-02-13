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
		//ƥ�䲢�������ʽ��¼�뽻����
		List<Fund> allFunds=new ArrayList<Fund>();
		
		//������
		double balance=0;
		double outcome=0;
		//������������
		for(Fund item: funds)
		{
			//�������ɵĽ���
			if(item.getStatus()==0)
			{
				if(item.getFundType()==1)
				{
					//��������Ϊ����
					balance+=item.getTransationSum();
				}else
				{
					//����Ϊ֧��
					outcome+=item.getTransationSum();
					balance-=item.getTransationSum();
				}
			}
			//�����������ܶ�
			item.setBalance(balance);
			item.setOutcome(outcome);
			//����ע���Ա��Ϣ
			for(CommonUserInfo commonUserInfo:commonUserInfos)
			{
				//������IDƥ�䣬��ǰ������ϢΪ��������Ϣ
				if(item.getCommonID()==commonUserInfo.getCommonID())
				{
					//�󶨽�������Ϣ
					item.setCommonUserInfo(commonUserInfo);
					//��ȡ�ð����ݣ���null������������ɾ�����ͼ�¼��������������
					if(status!=null && (Integer)status==item.getStatus())
					{
						allFunds.add(item);
					}
					//statusΪnull��commonID��ͬ����
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
		//���㵱ǰ���
		for(Fund item:funds)
		{
			//�������ɵĵĽ���
			if(item.getStatus()==0)
			{
				//�жϽ�������
				if(item.getFundType()==1)
				{
					//��Ϊ����
					balance+=item.getTransationSum();
				}else
				{
					//��Ϊ֧��
					balance-=item.getTransationSum();
				}
			}
			
			//������Ϊtrueʱ������balanceʱ���ų������¼
			if(item.getFundID()==fund.getFundID() && flag)
			{
				if(item.getStatus()==0)
				{
					if(item.getFundType()==1)
					{
						//��֮ǰ����ʱΪ���룬���ȥ
						balance-=item.getTransationSum();
					}else
					{
						//��Ϊ֧���������
						balance+=item.getTransationSum();
					}
				}
			}
		}
		
		//��Ϊ���룬��ͨ��
		if(fund.getFundType()==1)
		{
			return true;
		}
		
		//���������Ϊ֧��ʱ,�����ڵ��ڽ��׽�ͨ��
		if(fund.getTransationSum()<=balance)
		{
			return true;
		}
		
		return false;
	}

}
