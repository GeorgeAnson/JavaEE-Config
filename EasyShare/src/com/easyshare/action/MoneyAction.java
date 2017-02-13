package com.easyshare.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.FundDao;
import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.FundDaoImpl;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Fund;
import com.easyshare.globle.Constant;
import com.easyshare.service.FundService;
import com.easyshare.service.impl.FundServiceImpl;
import com.easyshare.utils.Utils;

@Component
public class MoneyAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4276245608669883085L;

	
	@Autowired
	FundService fundSercvice=new FundServiceImpl();
	
	@Autowired
	FundDao fundDao=new FundDaoImpl();
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		System.out.println("执行MoneyAction方法");
		String initType=request.getParameter("type").trim();
		
		Object user=session.getAttribute(Constant.USER_KEY);
		
		if("money".equals(initType))
		{
			System.out.println("跳转到资金页面");
			//获取所有资金交易信息
			List<Fund> funds=fundDao.getFundByTransationName("");
			//获取所有交易人信息
			List<CommonUserInfo>commonUserInfos=userDao.getAllCommonUserInfo();
			//绑定信息
			List<Fund> allFunds=fundSercvice.combineFundInfo(funds, commonUserInfos);
			//将绑定信息存入session
			session.setAttribute("funds", allFunds);
			//将交易人信息存入session
			session.setAttribute("AllCommonUserInfo", commonUserInfos);
			request.getRequestDispatcher("/WEB-INF/pages/money.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==6)
			{
				System.out.println("添加一条交易记录");
				addFund(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/money.html?type=money");
		}else if("update".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==6)
			{
				System.out.println("修改一条交易记录");
				updateFund(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/money.html?type=money");
		}else if("delete".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==6)
			{
				System.out.println("修改一条交易记录");
				deleteFund(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "抱歉，您没有权限操作");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/money.html?type=money");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/money.html?type=money");
			return;
		}
		
	}
	
	/**
	 * 删除一条交易记录
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 */
	private void deleteFund(HttpServletRequest request, HttpServletResponse response, Object user) {
		int fundID=Integer.parseInt(request.getParameter("delFundID"));
		
		//查找记录
		Fund fund=fundDao.getFundByFundID(fundID);
		fund.setStatus(-1);//删除标志
		fund.setOpr(1);//修改标志
		//更新一条记录
		fundDao.update(fund);
	}

	/**
	 * 修改一条交易记录
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 */
	private void updateFund(HttpServletRequest request, HttpServletResponse response, Object user) {
		
		int fundID=Integer.parseInt(request.getParameter("fundID"));
		String fundName=request.getParameter("fundName");
		int fundType=Integer.parseInt(request.getParameter("fundType"));
		//获取交易金额
		String tmp="";
		double transationSum=0;
		tmp=request.getParameter("transationSum");
		if(!"".equals(tmp) && tmp!=null)
		{
			transationSum=Double.parseDouble(tmp);
		}
		String transationDetail=request.getParameter("transationDetail");
		//获取交易时间
		tmp="";
		Date transationDate=null;
		tmp=request.getParameter("transationDate");
		if(!"未填写".equals(tmp) && tmp!=null)
		{
			transationDate=Utils.stringToDate(tmp);
		}
		int tradeStatus=Integer.parseInt(request.getParameter("tradeStatus"));
		//获取交易人CommonID
		int commonID=Integer.parseInt(request.getParameter("transationPerson"));
		
		Fund fund=new Fund();
		fund.setFundID(fundID);
		fund.setFundName(fundName);
		fund.setFundType(fundType);
		fund.setTransationSum(transationSum);
		fund.setTransationDetail(transationDetail);
		fund.setTransationDate(transationDate);
		fund.setCommonID(commonID);
		fund.setStatus(tradeStatus);//交易状态
		fund.setOpr(1);//操作状态为修改
		
		//判断交易是否合法
		if(!fundSercvice.isTransationOk(fund,true))
		{
			request.setAttribute(Constant.ERROR, "抱歉，余额不足，无法交易");
			System.out.println(request.getAttribute(Constant.ERROR));
			return;
		}
		
		//更新一条记录
		fundDao.update(fund);
	}


	/**
	 * 添加一条交易记录
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 */
	private void addFund(HttpServletRequest request, HttpServletResponse response, Object user) {
		System.out.println("添加成功");
		String fundName=request.getParameter("newFundName");
		int fundType=Integer.parseInt(request.getParameter("newFundType"));
		//获取交易金额
		String tmp="";
		double transationSum=0;
		tmp=request.getParameter("newTransationSum");
		if(!"".equals(tmp) && tmp!=null)
		{
			transationSum=Double.parseDouble(tmp);
		}
		
		
		String transationDetail=request.getParameter("newTransationDetail");
		//获取交易时间
		tmp="";
		Date transationDate=null;
		tmp=request.getParameter("newTransationDate");
		if(!"".equals(tmp) && tmp!=null)
		{
			transationDate=Utils.stringToDate(tmp);
		}
		int status=Integer.parseInt(request.getParameter("newtradeStatus"));
		//获取交易人CommonID
		int commonID=Integer.parseInt(request.getParameter("newTransationPerson"));
		
		//保存对象
		Fund fund=new Fund();
		fund.setFundName(fundName);
		fund.setFundType(fundType);
		fund.setTransationSum(transationSum);
		fund.setTransationDetail(transationDetail);
		fund.setTransationDate(transationDate);
		fund.setCommonID(commonID);
		fund.setStatus(status);//正常状态
		fund.setOpr(0);//添加标志
		
		//判断交易是否合法
		if(!fundSercvice.isTransationOk(fund,false))
		{
			request.setAttribute(Constant.ERROR, "抱歉，余额不足，无法交易");
			System.out.println(request.getAttribute(Constant.ERROR));
			return;
		}
		
		//保存交易记录
		fundDao.save(fund);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
