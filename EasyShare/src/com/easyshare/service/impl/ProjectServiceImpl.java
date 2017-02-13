package com.easyshare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyshare.dao.ProjectDao;
import com.easyshare.dao.jdbc.ProjectDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Project;
import com.easyshare.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao=new ProjectDaoImpl();
	
	@Override
	public void updateProjectInfo(int projectID, Project newProject) {
		Project oldProject=projectDao.getProjectById(projectID);
		
		if(oldProject==null)
		{
			System.out.println("项目不存在");
			return;
		}
		
		//更新项目名称
		if(!oldProject.getProjectName().equals(newProject.getProjectName()))
		{
			oldProject.setProjectName(newProject.getProjectName());
		}
		
		//更新项目委托方
		if(!oldProject.getClient().equals(newProject.getClient()))
		{
			oldProject.setClient(newProject.getClient());
		}
		
		//更新项目类型
		if(oldProject.getProjectType()!=newProject.getProjectType())
		{
			oldProject.setProjectType(newProject.getProjectType());
		}
		
		//更新项目开始时间,时间可空，无需判断
//		if(!oldProject.getStartDate().equals(newProject.getStartDate()))
		{
			oldProject.setStartDate(newProject.getStartDate());
		}
		
		//更新项目截止时间，时间可空
//		if(!oldProject.getEndDate().equals(newProject.getEndDate()))
		{
			oldProject.setEndDate(newProject.getEndDate());
		}
		
		//更新项目负责人
		if(oldProject.getCommonID()!=newProject.getCommonID())
		{
			oldProject.setCommonID(newProject.getCommonID());
		}
		
		//更新合同签订状况
		if(oldProject.getIsContract()!=newProject.getIsContract())
		{
			oldProject.setIsContract(newProject.getIsContract());
		}
		
		//更新项目链接，可空
//		if(!oldProject.getProBook().equals(newProject.getProBook()))
		{
			oldProject.setProBook(newProject.getProBook());
		}
		
		//更新项目状态
		if(oldProject.getStatus()!=newProject.getStatus())
		{
			oldProject.setStatus(newProject.getStatus());
		}
		
		//更新数据
		projectDao.update(newProject);
	}


	@Override
	public List<Project> getAllAliveProject(List<Project> allProjects, List<CommonUserInfo> commonUserInfos) {
		
		List<Project> aliveProjects=new ArrayList<Project>();
		
		//遍历所有项目
		for(Project project:allProjects)
		{
			//如果项目状态为正在在进行中
			if(project.getStatus()==1)
			{
				//遍历所有公共信息
				for(CommonUserInfo commonUserInfo:commonUserInfos)
				{
					//将项目负责人的公共信息存入项目中
					if(project.getCommonID()==commonUserInfo.getCommonID())
					{
						project.setCommonUserInfo(commonUserInfo);
						//获取项目信息
						aliveProjects.add(project);
					}
				}
			}
		}
		
		return aliveProjects;
	}

	@Override
	public List<Project> getAllMyAliveProjects(List<Project> allAliveProjects, int commonID) {
		List<Project> projects=new ArrayList<Project>();
		
		//遍历所有现役项目，获取我的现役项目
		for(Project project:allAliveProjects)
		{
			if(project.getCommonID()==commonID)
			{
				//保存我的现役项目
				projects.add(project);
			}
		}
		
		return projects;
	}


	@Override
	public List<Project> combineAllProjectsInfo(List<Project> projects, List<CommonUserInfo> commonUserInfos) {
		List<Project> combineProjects=new ArrayList<Project>();
		
		for(Project project:projects)
		{
			for(CommonUserInfo commonUserInfo:commonUserInfos)
			{
				if(commonUserInfo.getCommonID()==project.getCommonID())
				{
					project.setCommonUserInfo(commonUserInfo);
					combineProjects.add(project);
				}
			}
		}
		
		return combineProjects;
	}

}
