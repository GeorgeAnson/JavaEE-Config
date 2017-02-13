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
		System.out.println("ִ��MoneyAction����");
		String initType=request.getParameter("type").trim();
		
		Object user=session.getAttribute(Constant.USER_KEY);
		
		if("money".equals(initType))
		{
			System.out.println("��ת���ʽ�ҳ��");
			//��ȡ�����ʽ�����Ϣ
			List<Fund> funds=fundDao.getFundByTransationName("");
			//��ȡ���н�������Ϣ
			List<CommonUserInfo>commonUserInfos=userDao.getAllCommonUserInfo();
			//����Ϣ
			List<Fund> allFunds=fundSercvice.combineFundInfo(funds, commonUserInfos);
			//������Ϣ����session
			session.setAttribute("funds", allFunds);
			//����������Ϣ����session
			session.setAttribute("AllCommonUserInfo", commonUserInfos);
			request.getRequestDispatcher("/WEB-INF/pages/money.jsp").forward(request, response);
		}else if("add".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==6)
			{
				System.out.println("���һ�����׼�¼");
				addFund(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/money.html?type=money");
		}else if("update".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==6)
			{
				System.out.println("�޸�һ�����׼�¼");
				updateFund(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
				System.out.println(request.getAttribute(Constant.ERROR));
			}
			response.sendRedirect(request.getContextPath()+"/money.html?type=money");
		}else if("delete".equals(initType))
		{
			if(Utils.getUserCommonInfo(user).getAdminType()==0||Utils.getUserCommonInfo(user).getAdminType()==6)
			{
				System.out.println("�޸�һ�����׼�¼");
				deleteFund(request,response,user);
			}else
			{
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
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
	 * ɾ��һ�����׼�¼
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 */
	private void deleteFund(HttpServletRequest request, HttpServletResponse response, Object user) {
		int fundID=Integer.parseInt(request.getParameter("delFundID"));
		
		//���Ҽ�¼
		Fund fund=fundDao.getFundByFundID(fundID);
		fund.setStatus(-1);//ɾ����־
		fund.setOpr(1);//�޸ı�־
		//����һ����¼
		fundDao.update(fund);
	}

	/**
	 * �޸�һ�����׼�¼
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
		//��ȡ���׽��
		String tmp="";
		double transationSum=0;
		tmp=request.getParameter("transationSum");
		if(!"".equals(tmp) && tmp!=null)
		{
			transationSum=Double.parseDouble(tmp);
		}
		String transationDetail=request.getParameter("transationDetail");
		//��ȡ����ʱ��
		tmp="";
		Date transationDate=null;
		tmp=request.getParameter("transationDate");
		if(!"δ��д".equals(tmp) && tmp!=null)
		{
			transationDate=Utils.stringToDate(tmp);
		}
		int tradeStatus=Integer.parseInt(request.getParameter("tradeStatus"));
		//��ȡ������CommonID
		int commonID=Integer.parseInt(request.getParameter("transationPerson"));
		
		Fund fund=new Fund();
		fund.setFundID(fundID);
		fund.setFundName(fundName);
		fund.setFundType(fundType);
		fund.setTransationSum(transationSum);
		fund.setTransationDetail(transationDetail);
		fund.setTransationDate(transationDate);
		fund.setCommonID(commonID);
		fund.setStatus(tradeStatus);//����״̬
		fund.setOpr(1);//����״̬Ϊ�޸�
		
		//�жϽ����Ƿ�Ϸ�
		if(!fundSercvice.isTransationOk(fund,true))
		{
			request.setAttribute(Constant.ERROR, "��Ǹ�����㣬�޷�����");
			System.out.println(request.getAttribute(Constant.ERROR));
			return;
		}
		
		//����һ����¼
		fundDao.update(fund);
	}


	/**
	 * ���һ�����׼�¼
	 * @param request
	 * 			HttpServletRequest
	 * @param response
	 * 			HttpServletResponse
	 * @param user
	 * 			Object
	 */
	private void addFund(HttpServletRequest request, HttpServletResponse response, Object user) {
		System.out.println("��ӳɹ�");
		String fundName=request.getParameter("newFundName");
		int fundType=Integer.parseInt(request.getParameter("newFundType"));
		//��ȡ���׽��
		String tmp="";
		double transationSum=0;
		tmp=request.getParameter("newTransationSum");
		if(!"".equals(tmp) && tmp!=null)
		{
			transationSum=Double.parseDouble(tmp);
		}
		
		
		String transationDetail=request.getParameter("newTransationDetail");
		//��ȡ����ʱ��
		tmp="";
		Date transationDate=null;
		tmp=request.getParameter("newTransationDate");
		if(!"".equals(tmp) && tmp!=null)
		{
			transationDate=Utils.stringToDate(tmp);
		}
		int status=Integer.parseInt(request.getParameter("newtradeStatus"));
		//��ȡ������CommonID
		int commonID=Integer.parseInt(request.getParameter("newTransationPerson"));
		
		//�������
		Fund fund=new Fund();
		fund.setFundName(fundName);
		fund.setFundType(fundType);
		fund.setTransationSum(transationSum);
		fund.setTransationDetail(transationDetail);
		fund.setTransationDate(transationDate);
		fund.setCommonID(commonID);
		fund.setStatus(status);//����״̬
		fund.setOpr(0);//��ӱ�־
		
		//�жϽ����Ƿ�Ϸ�
		if(!fundSercvice.isTransationOk(fund,false))
		{
			request.setAttribute(Constant.ERROR, "��Ǹ�����㣬�޷�����");
			System.out.println(request.getAttribute(Constant.ERROR));
			return;
		}
		
		//���潻�׼�¼
		fundDao.save(fund);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
