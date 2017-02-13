package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;


/**
 * �ʽ�����ʵ��
 * @author Administrator
 *
 */
public class Fund implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5584334975401515084L;
	
	private int FundID;//����ID
	private String FundName=null;//��������
	private int FundType;//��������
	private double TransationSum=0;//���׽��
	private double Balance=0;//�ʽ����
	private double Outcome=0;//�ܹ�����
	private String TransationDetail;//������ϸ
	private Date TransationDate;//֧������
	private int CommonID;//������CommonID
	private int Status=1;//״̬��0Ϊ����������ɣ�1Ϊ���ڽ����У�-1����ɾ��
	private int Opr=0;//0��ӣ�1�޸�
	
	private Object user;//�����û���Ϣ
	
	private CommonUserInfo commonUserInfo;//�����û�������Ϣ
	
	/**
	 * ��ȡ����ID
	 * @return
	 * 	int
	 */
	public int getFundID() {
		return FundID;
	}


	/**
	 * ���ÿ���ID
	 * @param fundID
	 * 		int
	 */
	public void setFundID(int fundID) {
		FundID = fundID;
	}


	/**
	 * ��ȡ��������
	 * @return
	 * 		String
	 * 			FundName
	 */
	public String getFundName() {
		return FundName;
	}


	/**
	 * ���ÿ�������
	 * @param fundName
	 * 		String
	 */
	public void setFundName(String fundName) {
		FundName = fundName;
	}


	/**
	 * ��������
	 * @return
	 * 		int
	 * 			-1֧��
	 * 			1����
	 */
	public int getFundType() {
		return FundType;
	}


	/**
	 * ��ȡ�����
	 * @return
	 * 		double
	 */
	public double getBalance() {
		return Balance;
	}


	/**
	 * ���������
	 * @param balance
	 * 		double
	 */
	public void setBalance(double balance) {
		Balance = balance;
	}


	/**
	 * ���ÿ�������
	 * @param fundType
	 * 		int
	 * 			-1֧��
	 * 			1����
	 */
	public void setFundType(int fundType) {
		FundType = fundType;
	}


	/**
	 * ��ȡ���׽��
	 * @return
	 * 		double
	 */
	public double getTransationSum() {
		return TransationSum;
	}


	/**
	 * ���ý��׽��
	 * @param teansationSum
	 * 		double
	 */
	public void setTransationSum(double transationSum) {
		TransationSum = transationSum;
	}


	/**
	 * ��ȡ������ϸ
	 * @return
	 * 		String
	 */
	public String getTransationDetail() {
		return TransationDetail;
	}


	/**
	 * ���ý�����ϸ
	 * @param transationDetail
	 * 		String
	 */
	public void setTransationDetail(String transationDetail) {
		TransationDetail = transationDetail;
	}


	/**
	 * ��ȡ����ʱ��
	 * @return
	 * 		java.sql.Date
	 */
	public Date getTransationDate() {
		return TransationDate;
	}


	/**
	 * ���ý���ʱ��
	 * @param transationDate
	 * 		java.sql.Date
	 */
	public void setTransationDate(Date transationDate) {
		TransationDate = transationDate;
	}


	/**
	 * ��ȡ�����˹���ID
	 * @return
	 * 		CommonID
	 * 			int
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * ���ý����˹���ID
	 * @param commonID
	 * 			int
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * ��ȡ���׼���¼״̬
	 * @return
	 * 		int
	 * 			0Ϊ����������ɣ�1Ϊ���ڽ����У�-1����ɾ��
	 */
	public int getStatus() {
		return Status;
	}


	/**
	 * ����һ�����׼�¼״̬
	 * @param status
	 * 			0Ϊ����������ɣ�1Ϊ���ڽ����У�-1����ɾ��
	 */
	public void setStatus(int status) {
		Status = status;
	}


	/**
	 * ��ȡ��������
	 * @return
	 * 		int
	 * 			0--���
	 * 			1--�޸�
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * ���ý�������
	 * @param opr
	 * 		int
	 * 			0--���
	 * 			1--�޸�
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}


	/**
	 * ��ȡ�����˶���
	 * @return
	 * 		Object
	 */
	public Object getUser() {
		return user;
	}


	/**
	 * ���ý����˶���
	 * @param user
	 * 			Object
	 */
	public void setUser(Object user) {
		this.user = user;
	}


	/**
	 * ��ȡ�����˵Ĺ�����Ϣ
	 * @return
	 * 		CommonUserInfo
	 */
	public CommonUserInfo getCommonUserInfo() {
		return commonUserInfo;
	}


	/**
	 * ���ý����˵Ĺ�����Ϣ
	 * @param commonUserInfo
	 * 			CommonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) {
		this.commonUserInfo = commonUserInfo;
	}


	/**
	 * ��ȡ��֧��
	 * @return
	 * 		double
	 */
	public double getOutcome() {
		return Outcome;
	}


	/**
	 * ������֧��
	 * @param outcome
	 * 		double
	 */
	public void setOutcome(double outcome) {
		Outcome = outcome;
	}
	
	
}
