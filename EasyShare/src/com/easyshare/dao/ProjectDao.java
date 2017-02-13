package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.ManageProject;
import com.easyshare.entity.Project;

public interface ProjectDao {

	/**
	 * ����һ����Ŀ��Ϣ
	 * @param project
	 * 			Project
	 */
	void save(Project project);

	
	/**
	 * ͨ����Ŀ����������Ŀ��Ϣ
	 * 		����Ŀ����Ϊ�գ���Ĭ��Ϊ������Ŀ��Ϣ
	 * @param projectName
	 * 			String	��Ŀ����
	 * @return
	 * 		List<Project>
	 */
	List<Project> getProjectByName(String projectName);
		
	/**
	 * ͨ����ĿID������Ŀ
	 * @param projectID
	 * 			int
	 * @return
	 * 		Project
	 */
	Project getProjectById(int projectID);
	
	
	/**
	 * ������Ŀ��Ϣ
	 * @param project
	 * 		Project
	 */
	void update(Project project);
	
	
	/**
	 * ͨ����ĿID������Ŀ������Ϣ
	 * @param projectID
	 * 			int
	 * @return
	 * 		ManageProject
	 */
	List<ManageProject> getManageProjectByProjectId(int projectID);
	
	
	/**
	 * ����һ����Ŀ��־��Ϣ
	 * @param manageProject
	 * 			ManageProject
	 */
	void save(ManageProject manageProject);
	
	
	/**
	 * ͨ��ManageProjectID����ĳһ����־��¼
	 * @param manageProjectID
	 * 				int
	 * @return
	 * 			ManageProject
	 */
	ManageProject getManageProjectByManageProjectID(int manageProjectID);
	
	
	/**
	 * ɾ�����߸�������Ŀ������Ϣ
	 * @param manageProject
	 * 			ManageProject
	 */
	void update(ManageProject manageProject);
}
