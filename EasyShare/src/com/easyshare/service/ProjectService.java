package com.easyshare.service;

import java.util.List;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Project;

/**
 * ��Ŀ�����ݴ���
 * @author Administrator
 *
 */
public interface ProjectService {

	/**
	 * ����
	 * @param oldProject
	 * 
	 */
	void updateProjectInfo(int projectID, Project newProject);
	
	
	/**
	 * ��������Ŀ��Ϣ����
	 * @param projects
	 * 		List<Project>
	 * @param commonUserInfos
	 * 		List<CommonUserInfo>
	 * @return
	 * 		List<Project>
	 */
	List<Project> combineAllProjectsInfo(List<Project> projects, List<CommonUserInfo> commonUserInfos);
	
	/**
	 * ��ȡ����������Ŀ
	 * @param allProjects
	 * 		Project
	 * @param commonUserInfos
	 * 			CommonUserInfo
	 * @return
	 * 			List<Project>
	 */
	List<Project> getAllAliveProject(List<Project> allProjects, List<CommonUserInfo> commonUserInfos);
	
	
	/**
	 * ��ȡ�����ҵ�������Ŀ
	 * @param allAliveProjects
	 * 		����������Ŀ
	 * @param commonUserInfos
	 * 		��Ա������Ϣ
	 * @return
	 * 		List<Project>
	 */
	List<Project> getAllMyAliveProjects(List<Project> allAliveProjects, int commonID);
}
