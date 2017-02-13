package com.easyshare.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.easyshare.dao.UserDao;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.entity.UserConnection;
import com.easyshare.utils.Packager;
import com.easyshare.utils.Utils;

@Component
@Repository("userDao")
public class UserDaoImpl extends JDBCBase implements UserDao {

	@Override
public Object getUserByCondition(String condition,int userType) {
		
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Object object=null;
		CommonUserInfo commonUserInfo=null;
		UserConnection userConnection=null;
		
		if(userType==1)
		{
			String sql="SELECT * FROM CommonUserInfo com,UserConnection uc,Teachers t "
					+ "WHERE com.CommonID=uc.CommonID AND uc.TeacherID=t.TeacherID AND com.Email=? OR com.Phone=?";
			Object[] param={condition,condition};
			try
			{
				ps=conn.prepareStatement(sql);
				rs=query(ps,param);
				if(rs.next())
				{
					commonUserInfo=Packager.packCommonUserInfo(rs);
					userConnection=Packager.packUserConnection(rs);
					object=Packager.packTeacher(rs, commonUserInfo, userConnection);
				}
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				JDBCUtil.close(rs, ps, conn);
			}
		}else if(userType==2)
		{
			
			String sql="SELECT * FROM CommonUserInfo com,UserConnection uc, Students s "
					+ "WHERE com.CommonID=uc.CommonID AND uc.StudentID=s.StudentID AND com.Email=? OR com.Phone=?";
			Object[] param={condition,condition};
			try
			{
				ps=conn.prepareStatement(sql);
				rs=query(ps,param);
				if(rs.next())
				{
					commonUserInfo=Packager.packCommonUserInfo(rs);
					userConnection=Packager.packUserConnection(rs);
					object=Packager.packStudent(rs,commonUserInfo,userConnection);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				JDBCUtil.close(rs, ps, conn);
			}
			
		}
		return object;
	}

	@Override
	public void save(Object object) {
		
		CommonUserInfo commonUserInfo=Utils.getUserCommonInfo(object);
		//保存CommonUserInfo的信息
		String sql="INSERT INTO CommonUserInfo(LoginName,Password,HeadPic,Gender,Email,Phone,CreateDate,UserType,AdminType,Status) VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] comparam={
				commonUserInfo.getLoginName(),
				commonUserInfo.getPassword(),
				commonUserInfo.getHeadPic(),
				commonUserInfo.isGender(),
				commonUserInfo.getEmail(),
				commonUserInfo.getPhone(),
				commonUserInfo.getCreateDate(),
				commonUserInfo.getUserType(),
				commonUserInfo.getAdminType(),
				commonUserInfo.getStatus()};
		saveOrUpdateOrDelete(sql, comparam);
		System.out.println("OK CommonUserInfo");
		if(object instanceof Student)
		{
			//保存Student的信息
			sql="INSERT INTO Students VALUES(?,?,?,?)";
			Object[] sparam={
					((Student) object).getStudentNum(),
					((Student) object).getGrade(),
					((Student) object).getMajor(),
					((Student) object).getApartment()};
			saveOrUpdateOrDelete(sql, sparam);
			System.out.println("OK Student");
		}else if(object instanceof Teacher)
		{
			//保存Teacher表信息
			sql="INSERT INTO Teachers VALUES(?)";
			Object[] tparam={((Teacher) object).getProffessionalTitle()};
			saveOrUpdateOrDelete(sql, tparam);
		}
	}

