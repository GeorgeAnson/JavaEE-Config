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
			System.out.println("��Ŀ������");
			return;
		}
		
		//������Ŀ����
		if(!oldProject.getProjectName().equals(newProject.getProjectName()))
		{
			oldProject.setProjectName(newProject.getProjectName());
		}
		
		//������Ŀί�з�
		if(!oldProject.getClient().equals(newProject.getClient()))
		{
			oldProject.setClient(newProject.getClient());
		}
		
		//������Ŀ����
		if(oldProject.getProjectType()!=newProject.getProjectType())
		{
			oldProject.setProjectType(newProject.getProjectType());
		}
		
		//������Ŀ��ʼʱ��,ʱ��ɿգ������ж�
//		if(!oldProject.getStartDate().equals(newProject.getStartDate()))
		{
			oldProject.setStartDate(newProject.getStartDate());
		}
		
		//������Ŀ��ֹʱ�䣬ʱ��ɿ�
//		if(!oldProject.getEndDate().equals(newProject.getEndDate()))
		{
			oldProject.setEndDate(newProject.getEndDate());
		}
		
		//������Ŀ������
		if(oldProject.getCommonID()!=newProject.getCommonID())
		{
			oldProject.setCommonID(newProject.getCommonID());
		}
		
		//���º�ͬǩ��״��
		if(oldProject.getIsContract()!=newProject.getIsContract())
		{
			oldProject.setIsContract(newProject.getIsContract());
		}
		
		//������Ŀ���ӣ��ɿ�
//		if(!oldProject.getProBook().equals(newProject.getProBook()))
		{
			oldProject.setProBook(newProject.getProBook());
		}
		
		//������Ŀ״̬
		if(oldProject.getStatus()!=newProject.getStatus())
		{
			oldProject.setStatus(newProject.getStatus());
		}
		
		//��������
		projectDao.update(newProject);
	}


	@Override
	public List<Project> getAllAliveProject(List<Project> allProjects, List<CommonUserInfo> commonUserInfos) {
		
		List<Project> aliveProjects=new ArrayList<Project>();
		
		//����������Ŀ
		for(Project project:allProjects)
		{
			//�����Ŀ״̬Ϊ�����ڽ�����
			if(project.getStatus()==1)
			{
				//�������й�����Ϣ
				for(CommonUserInfo commonUserInfo:commonUserInfos)
				{
					//����Ŀ�����˵Ĺ�����Ϣ������Ŀ��
					if(project.getCommonID()==commonUserInfo.getCommonID())
					{
						project.setCommonUserInfo(commonUserInfo);
						//��ȡ��Ŀ��Ϣ
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
		
		//��������������Ŀ����ȡ�ҵ�������Ŀ
		for(Project project:allAliveProjects)
		{
			if(project.getCommonID()==commonID)
			{
				//�����ҵ�������Ŀ
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
