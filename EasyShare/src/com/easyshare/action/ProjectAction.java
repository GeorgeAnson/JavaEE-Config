package com.easyshare.action;

import java.io.IOException;
import java.sql.Date;
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
import com.easyshare.entity.Project;
import com.easyshare.globle.Constant;
import com.easyshare.service.ProjectService;
import com.easyshare.service.impl.ProjectServiceImpl;
import com.easyshare.utils.Utils;

@Component
public class ProjectAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3920731456487024617L;

	@Autowired
	ProjectService projectService=new ProjectServiceImpl();
	
	@Autowired
	ProjectDao projectDao=new ProjectDaoImpl();//��ĿDao���ݲ����
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	private List<Project> projects=null;
	//�����û�������Ϣ
	private List<CommonUserInfo> commonUserInfos=null;
	
	//����������Ŀ
	private List<Project> allAliveProjects=null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ��ProjectAction����");
		String initType=request.getParameter("type");
		
		Object user=request.getSession().getAttribute(Constant.USER_KEY);
		
		if("myProj".equals(initType))
		{
			//��ȡ������Ŀ
			projects=projectDao.getProjectByName("");
			//��ȡ�����û�������Ϣ
			commonUserInfos=userDao.getAllCommonUserInfo();
			//��ȡ����������Ŀ
			allAliveProjects=projectService.getAllAliveProject(projects, commonUserInfos);
			//��ȡ�ҵ�����������Ŀ
			List<Project> myAliveProjects=projectService.getAllMyAliveProjects(allAliveProjects, Utils.getUserCommonInfo(user).getCommonID());
			//���ҵ�����������Ŀ����session
			request.getSession().setAttribute("MyAliveProjects", myAliveProjects);
			
			request.getRequestDispatcher("/WEB-INF/pages/myProjects.jsp").forward(request, response);
		}else if("projects".equals(initType))
		{
			System.out.println("��ת����Ŀҳ��");
			//��ȡ������Ŀ
			projects=projectDao.getProjectByName("");
			//��ȡ�����û�������Ϣ
			commonUserInfos=userDao.getAllCommonUserInfo();
			//��ȡ����������Ŀ
			allAliveProjects=projectService.getAllAliveProject(projects, commonUserInfos);
			//��������������Ŀ��session
			request.getSession().setAttribute("AllAliveProjects", projects);
			
			request.getRequestDispatcher("/WEB-INF/pages/projects.jsp").forward(request, response);
		}else if("histProj".equals(initType))
		{
			System.out.println("��ת����ʷ��Ŀ����");

			projects=projectDao.getProjectByName("");
			request.getSession().setAttribute("AllProjects", projects);

			//��ȡ�����û�������Ϣ
			commonUserInfos=userDao.getAllCommonUserInfo();
			request.getSession().setAttribute("AllCommonUserInfo", commonUserInfos);
			
			request.getRequestDispatcher("/WEB-INF/pages/historyProjects.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				addProject(request,response,user);
			}else
			{
				System.out.println("��Ǹ����û��Ȩ�޲���");
				request.getSession().setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			}
			response.sendRedirect(request.getContextPath()+"/projects.html?type=histProj");
		}else if("update".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				updateProject(request,response,user);
			}else
			{
				System.out.println("��Ǹ����û��Ȩ�޲���");
				request.getSession().setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			}
			response.sendRedirect(request.getContextPath()+"/projects.html?type=histProj");
		}else if("delete".equals(initType))
		{
			String tmpId=request.getParameter("id");
			if("".equals(tmpId)||tmpId==null)
			{
				System.out.println("û����Ҫɾ��������");
				request.setAttribute(Constant.ERROR, "û����Ҫɾ��������");
			}else
			{
				int projectID=Integer.parseInt(tmpId);
				if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
				{
					deleteProject(request,response,projectID);
				}else
				{
					System.out.println("��Ǹ����û��Ȩ�޲���");
					request.getSession().setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
				}
			}
			
			response.sendRedirect(request.getContextPath()+"/projects.html?type=histProj");
		}else if("done".equals(initType))
		{
			int projectID=Integer.parseInt(request.getParameter("id"));
			String page=request.getParameter("page");
			Project project=projectDao.getProjectById(projectID);
			project.setStatus(0);
			projectDao.update(project);
			if("myPro".equals(page))
			{
				response.sendRedirect(request.getContextPath()+"/projects.html?type=myProj");
			}else if("allPro".equals(page))
			{
				response.sendRedirect(request.getContextPath()+"/projects.html?type=projects");
			}
			
		}else
		{
			response.sendRedirect(request.getContextPath()+"/projects.html?type=hisProj");
			return;
		}
	}
	
	
	/**
	 * ɾ��һ����Ŀ����
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param tmpId
	 * 			int
	 * 				��ĿID
	 */
	private void deleteProject(HttpServletRequest request, HttpServletResponse response, int projectID) {
		Project project=projectDao.getProjectById(projectID);
		project.setStatus(-1);
		projectDao.update(project);
	}


	/**
	 * ����һ����Ŀ����
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 */
	private void updateProject(HttpServletRequest request, HttpServletResponse response, Object user) {
		int projectID=Integer.parseInt(request.getParameter("newProID"));
		String proName=request.getParameter("newProName");
		String proClient=request.getParameter("newProClinet");
		int proType=Integer.parseInt(request.getParameter("newProType"));
		//��ȡ��Ŀ��ʼʱ��
		Date proStartDate=null;
		String tmp="";
		tmp=request.getParameter("newProStartDate");/////////ȱ��ǰ�˲����ʱ��ģ��
		if(!"".equals(tmp) &&!"δ��д".equals(tmp)&&tmp!=null)
		{
			proStartDate=Utils.stringToDate(tmp);
		}
		tmp="";
		//��ȡ��Ŀ��������
		Date proEndDate=null;
		tmp=request.getParameter("newProEndDate");
		if(!"".equals(tmp) &&!"δ��д".equals(tmp) && tmp!=null)//ǰ�˲����ʱ��ģ��
		{
			proEndDate=Utils.stringToDate(tmp);
		}
		int proCommonID=Integer.parseInt(request.getParameter("newLeaderName"));
		int proIsContract=Integer.parseInt(request.getParameter("newIsContract"));
		int proStatus=Integer.parseInt(request.getParameter("newStatus"));
		String proBook=request.getParameter("newProBook");
		
		
		Project newProject=new Project();
		newProject.setProjectID(projectID);
		newProject.setProjectName(proName);
		newProject.setClient(proClient);
		newProject.setProjectType(proType);
		newProject.setStartDate(proStartDate);
		newProject.setEndDate(proEndDate);
		newProject.setCommonID(proCommonID);
		newProject.setIsContract(proIsContract);
		newProject.setStatus(proStatus);
		newProject.setProBook(proBook);
		newProject.setOpr(1);//���ò������ͣ�1Ϊ���
		
		
		//��Ŀ��ɸ��°�ť
		String act=request.getParameter("act");
		if("done".equals(act))
		{
			
			newProject.setStatus(0);//�������
		}
		
		//������Ŀ����
		projectService.updateProjectInfo(projectID, newProject);
	}


	/**
	 * ���һ����Ŀ��¼
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 */
	private void addProject(HttpServletRequest request, HttpServletResponse response, Object user) {
		String projectName=request.getParameter("ProjectName");
		String client=request.getParameter("Client");
		//��ȡ��Ŀ����
		int projectType=0;//Ĭ��Ϊѧ��������Ŀ
		String tmp=request.getParameter("ProjectType");
		if(!"".equals(tmp)&&tmp!=null)
		{
			projectType=Integer.parseInt(tmp);
		}
		tmp="";
		//��ȡ��Ŀ��ʼʱ��
		Date startDate=null;
		tmp=request.getParameter("StartDate");
		if(!"".equals(tmp)&&tmp!=null)
		{
			startDate=Utils.stringToDate(tmp);
		}
		tmp="";
		//��ȡ��Ŀ��������
		Date endDate=null;
		tmp=request.getParameter("EndDate");
		if(!"".equals(tmp) && tmp!=null)
		{
			endDate=Utils.stringToDate(tmp);
		}
		tmp="";
		//��ȡ��ͬǩ��״̬
		int isContract=0;
		tmp=request.getParameter("IsContract");
		if(!"".equals(tmp)&&tmp!=null)
		{
			isContract=Integer.parseInt(tmp);
		}
		tmp="";
		//��ȡ��Ŀ������
		String proBook=request.getParameter("ProBook");
		
		//��ȡ��Ŀ״̬
		int status=1;//Ĭ����Ŀ״̬Ϊ��������
		tmp=request.getParameter("Status");
		if(!"".equals(tmp)&&tmp!=null)
		{
			status=Integer.parseInt(tmp);
		}
		
		int commonID=Integer.parseInt(request.getParameter("LeaderName"));
		
		Project project=new Project();
		project.setProjectName(projectName);//������Ŀ����
		project.setClient(client);//������Ŀί�з�
		project.setProjectType(projectType);//������Ŀ����
		project.setStartDate(startDate);//������Ŀ��ʼʱ��
		project.setEndDate(endDate);//������Ŀ����ʱ��
		project.setCommonID(commonID);//��ȡ��Ŀ�����˹���ID
		project.setIsContract(isContract);//������Ŀ�Ƿ��Ѿ�ǩ����ͬ
		project.setProBook(proBook);//������Ŀ������
		project.setStatus(status);//������Ŀ״̬
		project.setOpr(0);//�������ݲ�������
		
		//������Ŀ��¼
		projectDao.save(project);
	}
	
	


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