	@Override
	public void update(Object object) {
		if(object instanceof Student)
		{
			Student student=(Student)object;
			//更新CommonUserInfo中信息
			CommonUserInfo commonUserInfo=student.getCommonUserInfo();
			StringBuilder sql=new StringBuilder("UPDATE CommonUserInfo SET LoginName=?, Email=?, Phone=?, UserType=?, AdminType=?, CreateDate=?, Status=?, Gender=?, LoginTimes=?, RecentlyLogin=?, IsLeader=?, IsGraduate=?");//
			ArrayList<Object> compList=new ArrayList<Object>();
			compList.add(commonUserInfo.getLoginName());
			compList.add(commonUserInfo.getEmail());
			compList.add(commonUserInfo.getPhone());
			compList.add(commonUserInfo.getUserType());
			compList.add(commonUserInfo.getAdminType());
			compList.add(commonUserInfo.getCreateDate());
			compList.add(commonUserInfo.getStatus());
			compList.add(commonUserInfo.isGender());
			compList.add(commonUserInfo.getLoginTimes());
			compList.add(commonUserInfo.getRecentlyLogin());
			compList.add(commonUserInfo.getIsLeader());
			compList.add(commonUserInfo.isIsGraduate());
			System.out.println(commonUserInfo.getStatus()+"Stuednt STatus");
			if(commonUserInfo.getRealName()!=null)
			{
				sql.append(", RealName=?");
				compList.add(commonUserInfo.getRealName());
			}
			
			if(commonUserInfo.getPassword()!=null)
			{
				sql.append(", Password=?");
				compList.add(commonUserInfo.getPassword());
			}
			
			if(commonUserInfo.getHeadPic()!=null)
			{
				sql.append(", HeadPic=?");
				compList.add(commonUserInfo.getHeadPic());
			}
			
			if(commonUserInfo.getQQ()!=null)
			{
				sql.append(", QQ=?");
				compList.add(commonUserInfo.getQQ());
			}
			
			if(commonUserInfo.getWeChat()!=null)
			{
				sql.append(", WeChat=?");
				compList.add(commonUserInfo.getWeChat());
			}
			
			if(commonUserInfo.getAddress()!=null)
			{
				sql.append(", Address=?");
				compList.add(commonUserInfo.getAddress());
			}
			
			if(commonUserInfo.getBalance()!=-1)
			{
				sql.append(", Balance=?");
				compList.add(commonUserInfo.getBalance());
			}
			
			if(commonUserInfo.getTransferDate()!=null)
			{
				sql.append(", TransferDate=?");
				compList.add(commonUserInfo.getTransferDate());
			}
			
			if(commonUserInfo.getIP()!=null)
			{
				sql.append(", IP=?");
				compList.add(commonUserInfo.getIP());
			}
			
			
			sql.append(" WHERE CommonID=?");
			compList.add(commonUserInfo.getCommonID());
			System.out.println(sql.toString());
			
			Object[] comparam=compList.toArray();
			saveOrUpdateOrDelete(sql.toString(), comparam);
			
			
			sql.delete(0, sql.length());
			compList.clear();
			
			
			//更新Student中的信息
			sql.append("UPDATE Students SET Grade=?, StudentNum=?");
			compList.add(student.getGrade());
			compList.add(student.getStudentNum());
			
			if(student.getMajor()!=null)
			{
				sql.append(", Major=?");
				compList.add(student.getMajor());
			}
			
			
			sql.append(" WHERE StudentID=?");
			compList.add(student.getStudentID());
			Object[] sparam=compList.toArray();
			saveOrUpdateOrDelete(sql.toString(), sparam);
		}else if(object instanceof Teacher)
		{
			Teacher teacher=(Teacher) object;
			//更新CommonUserInfo中信息
			CommonUserInfo commonUserInfo=teacher.getCommonUserInfo();
			StringBuilder sql=new StringBuilder("UPDATE CommonUserInfo SET LoginName=?, Email=?, Phone=?, UserType=?, AdminType=?, CreateDate=?, Status=?, Gender=?, LoginTimes=?, RecentlyLogin=?, IsLeader=?");//
			ArrayList<Object> compList=new ArrayList<Object>();
			compList.add(commonUserInfo.getLoginName());
			compList.add(commonUserInfo.getEmail());
			compList.add(commonUserInfo.getPhone());
			compList.add(commonUserInfo.getUserType());
			compList.add(commonUserInfo.getAdminType());
			compList.add(commonUserInfo.getCreateDate());
			compList.add(commonUserInfo.getStatus());
			compList.add(commonUserInfo.isGender());
			compList.add(commonUserInfo.getLoginTimes());
			compList.add(commonUserInfo.getRecentlyLogin());
			compList.add(commonUserInfo.getIsLeader());
			System.out.println(commonUserInfo.getStatus()+"teacher STatus");
			if(commonUserInfo.getRealName()!=null)
			{
				sql.append(", RealName=?");
				compList.add(commonUserInfo.getRealName());
			}
			
			if(commonUserInfo.getPassword()!=null)
			{
				sql.append(", Password=?");
				compList.add(commonUserInfo.getPassword());
			}
			
			if(commonUserInfo.getHeadPic()!=null)
			{
				sql.append(", HeadPic=?");
				compList.add(commonUserInfo.getHeadPic());
			}
			
			if(commonUserInfo.getQQ()!=null)
			{
				sql.append(", QQ=?");
				compList.add(commonUserInfo.getQQ());
			}
			
			if(commonUserInfo.getWeChat()!=null)
			{
				sql.append(", WeChat=?");
				compList.add(commonUserInfo.getWeChat());
			}
			
			if(commonUserInfo.getAddress()!=null)
			{
				sql.append(", Address=?");
				compList.add(commonUserInfo.getAddress());
			}
			
			if(commonUserInfo.getBalance()!=-1)
			{
				sql.append(", Balance=?");
				compList.add(commonUserInfo.getBalance());
			}
			
			if(commonUserInfo.getTransferDate()!=null)
			{
				sql.append(", TransferDate=?");
				compList.add(commonUserInfo.getTransferDate());
			}
			
			if(commonUserInfo.getIP()!=null)
			{
				sql.append(", IP=?");
				compList.add(commonUserInfo.getIP());
			}
			
			sql.append(" WHERE CommonID=?");
			compList.add(commonUserInfo.getCommonID());
			System.out.println(sql.toString());
			
			Object[] comparam=compList.toArray();
			saveOrUpdateOrDelete(sql.toString(), comparam);
			
			
			sql.delete(0, sql.length());
			compList.clear();
			//更新Teacher表信息
			sql.append("UPDATE Teachers SET ProfessionalTitle=?");
			compList.add(teacher.getProffessionalTitle());
			
			sql.append(" WHERE TeacherID=?");
			compList.add(teacher.getTeacherID());
			System.out.println(sql.toString());
			
			Object[] tparam=compList.toArray();
			saveOrUpdateOrDelete(sql.toString(), tparam);
		}

	}

