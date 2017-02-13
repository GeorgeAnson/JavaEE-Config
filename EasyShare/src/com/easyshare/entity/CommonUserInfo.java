package com.easyshare.entity;

import java.io.Serializable;
import java.sql.Date;


/**
 * ������Ϣʵ��
 * @author Administrator
 *
 */
public class CommonUserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7983724528374962811L;

	
	private int CommonID;//������Ϣ��ʶ
	private String RealName=null;//�û���ʵ����
	private String LoginName=null;//��¼��
	private String Password=null;//����
	private String HeadPic="icon.png";//ͷ��
	private boolean Gender;//�Ա�
	private String Email=null;//����
	private String QQ=null;//QQ��
	private String WeChat=null;//΢�ź�
	private String Phone=null;//�绰����
	private String Address=null;//ͨ�ŵ�ַ
	private double Balance;//�˻����
	private Date TransferDate=null;//ת������
	private Date CreateDate=null;//�˻�����ʱ��
	private Date RecentlyLogin=null;//�����¼ʱ��
	private int LoginTimes=0;//��½����
	private int Status;//�˻�״̬
	
	private int UserType;//�û����ͣ��Ǵ洢��������
	private int AdminType=-1;//����Ա���ͣ�Ĭ��Ϊ-1����ͨ�û�
	private String IP=null;//��¼ip
	private int IsLeader=0;//�Ƿ�Ϊ��Ŀ�����ˣ�0���ǣ�1�ǣ�Ĭ��Ϊ����
	private boolean IsGraduate;//�Ƿ��ҵ
	private int Opr;//����
	
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
	 * ��ȡ�û�������Ϣ��ʶ
	 * @return
	 */
	public int getCommonID() {
		return CommonID;
	}

	/**
	 * �����û�������Ϣ��ʶ
	 * @param commonID
	 */
	public void setCommonID(int commonID) {
		CommonID = commonID;
	}

	
	/**
	 * ��ȡ�û���ʵ����
	 * @return
	 */
	public String getRealName() {
		return RealName;
	}

	
	/**
	 * �����û���ʵ����
	 * @param realName
	 */
	public void setRealName(String realName) {
		RealName = realName;
	}

	
	/**
	 * ��ȡ�û���¼��
	 * @return
	 */
	public String getLoginName() {
		return LoginName;
	}

	
	/**
	 * �����û���¼��
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	
	/**
	 * ��ȡ�û���¼����
	 * @return
	 */
	public String getPassword() {
		return Password;
	}

	
	/**
	 * �����û���¼����
	 * @param password
	 */
	public void setPassword(String password) {
		Password = password;
	}

	
	/**
	 * ��ȡ�û�ͷ��
	 * @return
	 */
	public String getHeadPic() {
		return HeadPic;
	}

	
	/**
	 * �����û�ͷ��
	 * @param headPic
	 */
	public void setHeadPic(String headPic) {
		HeadPic = headPic;
	}

	
	/**
	 * ��ȡ�û��Ա�
	 * @return
	 */
	public boolean isGender() {
		return Gender;
	}

	
	/**
	 * �����û��Ա�
	 * @param gender
	 */
	public void setGender(boolean gender) {
		Gender = gender;
	}

	
	/**
	 * ��ȡ�û�����
	 * @return
	 */
	public String getEmail() {
		return Email;
	}

	
	/**
	 * �����û�����
	 * @param email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	
	/**
	 * ��ȡ�û�QQ��
	 * @return
	 */
	public String getQQ() {
		return QQ;
	}

	
	/**
	 * �����û�QQ��
	 * @param qQ
	 */
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	
	/**
	 * ��ȡ�û�΢�ź�
	 * @return
	 */
	public String getWeChat() {
		return WeChat;
	}

	
	/**
	 * �����û�΢�ź�
	 * @param weChat
	 */
	public void setWeChat(String weChat) {
		WeChat = weChat;
	}

	
	/**
	 * ��ȡ�û��绰����
	 * @return
	 */
	public String getPhone() {
		return Phone;
	}

	
	/**
	 * �����û��绰����
	 * @param phone
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	
	/**
	 * ��ȡ�û�ͨ�ŵ�ַ
	 * @return
	 */
	public String getAddress() {
		return Address;
	}

	
	/**
	 * �����û�ͨ�ŵ�ַ
	 * @param address
	 */
	public void setAddress(String address) {
		Address = address;
	}

	
	/**
	 * ��ȡ�˻����
	 * @return
	 */
	public double getBalance() {
		return Balance;
	}

	
	/**
	 * �����˻����
	 * @param balance
	 */
	public void setBalance(double balance) {
		Balance = balance;
	}

	
	/**
	 * ��ȡת��ʱ��
	 * @return
	 */
	public Date getTransferDate() {
		return TransferDate;
	}

	
	/**
	 * ����ת��ʱ��
	 * @param transferDate
	 */
	public void setTransferDate(Date transferDate) {
		TransferDate = transferDate;
	}

	
	/**
	 * ��ȡ�˻�����ʱ��
	 * @return
	 */
	public Date getCreateDate() {
		return CreateDate;
	}

	
	/**
	 * �����˻�����ʱ��
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	
	/**
	 * ��ȡ�û������¼ʱ��
	 * @return
	 */
	public Date getRecentlyLogin() {
		return RecentlyLogin;
	}

	
	/**
	 * �����û������¼ʱ��
	 * @param recentlyLogin
	 */
	public void setRecentlyLogin(Date recentlyLogin) {
		RecentlyLogin = recentlyLogin;
	}

	
	/**
	 * ��ȡ�û���¼����
	 * @return
	 */
	public int getLoginTimes() {
		return LoginTimes;
	}

	
	/**
	 * �����û���¼����
	 * @param loginTimes
	 */
	public void setLoginTimes(int loginTimes) {
		LoginTimes = loginTimes;
	}

	
	/**
	 * ��ȡ�û��˺�״̬
	 * @return
	 */	
	public int getStatus() {
		return Status;
	}

	

	/**
	 * �����û��˻�״̬
	 * @param status
	 */
	public void setStatus(int status) {
		Status = status;
	}

	/**
	 * 
	 * ��ȡ�û�����
	 * @return
	 */
	public int getUserType() {
		return UserType;
	}
	/**
	 * �����û�����
	 * @param userType
	 */
	public void setUserType(int userType) {
		UserType = userType;
	}

	/**
	 * ��ȡ�ϴε�¼IP
	 * @return
	 * 		String
	 */
	public String getIP() {
		return IP;
	}

	
	/**
	 * �����ϴε�¼IP
	 * @param iP
	 * 		String
	 */
	public void setIP(String iP) {
		IP = iP;
	}

	/**
	 * ��ȡ�Ƿ�Ϊ��Ŀ������
	 * @return
	 * 		int
	 * 			0-����
	 * 			1-��
	 */
	public int getIsLeader() {
		return IsLeader;
	}

	/**
	 * �����Ƿ�Ϊ��Ŀ������
	 * @param isLeader
	 * 		int 
	 * 			IsLeader
	 */
	public void setIsLeader(int isLeader) {
		IsLeader = isLeader;
	}

	/**
	 * ��ȡ��ҵ��Ϣ
	 * @return
	 * 	Boolean
	 * 		falseδ��ҵ
	 * 		true�ѱ�ҵ
	 */
	public boolean isIsGraduate() {
		return IsGraduate;
	}
	

	/**
	 * ���ñ�ҵ��Ϣ
	 * @param isGraduate
	 * 		falseδ��ҵ
	 * 		true�Ѿ���ҵ
	 */
	public void setIsGraduate(boolean isGraduate) {
		IsGraduate = isGraduate;
	}

	/**
	 * ��ȡ��������
	 * @return
	 * 	int
	 * 		0-���
	 * 		1-�޸�
	 */
	public int getOpr() {
		return Opr;
	}

	
	/**
	 * ���ò�������
	 * @param opr
	 * 		int	
	 * 			0-���
	 * 			1-�޸�
	 */
	public void setOpr(int opr) {
		Opr = opr;
	}
	
	
}
