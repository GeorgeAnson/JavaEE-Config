package com.easyshare.service;

import java.util.List;

import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Project;

/**
 * 项目表数据处理
 * @author Administrator
 *
 */
public interface ProjectService {

	/**
	 * 更新
	 * @param oldProject
	 * 
	 */
	void updateProjectInfo(int projectID, Project newProject);
	
	
	/**
	 * 将所有项目信息整合
	 * @param projects
	 * 		List<Project>
	 * @param commonUserInfos
	 * 		List<CommonUserInfo>
	 * @return
	 * 		List<Project>
	 */
	List<Project> combineAllProjectsInfo(List<Project> projects, List<CommonUserInfo> commonUserInfos);
	
	/**
	 * 获取所有现役项目
	 * @param allProjects
	 * 		Project
	 * @param commonUserInfos
	 * 			CommonUserInfo
	 * @return
	 * 			List<Project>
	 */
	List<Project> getAllAliveProject(List<Project> allProjects, List<CommonUserInfo> commonUserInfos);
	
	
	/**
	 * 获取所有我的现役项目
	 * @param allAliveProjects
	 * 		所有现役项目
	 * @param commonUserInfos
	 * 		成员公共信息
	 * @return
	 * 		List<Project>
	 */
	List<Project> getAllMyAliveProjects(List<Project> allAliveProjects, int commonID);
}
