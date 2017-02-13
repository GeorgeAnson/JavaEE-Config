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
	ProjectDao projectDao=new ProjectDaoImpl();//项目Dao数据层服务
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	private List<Project> projects=null;
	//所有用户公共信息
	private List<CommonUserInfo> commonUserInfos=null;
	
	//所有现役项目
	private List<Project> allAliveProjects=null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行ProjectAction方法");
		String initType=request.getParameter("type");
		
		Object user=request.getSession().getAttribute(Constant.USER_KEY);
		
		if("myProj".equals(initType))
		{
			//获取所有项目
			projects=projectDao.getProjectByName("");
			//获取所有用户公共信息
			commonUserInfos=userDao.getAllCommonUserInfo();
			//获取所有现役项目
			allAliveProjects=projectService.getAllAliveProject(projects, commonUserInfos);
			//获取我的所有现役项目
			List<Project> myAliveProjects=projectService.getAllMyAliveProjects(allAliveProjects, Utils.getUserCommonInfo(user).getCommonID());
			//将我的所有现役项目保存session
			request.getSession().setAttribute("MyAliveProjects", myAliveProjects);
			
			request.getRequestDispatcher("/WEB-INF/pages/myProjects.jsp").forward(request, response);
		}else if("projects".equals(initType))
		{
			System.out.println("跳转至项目页面");
			//获取所有项目
			projects=projectDao.getProjectByName("");
			//获取所有用户公共信息
			commonUserInfos=userDao.getAllCommonUserInfo();
			//获取所有现役项目
			allAliveProjects=projectService.getAllAliveProject(projects, commonUserInfos);
			//保存所有现役项目至session
			request.getSession().setAttribute("AllAliveProjects", projects);
			
			request.getRequestDispatcher("/WEB-INF/pages/projects.jsp").forward(request, response);
		}else if("histProj".equals(initType))
		{
			System.out.println("跳转至历史项目界面");

			projects=projectDao.getProjectByName("");
			request.getSession().setAttribute("AllProjects", projects);

			//获取所有用户公共信息
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
				System.out.println("抱歉，您没有权限操作");
				request.getSession().setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			}
			response.sendRedirect(request.getContextPath()+"/projects.html?type=histProj");
		}else if("update".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				updateProject(request,response,user);
			}else
			{
				System.out.println("抱歉，您没有权限操作");
				request.getSession().setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			}
			response.sendRedirect(request.getContextPath()+"/projects.html?type=histProj");
		}else if("delete".equals(initType))
		{
			String tmpId=request.getParameter("id");
			if("".equals(tmpId)||tmpId==null)
			{
				System.out.println("没有需要删除的数据");
				request.setAttribute(Constant.ERROR, "没有需要删除的数据");
			}else
			{
				int projectID=Integer.parseInt(tmpId);
				if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
				{
					deleteProject(request,response,projectID);
				}else
				{
					System.out.println("抱歉，您没有权限操作");
					request.getSession().setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
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
	 * 删除一条项目数据
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param tmpId
	 * 			int
	 * 				项目ID
	 */
	private void deleteProject(HttpServletRequest request, HttpServletResponse response, int projectID) {
		Project project=projectDao.getProjectById(projectID);
		project.setStatus(-1);
		projectDao.update(project);
	}


	/**
	 * 更新一条项目数据
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
		//获取项目开始时间
		Date proStartDate=null;
		String tmp="";
		tmp=request.getParameter("newProStartDate");/////////缺少前端插件，时间模块
		if(!"".equals(tmp) &&!"未填写".equals(tmp)&&tmp!=null)
		{
			proStartDate=Utils.stringToDate(tmp);
		}
		tmp="";
		//获取项目结束日期
		Date proEndDate=null;
		tmp=request.getParameter("newProEndDate");
		if(!"".equals(tmp) &&!"未填写".equals(tmp) && tmp!=null)//前端插件，时间模块
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
		newProject.setOpr(1);//设置操作类型，1为添加
		
		
		//项目完成更新按钮
		String act=request.getParameter("act");
		if("done".equals(act))
		{
			
			newProject.setStatus(0);//正常完成
		}
		
		//更新项目数据
		projectService.updateProjectInfo(projectID, newProject);
	}


	/**
	 * 添加一条项目记录
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
		//获取项目类型
		int projectType=0;//默认为学生科研项目
		String tmp=request.getParameter("ProjectType");
		if(!"".equals(tmp)&&tmp!=null)
		{
			projectType=Integer.parseInt(tmp);
		}
		tmp="";
		//获取项目开始时间
		Date startDate=null;
		tmp=request.getParameter("StartDate");
		if(!"".equals(tmp)&&tmp!=null)
		{
			startDate=Utils.stringToDate(tmp);
		}
		tmp="";
		//获取项目结束日期
		Date endDate=null;
		tmp=request.getParameter("EndDate");
		if(!"".equals(tmp) && tmp!=null)
		{
			endDate=Utils.stringToDate(tmp);
		}
		tmp="";
		//获取合同签订状态
		int isContract=0;
		tmp=request.getParameter("IsContract");
		if(!"".equals(tmp)&&tmp!=null)
		{
			isContract=Integer.parseInt(tmp);
		}
		tmp="";
		//获取项目书链接
		String proBook=request.getParameter("ProBook");
		
		//获取项目状态
		int status=1;//默认项目状态为正常进行
		tmp=request.getParameter("Status");
		if(!"".equals(tmp)&&tmp!=null)
		{
			status=Integer.parseInt(tmp);
		}
		
		int commonID=Integer.parseInt(request.getParameter("LeaderName"));
		
		Project project=new Project();
		project.setProjectName(projectName);//设置项目名称
		project.setClient(client);//设置项目委托方
		project.setProjectType(projectType);//设置项目类型
		project.setStartDate(startDate);//设置项目开始时间
		project.setEndDate(endDate);//设置项目结束时间
		project.setCommonID(commonID);//获取项目负责人公共ID
		project.setIsContract(isContract);//设置项目是否已经签订合同
		project.setProBook(proBook);//设置项目书链接
		project.setStatus(status);//设置项目状态
		project.setOpr(0);//设置数据操作类型
		
		//保存项目记录
		projectDao.save(project);
	}
	
	


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
