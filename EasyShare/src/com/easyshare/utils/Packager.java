package com.easyshare.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.easyshare.entity.Book;
import com.easyshare.entity.Fund;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Equipment;
import com.easyshare.entity.ManageBook;
import com.easyshare.entity.ManageProject;
import com.easyshare.entity.Project;
import com.easyshare.entity.Stranger;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.entity.UserConnection;

public class Packager {

	
	/**
	 * 打包CommonUserInfo中的信息
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static CommonUserInfo packCommonUserInfo(ResultSet rs) throws SQLException
	{
		CommonUserInfo commonUserInfo=new CommonUserInfo();
		commonUserInfo.setCommonID(rs.getInt("CommonID"));
		commonUserInfo.setRealName(rs.getString("RealName"));
		commonUserInfo.setLoginName(rs.getString("LoginName"));
		commonUserInfo.setPassword(rs.getString("Password"));
		commonUserInfo.setHeadPic(rs.getString("HeadPic"));
		commonUserInfo.setGender(rs.getBoolean("Gender"));
		commonUserInfo.setEmail(rs.getString("Email"));
		commonUserInfo.setQQ(rs.getString("QQ"));
		commonUserInfo.setWeChat(rs.getString("WeChat"));
		commonUserInfo.setPhone(rs.getString("Phone"));
		commonUserInfo.setAddress(rs.getString("Address"));
		commonUserInfo.setBalance(rs.getDouble("Balance"));
		commonUserInfo.setTransferDate(rs.getDate("TransferDate"));
		commonUserInfo.setCreateDate(rs.getDate("CreateDate"));
		commonUserInfo.setRecentlyLogin(rs.getDate("RecentlyLogin"));
		commonUserInfo.setLoginTimes(rs.getInt("LoginTimes"));
		commonUserInfo.setUserType(rs.getInt("UserType"));
		commonUserInfo.setAdminType(rs.getInt("AdminType"));
		commonUserInfo.setStatus(rs.getInt("Status"));
		commonUserInfo.setIP(rs.getString("IP"));
		commonUserInfo.setIsLeader(rs.getInt("IsLeader"));
		commonUserInfo.setIsGraduate(rs.getBoolean("IsGraduate"));
		commonUserInfo.setOpr(rs.getInt("Opr"));
		return commonUserInfo;
	}
	
	/**
	 * 打包UserConnection中信息
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static UserConnection packUserConnection(ResultSet rs) throws SQLException
	{
		UserConnection userConnection=new UserConnection();
		userConnection.setUserConnectionID(rs.getInt("UserConnectionID"));
		userConnection.setCommonID(rs.getInt("CommonID"));
		userConnection.setStudentID(rs.getInt("StudentID"));
		userConnection.setTeacherID(rs.getInt("TeacherID"));
		return userConnection;
	}
	
	/**
	 * 将Stranger数据打包
	 * @param rs
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static Stranger packStranger(ResultSet rs) throws SQLException
	{
		Stranger stranger=new Stranger();
		stranger.setStrangerID(rs.getInt("StrangerID"));
		stranger.setStrangerName(rs.getString("StrangerName"));
		stranger.setStrangerEmail(rs.getString("StrangerEmail"));
		stranger.setContent(rs.getString("Content"));
		return stranger;
	}
	
	
	
	/**
	 * 打包Student数据
	 * @param rs
	 * @param commonUserInfo
	 * @return
	 * @throws SQLException
	 */
	public static Student packStudent(ResultSet rs,CommonUserInfo commonUserInfo,UserConnection userConnection) throws SQLException
	{
		Student student=new Student();
		student.setCommonUserInfo(commonUserInfo);
		student.setUserConnection(userConnection);
		student.setStudentID(rs.getInt("StudentID"));
		student.setStudentNum(rs.getString("StudentNum"));
		student.setGrade(rs.getString("Grade"));
		student.setMajor(rs.getString("Major"));
		student.setApartment(rs.getString("Apartment"));
		return student;
	}
	
	
	/**
	 * 将Teacher数据打包
	 * @param rs
	 * @param commonUserInfo
	 * @return
	 * @throws SQLException
	 */
	public static Teacher packTeacher(ResultSet rs,CommonUserInfo commonUserInfo,UserConnection userConnection) throws SQLException
	{
		Teacher teacher=new Teacher();
		teacher.setTeacherID(rs.getInt("TeacherID"));
		teacher.setProffessionalTitle(rs.getString("ProfessionalTitle"));
		teacher.setCommonUserInfo(commonUserInfo);
		teacher.setUserConnection(userConnection);
		return teacher;
	}
	
	
	/**
	 * 将Book数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Book packBook(ResultSet rs) throws SQLException
	{
		Book book=new Book();
		book.setBookID(rs.getInt("BookID"));
		book.setBookName(rs.getString("BookName"));
		book.setAuthor(rs.getString("Author"));
		book.setPublishCompany(rs.getString("PublishCompany"));
		book.setAmount(rs.getInt("Amount"));
		book.setRemain(rs.getInt("Remain"));
		book.setPrice(rs.getDouble("Price"));
		book.setModifyDate(rs.getDate("ModifyDate"));
		book.setStatus(rs.getInt("Status"));
		book.setOpr(rs.getInt("Opr"));
		return book;
	}
	
	
	/**
	 * 将ManageBooks数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static ManageBook packManageBooks(ResultSet rs) throws SQLException
	{
		ManageBook manageBook=new ManageBook();
		manageBook.setManageBookID(rs.getInt("ManageBookID"));
		manageBook.setCommonID(rs.getInt("CommonID"));
		manageBook.setBookID(rs.getInt("BookID"));
		manageBook.setBorrowDate(rs.getDate("BorrowDate"));
		manageBook.setReturnDate(rs.getDate("ReturnDate"));
		return manageBook;
	}
	
	
	/**
	 * 将Equipment数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Equipment packEquipment(ResultSet rs) throws SQLException
	{
		Equipment equipment=new Equipment();
		equipment.setEquipmentID(rs.getInt("EquipmentID"));
		equipment.setEquipmentName(rs.getString("EquipmentName"));
		equipment.setPrice(rs.getDouble("Price"));
		equipment.setAmount(rs.getInt("Amount"));
		equipment.setRemain(rs.getInt("Remain"));
		equipment.setStatus(rs.getInt("Status"));
		equipment.setSketch(rs.getString("Sketch"));
		equipment.setOpr(rs.getInt("Opr"));
		return equipment;
	}
	
	
	
	/**
	 * 将Project数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Project packProject(ResultSet rs) throws SQLException
	{
		Project project=new Project();
		project.setProjectID(rs.getInt("ProjectID"));
		project.setProjectName(rs.getString("ProjectName"));
		project.setClient(rs.getString("Client"));
		project.setProjectType(rs.getInt("ProjectType"));
		project.setStartDate(rs.getDate("StartDate"));
		project.setEndDate(rs.getDate("EndDate"));
		project.setCommonID(rs.getInt("CommonID"));
		project.setIsContract(rs.getInt("IsContract"));
		project.setProBook(rs.getString("proBook"));
		project.setStatus(rs.getInt("Status"));
		project.setOpr(rs.getInt("Opr"));
		return project;
	}
	
	
	/**
	 * 将manageProject数据打包
	 * @param rs
	 * 		ResultSet
	 * @return
	 * 		ManageProject
	 * @throws SQLException 
	 */
	public static ManageProject packManageProject(ResultSet rs) throws SQLException
	{
		ManageProject manageProject=new ManageProject();
		manageProject.setManageProjectID(rs.getInt("ManageProjectID"));
		manageProject.setCommonID(rs.getInt("CommonID"));
		manageProject.setProjectID(rs.getInt("ProjectID"));
		manageProject.setLogtxt(rs.getString("Logtxt"));
		manageProject.setModifyDate(rs.getDate("ModifyDate"));
		manageProject.setStatus(rs.getInt("Status"));
		return manageProject;
	}
	
	
	/**
	 * 将DebrisProperty数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
//	public static DebrisProperty packDebrisProperty(ResultSet rs) throws SQLException
//	{
//		DebrisProperty debrisProperty=new DebrisProperty();
//		debrisProperty.setDebrisID(rs.getInt("DebrisID"));
//		debrisProperty.setDebrisName(rs.getString("DebrisName"));
//		debrisProperty.setAmount(rs.getInt("Amount"));
//		return debrisProperty;
//	}
	
	
	/**
	 * 将CashFlow数据打包
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static Fund packFund(ResultSet rs) throws SQLException
	{
		Fund fund=new Fund();
		fund.setFundID(rs.getInt("FundID"));
		fund.setFundName(rs.getString("FundName"));
		fund.setFundType(rs.getInt("FundType"));
		fund.setTransationSum(rs.getDouble("TransationSum"));
		fund.setTransationDetail(rs.getString("TransationDetail"));
		fund.setTransationDate(rs.getDate("TransationDate"));
		fund.setCommonID(rs.getInt("CommonID"));
		fund.setStatus(rs.getInt("Status"));
		fund.setOpr(rs.getInt("Opr"));
		return fund;
	}
}
