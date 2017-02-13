package com.easyshare.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.ProjectDao;
import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.ProjectDaoImpl;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.ManageProject;
import com.easyshare.entity.Project;
import com.easyshare.globle.Constant;
import com.easyshare.utils.Utils;

@Component
public class TimeLineAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3520567366945499698L;

	@Autowired
	ProjectDao projectDao=new ProjectDaoImpl();//��ĿDao���ݲ����
	
	@Autowired
	UserDao userDao = new UserDaoImpl();//��ȡ�û����ݲ����
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ��TinmeLineAction����");
		String initType=request.getParameter("type");
		
		Object user=request.getSession().getAttribute(Constant.USER_KEY);
		
		if("init".equals(initType))
		{
			System.out.println("��ת����ʷʱ�������");
			//��ȡ��ǰid����Ӧ�Ķ���Ŀ�Ĳ�����־��Ϣ����
			List<ManageProject> projectLogInfos=getProjecManageInfo(request,response);

			//������Ϣ��session
			request.getSession().setAttribute("ManageProjectInfo", projectLogInfos);
			//ת��ҳ��
			request.getRequestDispatcher("/WEB-INF/pages/historyTimeLine.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				System.out.println("׼�������Ŀ������־");
				addProjectLogInfo(request,response,user);
			}else
			{
				System.out.println("��Ǹ����û��Ȩ�޲���");
				request.getSession().setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			}
			//����ת�����ں�����
		}
		else if("delete".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				System.out.println("׼��ɾ����Ŀ������־");
				deleteProjectLogInfo(request,response,user);
			}else
			{
				System.out.println("��Ǹ����û��Ȩ�޲���");
				request.getSession().setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			}
			//����ת�����ں�����
			
		}else
		{
			response.sendRedirect(request.getContextPath());
			return;
		}
	}
	
	
	private void deleteProjectLogInfo(HttpServletRequest request, HttpServletResponse response, Object user)
			throws IOException {
		
		System.out.println("ɾ��һ��");
		System.out.println(request.getParameter("projectId"));
		System.out.println(request.getParameter("manageProjectId"));
		int manageProjectID=Integer.parseInt(request.getParameter("manageProjectId"));
		int projectID=Integer.parseInt(request.getParameter("projectId"));
		
		//���Ҹ�����־��Ϣ
		ManageProject manageProject=projectDao.getManageProjectByManageProjectID(manageProjectID);
		//״̬-1Ϊɾ��
		manageProject.setStatus(-1);
		//���ò���ʱ��
		manageProject.setModifyDate(new java.sql.Date(new java.util.Date().getTime()));
		
		//ɾ��һ����־��Ϣ
		projectDao.update(manageProject);
		
		response.sendRedirect(request.getContextPath()+"/historyTimeLine.html?type=init&id="+projectID);
	}


	/**
	 * ��ȡĳһ��Ŀ�Ĺ������Ϣ
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @return
	 * 			List<ManageProject>
	 */
	private List<ManageProject> getProjecManageInfo(HttpServletRequest request, HttpServletResponse response) {
		//��ȡ��ĿID
		int id=Integer.parseInt(request.getParameter("id"));
		//��ȡ��Ŀ��־
		List<ManageProject> projectLogInfos = projectDao.getManageProjectByProjectId(id);
		//��ȡ��Ŀ��Ϣ
		Project project=projectDao.getProjectById(id);
		
		int formerCommonID=0;
		CommonUserInfo commonUserInfo=null;
		for(ManageProject item:projectLogInfos)
		{
			item.setProject(project);
			if(formerCommonID==0)
			{
				//��һ��ִ�У���ȡ������¼�Ĳ�������Ϣ
				commonUserInfo=userDao.getUserInfoByCommonId(item.getCommonID());
			}else if(formerCommonID!=0 && formerCommonID!=item.getCommonID())
			{
				//����ǰ��¼��CommonID����һ����ͬ����ȡ������¼�Ĳ�������Ϣ
				commonUserInfo=userDao.getUserInfoByCommonId(item.getCommonID());
			}
			//������ͬ����ǰCommonID����һ����ͬ����formerCommonID������0����ֱ�ӻ�ȡ��һ����¼
			//�����¼����˵Ĺ�����Ϣ
			item.setCommonUserInfo(commonUserInfo);
			//���µ�ǰ������ϢID��־
			formerCommonID=item.getCommonID();
		}
		return projectLogInfos;
	}


	/**
	 * Ϊĳһ��Ŀ����һ����־��Ϣ
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 * @throws IOException 
	 */
	private void addProjectLogInfo(HttpServletRequest request, HttpServletResponse response, Object user) 
			throws IOException {
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("newlogtxt"));
		int projectID=Integer.parseInt(request.getParameter("id"));
		String logtxt=request.getParameter("newlogtxt");
		
		ManageProject manageProject=new ManageProject();
		manageProject.setCommonID(Utils.getUserCommonInfo(user).getCommonID());
		manageProject.setProjectID(projectID);
		manageProject.setLogtxt(logtxt);
		manageProject.setModifyDate(new java.sql.Date(new java.util.Date().getTime()));
		manageProject.setStatus(1);
		
		//������־
		projectDao.save(manageProject);
		
		response.sendRedirect(request.getContextPath()+"/historyTimeLine.html?type=init&id="+projectID);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
