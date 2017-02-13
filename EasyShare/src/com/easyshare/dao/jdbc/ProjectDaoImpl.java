package com.easyshare.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.easyshare.dao.ProjectDao;
import com.easyshare.entity.ManageProject;
import com.easyshare.entity.Project;
import com.easyshare.utils.Packager;

@Component
@Repository("projectDao")
public class ProjectDaoImpl extends JDBCBase implements ProjectDao {

	@Override
	public void save(Project project) {
		String sql="INSERT INTO Projects VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] param={
			project.getProjectName(),
			project.getClient(),
			project.getProjectType(),
			project.getStartDate(),
			project.getEndDate(),
			project.getCommonID(),
			project.getIsContract(),
			project.getProBook(),
			project.getStatus(),
			project.getOpr()};
		
		saveOrUpdateOrDelete(sql, param);
		
		System.out.println("����һ����Ŀ��¼");
	}

	@Override
	public List<Project> getProjectByName(String projectName) {
		
		List<Project> projects=new ArrayList<Project>();
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT * FROM Projects";
		
		//����ѯ��Ŀ������Ϊ�գ���Ĭ�ϲ�ѯ������Ŀ
		if(!"".equals(projectName)&&projectName!=null)
		{
			sql+=" WHERE ProjectName="+projectName;
		}
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				projects.add(Packager.packProject(rs));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return projects;
	}

	@Override
	public Project getProjectById(int projectID) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Project project=null;
		String sql="SELECT * FROM Projects WHERE ProjectID="+projectID;
		
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				project=Packager.packProject(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return project;
	}

	@Override
	public void update(Project project) {
		StringBuilder sql=new StringBuilder("UPDATE Projects SET ProjectName=?, ProjectType=?, CommonID=?, IsContract=?, Status=?, Opr=?");
		List<Object> proParam= new ArrayList<Object>();
		proParam.add(project.getProjectName());
		proParam.add(project.getProjectType());
		proParam.add(project.getCommonID());
		proParam.add(project.getIsContract());
		proParam.add(project.getStatus());
		proParam.add(project.getOpr());
		
		//�ж�ί����
		if(project.getClient()!=null)
		{
			sql.append(", Client=?");
			proParam.add(project.getClient());
		}
		
		//�жϿ�ʼʱ��
		if(project.getStartDate()!=null)
		{
			sql.append(", StartDate=?");
			proParam.add(project.getStartDate());
		}
		
		//�жϽ���ʱ��
		if(project.getEndDate()!=null)
		{
			sql.append(", EndDate=?");
			proParam.add(project.getEndDate());
		}
		
		//�ж���Ŀ������
		if(project.getProBook()!=null)
		{
			sql.append(", proBook=?");
			proParam.add(project.getProBook());
		}
		
		sql.append(" WHERE ProjectID=?");
		proParam.add(project.getProjectID());
		
		Object[] param=proParam.toArray();
		
		saveOrUpdateOrDelete(sql.toString(), param);
		
		System.out.println("��Ŀ��Ϣ����");
	}

	@Override
	public List<ManageProject> getManageProjectByProjectId(int projectID) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ManageProject> manageProjects=new ArrayList<ManageProject>();
		
		String sql="SELECT * FROM ManageProjects WHERE ProjectID="+projectID;
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				manageProjects.add(Packager.packManageProject(rs));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return manageProjects;
	}

	@Override
	public void save(ManageProject manageProject) {
		String sql="INSERT INTO ManageProjects VALUES(?,?,?,?,?)";
		Object[] param={
			manageProject.getCommonID(),
			manageProject.getProjectID(),
			manageProject.getLogtxt(),
			manageProject.getModifyDate(),
			manageProject.getStatus()
		};
		
		saveOrUpdateOrDelete(sql, param);
		
		System.out.println("��ɱ���һ����־��¼");
	}

	@Override
	public ManageProject getManageProjectByManageProjectID(int manageProjectID) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ManageProject manageProject=null;
		
		String sql="SELECT * FROM ManageProjects WHERE ManageProjectID="+manageProjectID;
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				manageProject=Packager.packManageProject(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return manageProject;
	}

	@Override
	public void update(ManageProject manageProject) {
		StringBuilder sql=new StringBuilder("UPDATE ManageProjects SET CommonID=?, ProjectID=?,ModifyDate=?, Status=?");
		
		ArrayList<Object> manageParam=new ArrayList<Object>();
		manageParam.add(manageProject.getCommonID());
		manageParam.add(manageProject.getProjectID());
		manageParam.add(manageProject.getModifyDate());
		manageParam.add(manageProject.getStatus());
		
		//�����־�ı�����
		if(manageProject.getLogtxt()!=null)
		{
			sql.append(", Logtxt=?");
			manageParam.add(manageProject.getLogtxt());
		}
		
		sql.append(" WHERE ManageProjectID=?");
		manageParam.add(manageProject.getManageProjectID());
		
		Object[] param=manageParam.toArray();
		
		//ɾ��һ����־��Ϣ
		saveOrUpdateOrDelete(sql.toString(), param);
		
		System.out.println("ɾ��һ����־");
	}

}
