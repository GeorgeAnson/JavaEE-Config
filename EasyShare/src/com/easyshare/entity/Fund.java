package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;


/**
 * 资金流动实体
 * @author Administrator
 *
 */
public class Fund implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5584334975401515084L;
	
	private int FundID;//款项ID
	private String FundName=null;//款项名称
	private int FundType;//交易类型
	private double TransationSum=0;//交易金额
	private double Balance=0;//资金余额
	private double Outcome=0;//总共消费
	private String TransationDetail;//交易明细
	private Date TransationDate;//支出日期
	private int CommonID;//交易人CommonID
	private int Status=1;//状态，0为交易正常完成，1为正在进行中，-1数据删除
	private int Opr=0;//0添加，1修改
	
	private Object user;//保存用户信息
	
	private CommonUserInfo commonUserInfo;//保存用户公共信息
	
	/**
	 * 获取款项ID
	 * @return
	 * 	int
	 */
	public int getFundID() {
		return FundID;
	}


	/**
	 * 设置款项ID
	 * @param fundID
	 * 		int
	 */
	public void setFundID(int fundID) {
		FundID = fundID;
	}


	/**
	 * 获取款项名称
	 * @return
	 * 		String
	 * 			FundName
	 */
	public String getFundName() {
		return FundName;
	}


	/**
	 * 设置款项名称
	 * @param fundName
	 * 		String
	 */
	public void setFundName(String fundName) {
		FundName = fundName;
	}


	/**
	 * 款项类型
	 * @return
	 * 		int
	 * 			-1支出
	 * 			1收入
	 */
	public int getFundType() {
		return FundType;
	}


	/**
	 * 获取总余额
	 * @return
	 * 		double
	 */
	public double getBalance() {
		return Balance;
	}


	/**
	 * 设置总余额
	 * @param balance
	 * 		double
	 */
	public void setBalance(double balance) {
		Balance = balance;
	}


	/**
	 * 设置款项类型
	 * @param fundType
	 * 		int
	 * 			-1支出
	 * 			1收入
	 */
	public void setFundType(int fundType) {
		FundType = fundType;
	}


	/**
	 * 获取交易金额
	 * @return
	 * 		double
	 */
	public double getTransationSum() {
		return TransationSum;
	}


	/**
	 * 设置交易金额
	 * @param teansationSum
	 * 		double
	 */
	public void setTransationSum(double transationSum) {
		TransationSum = transationSum;
	}


	/**
	 * 获取交易明细
	 * @return
	 * 		String
	 */
	public String getTransationDetail() {
		return TransationDetail;
	}


	/**
	 * 设置交易明细
	 * @param transationDetail
	 * 		String
	 */
	public void setTransationDetail(String transationDetail) {
		TransationDetail = transationDetail;
	}


	/**
	 * 获取交易时间
	 * @return
	 * 		java.sql.Date
	 */
	public Date getTransationDate() {
		return TransationDate;
	}


	/**
	 * 设置交易时间
	 * @param transationDate
	 * 		java.sql.Date
	 */
	public void setTransationDate(Date transationDate) {
		TransationDate = transationDate;
	}


	/**
	 * 获取交易人公共ID
	 * @return
	 * 		CommonID
	 * 			int
	 */
	public int getCommonID() {
		return CommonID;
	}


	/**
	 * 设置交易人公共ID
	 * @param commonID
	 * 			int
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}


	/**
	 * 获取交易及记录状态
	 * @return
	 * 		int
	 * 			0为交易正常完成，1为正在进行中，-1数据删除
	 */
	public int getStatus() {
		return Status;
	}


	/**
	 * 设置一条交易记录状态
	 * @param status
	 * 			0为交易正常完成，1为正在进行中，-1数据删除
	 */
	public void setStatus(int status) {
		Status = status;
	}


	/**
	 * 获取操作类型
	 * @return
	 * 		int
	 * 			0--添加
	 * 			1--修改
	 */
	public int getOpr() {
		return Opr;
	}


	/**
	 * 设置交易类型
	 * @param opr
	 * 		int
	 * 			0--添加
	 * 			1--修改
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}


	/**
	 * 获取交易人对象
	 * @return
	 * 		Object
	 */
	public Object getUser() {
		return user;
	}


	/**
	 * 设置交易人对象
	 * @param user
	 * 			Object
	 */
	public void setUser(Object user) {
		this.user = user;
	}


	/**
	 * 获取交易人的公共信息
	 * @return
	 * 		CommonUserInfo
	 */
	public CommonUserInfo getCommonUserInfo() {
		return commonUserInfo;
	}


	/**
	 * 设置交易人的公共信息
	 * @param commonUserInfo
	 * 			CommonUserInfo
	 */
	public void setCommonUserInfo(CommonUserInfo commonUserInfo) {
		this.commonUserInfo = commonUserInfo;
	}


	/**
	 * 获取总支出
	 * @return
	 * 		double
	 */
	public double getOutcome() {
		return Outcome;
	}


	/**
	 * 设置总支出
	 * @param outcome
	 * 		double
	 */
	public void setOutcome(double outcome) {
		Outcome = outcome;
	}
	
	
}
