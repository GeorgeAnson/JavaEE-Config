package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.ManageProject;
import com.easyshare.entity.Project;

public interface ProjectDao {

	/**
	 * 保存一个项目信息
	 * @param project
	 * 			Project
	 */
	void save(Project project);

	
	/**
	 * 通过项目名称搜索项目信息
	 * 		若项目名称为空，则默认为所有项目信息
	 * @param projectName
	 * 			String	项目名称
	 * @return
	 * 		List<Project>
	 */
	List<Project> getProjectByName(String projectName);
		
	/**
	 * 通过项目ID搜索项目
	 * @param projectID
	 * 			int
	 * @return
	 * 		Project
	 */
	Project getProjectById(int projectID);
	
	
	/**
	 * 更新项目信息
	 * @param project
	 * 		Project
	 */
	void update(Project project);
	
	
	/**
	 * 通过项目ID查找项目管理信息
	 * @param projectID
	 * 			int
	 * @return
	 * 		ManageProject
	 */
	List<ManageProject> getManageProjectByProjectId(int projectID);
	
	
	/**
	 * 保存一条项目日志信息
	 * @param manageProject
	 * 			ManageProject
	 */
	void save(ManageProject manageProject);
	
	
	/**
	 * 通过ManageProjectID查找某一条日志记录
	 * @param manageProjectID
	 * 				int
	 * @return
	 * 			ManageProject
	 */
	ManageProject getManageProjectByManageProjectID(int manageProjectID);
	
	
	/**
	 * 删除或者更新设项目管理信息
	 * @param manageProject
	 * 			ManageProject
	 */
	void update(ManageProject manageProject);
}
