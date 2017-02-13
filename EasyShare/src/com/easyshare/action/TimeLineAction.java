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
	ProjectDao projectDao=new ProjectDaoImpl();//项目Dao数据层服务
	
	@Autowired
	UserDao userDao = new UserDaoImpl();//获取用户数据层服务
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行TinmeLineAction方法");
		String initType=request.getParameter("type");
		
		Object user=request.getSession().getAttribute(Constant.USER_KEY);
		
		if("init".equals(initType))
		{
			System.out.println("跳转至历史时间轴界面");
			//获取当前id所对应的饿项目的操作日志信息集合
			List<ManageProject> projectLogInfos=getProjecManageInfo(request,response);

			//保存信息至session
			request.getSession().setAttribute("ManageProjectInfo", projectLogInfos);
			//转发页面
			request.getRequestDispatcher("/WEB-INF/pages/historyTimeLine.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				System.out.println("准备添加项目进度日志");
				addProjectLogInfo(request,response,user);
			}else
			{
				System.out.println("抱歉，您没有权限操作");
				request.getSession().setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			}
			//将跳转放置于函数中
		}
		else if("delete".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==5)
			{
				System.out.println("准备删除项目进度日志");
				deleteProjectLogInfo(request,response,user);
			}else
			{
				System.out.println("抱歉，您没有权限操作");
				request.getSession().setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
			}
			//将跳转放置于函数中
			
		}else
		{
			response.sendRedirect(request.getContextPath());
			return;
		}
	}
	
	
	private void deleteProjectLogInfo(HttpServletRequest request, HttpServletResponse response, Object user)
			throws IOException {
		
		System.out.println("删除一条");
		System.out.println(request.getParameter("projectId"));
		System.out.println(request.getParameter("manageProjectId"));
		int manageProjectID=Integer.parseInt(request.getParameter("manageProjectId"));
		int projectID=Integer.parseInt(request.getParameter("projectId"));
		
		//查找该条日志信息
		ManageProject manageProject=projectDao.getManageProjectByManageProjectID(manageProjectID);
		//状态-1为删除
		manageProject.setStatus(-1);
		//设置操作时间
		manageProject.setModifyDate(new java.sql.Date(new java.util.Date().getTime()));
		
		//删除一条日志信息
		projectDao.update(manageProject);
		
		response.sendRedirect(request.getContextPath()+"/historyTimeLine.html?type=init&id="+projectID);
	}


	/**
	 * 获取某一项目的管理的信息
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @return
	 * 			List<ManageProject>
	 */
	private List<ManageProject> getProjecManageInfo(HttpServletRequest request, HttpServletResponse response) {
		//获取项目ID
		int id=Integer.parseInt(request.getParameter("id"));
		//获取项目日志
		List<ManageProject> projectLogInfos = projectDao.getManageProjectByProjectId(id);
		//获取项目信息
		Project project=projectDao.getProjectById(id);
		
		int formerCommonID=0;
		CommonUserInfo commonUserInfo=null;
		for(ManageProject item:projectLogInfos)
		{
			item.setProject(project);
			if(formerCommonID==0)
			{
				//第一次执行，获取该条记录的操作人信息
				commonUserInfo=userDao.getUserInfoByCommonId(item.getCommonID());
			}else if(formerCommonID!=0 && formerCommonID!=item.getCommonID())
			{
				//若当前记录的CommonID与上一条不同，获取该条记录的操作人信息
				commonUserInfo=userDao.getUserInfoByCommonId(item.getCommonID());
			}
			//其他相同，当前CommonID与上一条不同，且formerCommonID不等于0，则直接获取上一条记录
			//保存记录添加人的公共信息
			item.setCommonUserInfo(commonUserInfo);
			//更新当前公共信息ID标志
			formerCommonID=item.getCommonID();
		}
		return projectLogInfos;
	}


	/**
	 * 为某一项目增加一条日志信息
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
		
		//保存日志
		projectDao.save(manageProject);
		
		response.sendRedirect(request.getContextPath()+"/historyTimeLine.html?type=init&id="+projectID);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