	@Override
	public Object getUserById(int userID,int userType) {
		Object object=null;
		CommonUserInfo commonUserInfo=null;
		UserConnection userConnection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JDBCUtil.getConnection();

		if(userType==1)
		{
			String sql="SELECT * FROM CommonUserInfo com,UserConnection uc,Teachers t "
					+ "WHERE com.CommonID=uc.CommonID AND uc.TeacherID=t.TeacherID AND t.TeacherID="+userID;
			try 
			{
				ps=conn.prepareStatement(sql);
				rs=query(ps);
				if(rs.next())
				{
					commonUserInfo=Packager.packCommonUserInfo(rs);
					userConnection=Packager.packUserConnection(rs);
					object=Packager.packTeacher(rs, commonUserInfo, userConnection);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				JDBCUtil.close(rs, ps, conn);
			}
		}else if(userType==2)
		{
			String sql="SELECT * FROM CommonUserInfo com,UserConnection uc, Students s "
					+ "WHERE com.CommonID=uc.CommonID AND uc.StudentID=s.StudentID AND s.StudentID="+userID;
			try
			{
				ps=conn.prepareStatement(sql);
				rs=query(ps);
				if(rs.next())
				{
					commonUserInfo=Packager.packCommonUserInfo(rs);
					userConnection=Packager.packUserConnection(rs);
					object=Packager.packStudent(rs, commonUserInfo, userConnection);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				JDBCUtil.close(rs, ps, conn);
			}
		}
		
		return object;
	}

	@Override
	public CommonUserInfo getUserInfoByCommonId(int commonID) {
		CommonUserInfo commonUserInfo=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JDBCUtil.getConnection();
		String sql="SELECT * FROM CommonUserInfo WHERE CommonID="+commonID;
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				commonUserInfo=Packager.packCommonUserInfo(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return commonUserInfo;
	}

	
	@Override
	public List<CommonUserInfo> getAllCommonUserInfo() {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CommonUserInfo> commonUserInfos=new ArrayList<CommonUserInfo>();
		String sql="SELECT * FROM CommonUserInfo";
		
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			
			while(rs.next())
			{
				commonUserInfos.add(Packager.packCommonUserInfo(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return commonUserInfos;
	}

	@Override
	public List<Student> getStudentByCondition(String condition) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Student> students=new ArrayList<Student>();
		CommonUserInfo commonUserInfo=null;
		UserConnection userConnection=null;
		
		String sql="SELECT * FROM Students stud, CommonUserInfo com, UserConnection uc WHERE com.CommonID=uc.CommonID AND uc.StudentID=stud.StudentID";
		
		if(!"".equals(condition)&&condition!=null)
		{
			sql+=" AND (stud.StudentNum LIKE '%"+condition+"%' OR stud.Grade LIKE '%"+condition+"%' OR stud.Major LIKE '%"+condition+"%' OR stud.Apartment LIKE '%"+condition+"%')";
		}
		
		System.out.println(sql);
	
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				commonUserInfo=Packager.packCommonUserInfo(rs);
				userConnection=Packager.packUserConnection(rs);
				students.add(Packager.packStudent(rs, commonUserInfo, userConnection));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return students;
	}

	@Override
	public List<Teacher> getTeacherByContidion(String condition) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Teacher> teachers=new ArrayList<Teacher>();
		CommonUserInfo commonUserInfo=null;
		UserConnection userConnection=null;
		
		String sql="SELECT * FROM Teachers teac, CommonUserInfo com, UserConnection uc WHERE com.CommonID=uc.CommonID AND uc.TeacherID=teac.TeacherID";
		
		if(!"".equals(condition)&&condition!=null)
		{
			sql+=" AND (teac.ProfessionalTitle='%"+condition+"%' OR com.Phone='%"+condition+"%' OR com.Email='%"+condition+"%')";
		}
		
		System.out.println(sql);
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				commonUserInfo=Packager.packCommonUserInfo(rs);
				userConnection=Packager.packUserConnection(rs);
				teachers.add(Packager.packTeacher(rs, commonUserInfo, userConnection));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return teachers;
	}

}
