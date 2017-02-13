package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;


/**
 * 公共信息实体
 * @author Administrator
 *
 */
public class CommonUserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7983724528374962811L;

	
	private int CommonID;//公共信息标识
	private String RealName=null;//用户真实姓名
	private String LoginName=null;//登录名
	private String Password=null;//密码
	private String HeadPic="icon.png";//头像
	private boolean Gender;//性别
	private String Email=null;//邮箱
	private String QQ=null;//QQ号
	private String WeChat=null;//微信号
	private String Phone=null;//电话号码
	private String Address=null;//通信地址
	private double Balance;//账户余额
	private Date TransferDate=null;//转账日期
	private Date CreateDate=null;//账户创建时间
	private Date RecentlyLogin=null;//最近登录时间
	private int LoginTimes=0;//登陆次数
	private int Status;//账户状态
	
	private int UserType;//用户类型，非存储数据类型
	private int AdminType=-1;//管理员类型，默认为-1，普通用户
	private String IP=null;//登录ip
	private int IsLeader=0;//是否为项目负责人，0不是，1是，默认为不是
	private boolean IsGraduate;//是否毕业
	private int Opr;//操作
	
	public int getAdminType() {
		return AdminType;
	}

	public void setAdminType(int adminType) {
		AdminType = adminType;
	}

	public CommonUserInfo()
	{
		
	}
	
	public CommonUserInfo(int commonID)
	{
		this.CommonID=commonID;
	}

	/**
	 * 获取用户公共信息标识
	 * @return
	 */
	public int getCommonID() {
		return CommonID;
	}

	/**
	 * 设置用户公共信息标识
	 * @param commonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}

	
	/**
	 * 获取用户真实姓名
	 * @return
	 */
	public String getRealName() {
		return RealName;
	}

	
	/**
	 * 设置用户真实姓名
	 * @param realName
	 */
	public void setRealName(String realName) {
		RealName = realName;
	}

	
	/**
	 * 获取用户登录名
	 * @return
	 */
	public String getLoginName() {
		return LoginName;
	}

	
	/**
	 * 设置用户登录名
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	
	/**
	 * 获取用户登录密码
	 * @return
	 */
	public String getPassword() {
		return Password;
	}

	
	/**
	 * 设置用户登录密码
	 * @param password
	 */
	public void setPassword(String password) {
		Password = password;
	}

	
	/**
	 * 获取用户头像
	 * @return
	 */
	public String getHeadPic() {
		return HeadPic;
	}

	
	/**
	 * 设置用户头像
	 * @param headPic
	 */
	public void setHeadPic(String headPic) {
		HeadPic = headPic;
	}

	
	/**
	 * 获取用户性别
	 * @return
	 */
	public boolean isGender() {
		return Gender;
	}

	
	/**
	 * 设置用户性别
	 * @param gender
	 */
	public void setGender(boolean gender) {
		Gender = gender;
	}

	
	/**
	 * 获取用户邮箱
	 * @return
	 */
	public String getEmail() {
		return Email;
	}

	
	/**
	 * 设置用户邮箱
	 * @param email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	
	/**
	 * 获取用户QQ号
	 * @return
	 */
	public String getQQ() {
		return QQ;
	}

	
	/**
	 * 设置用户QQ号
	 * @param qQ
	 */
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	
	/**
	 * 获取用户微信号
	 * @return
	 */
	public String getWeChat() {
		return WeChat;
	}

	
	/**
	 * 设置用户微信号
	 * @param weChat
	 */
	public void setWeChat(String weChat) {
		WeChat = weChat;
	}

	
	/**
	 * 获取用户电话号码
	 * @return
	 */
	public String getPhone() {
		return Phone;
	}

	
	/**
	 * 设置用户电话号码
	 * @param phone
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	
	/**
	 * 获取用户通信地址
	 * @return
	 */
	public String getAddress() {
		return Address;
	}

	
	/**
	 * 设置用户通信地址
	 * @param address
	 */
	public void setAddress(String address) {
		Address = address;
	}

	
	/**
	 * 获取账户余额
	 * @return
	 */
	public double getBalance() {
		return Balance;
	}

	
	/**
	 * 设置账户余额
	 * @param balance
	 */
	public void setBalance(double balance) {
		Balance = balance;
	}

	
	/**
	 * 获取转账时间
	 * @return
	 */
	public Date getTransferDate() {
		return TransferDate;
	}

	
	/**
	 * 设置转账时间
	 * @param transferDate
	 */
	public void setTransferDate(Date transferDate) {
		TransferDate = transferDate;
	}

	
	/**
	 * 获取账户创建时间
	 * @return
	 */
	public Date getCreateDate() {
		return CreateDate;
	}

	
	/**
	 * 设置账户创建时间
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	
	/**
	 * 获取用户最近登录时间
	 * @return
	 */
	public Date getRecentlyLogin() {
		return RecentlyLogin;
	}

	
	/**
	 * 设置用户最近登录时间
	 * @param recentlyLogin
	 */
	public void setRecentlyLogin(Date recentlyLogin) {
		RecentlyLogin = recentlyLogin;
	}

	
	/**
	 * 获取用户登录次数
	 * @return
	 */
	public int getLoginTimes() {
		return LoginTimes;
	}

	
	/**
	 * 设置用户登录次数
	 * @param loginTimes
	 */
	public void setLoginTimes(int loginTimes) {
		LoginTimes = loginTimes;
	}

	
	/**
	 * 获取用户账号状态
	 * @return
	 */	
	public int getStatus() {
		return Status;
	}

	

	/**
	 * 设置用户账户状态
	 * @param status
	 */
	public void setStatus(int status) {
		Status = status;
	}

	/**
	 * 
	 * 获取用户类型
	 * @return
	 */
	public int getUserType() {
		return UserType;
	}
	/**
	 * 设置用户类型
	 * @param userType
	 */
	public void setUserType(int userType) {
		UserType = userType;
	}

	/**
	 * 获取上次登录IP
	 * @return
	 * 		String
	 */
	public String getIP() {
		return IP;
	}

	
	/**
	 * 设置上次登录IP
	 * @param iP
	 * 		String
	 */
	public void setIP(String iP) {
		IP = iP;
	}

	/**
	 * 获取是否为项目负责人
	 * @return
	 * 		int
	 * 			0-不是
	 * 			1-是
	 */
	public int getIsLeader() {
		return IsLeader;
	}

	/**
	 * 设置是否为项目负责人
	 * @param isLeader
	 * 		int 
	 * 			IsLeader
	 */
	public void setIsLeader(int isLeader) {
		IsLeader = isLeader;
	}

	/**
	 * 获取毕业信息
	 * @return
	 * 	Boolean
	 * 		false未毕业
	 * 		true已毕业
	 */
	public boolean isIsGraduate() {
		return IsGraduate;
	}
	

	/**
	 * 设置毕业信息
	 * @param isGraduate
	 * 		false未毕业
	 * 		true已经毕业
	 */
	public void setIsGraduate(boolean isGraduate) {
		IsGraduate = isGraduate;
	}

	/**
	 * 获取操作类型
	 * @return
	 * 	int
	 * 		0-添加
	 * 		1-修改
	 */
	public int getOpr() {
		return Opr;
	}

	
	/**
	 * 设置操作类型
	 * @param opr
	 * 		int	
	 * 			0-添加
	 * 			1-修改
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}
	
	
}
