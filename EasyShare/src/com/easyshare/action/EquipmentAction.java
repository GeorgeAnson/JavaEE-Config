package com.easyshare.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.EquipmentDao;
import com.easyshare.dao.jdbc.EquipmentDaoImpl;
import com.easyshare.entity.Equipment;
import com.easyshare.globle.Constant;
import com.easyshare.service.EquipmentService;
import com.easyshare.service.impl.EquipmentServiceImpl;
import com.easyshare.utils.Utils;

@Component
public class EquipmentAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7972842426534727687L;

	@Autowired
	EquipmentService equipmentService=new EquipmentServiceImpl();
	
	@Autowired
	EquipmentDao equipmentDao=new EquipmentDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String initType=request.getParameter("type");
		//��ȡsession
		HttpSession session=request.getSession();
		//��ȡ��ǰ�û�
		Object user=session.getAttribute(Constant.USER_KEY);
		//��ȡ�����豸����
		List<Equipment> equipments=equipmentDao.getEquipmentByName("");
		session.setAttribute("equipments", equipments);
		
		if("equip".equals(initType))
		{
			request.getRequestDispatcher("/WEB-INF/pages/equipment.jsp").forward(request, response);
			return;
		}else if("add".equals(initType))
		{
			if((Utils.getUserCommonInfo(user)).getAdminType()==3||(Utils.getUserCommonInfo(user)).getAdminType()==0)
			{
				//����豸
				addEquipment(request,response);
			}else
			{
				System.out.println("��Ǹ����û��Ȩ�޲���");
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			}
			response.sendRedirect(request.getContextPath()+"/equipment.html?type=equip");
		}else if("update".equals(initType))
		{
			if((Utils.getUserCommonInfo(user)).getAdminType()==3||(Utils.getUserCommonInfo(user)).getAdminType()==0)
			{
				//�޸��豸��Ϣ
				updateEquipment(request,response);
			}else
			{
				System.out.println("��Ǹ����û��Ȩ�޲���");
				request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
			}
			response.sendRedirect(request.getContextPath()+"/equipment.html?type=equip");
		}else if("delete".equals(initType))
		{
			String tmpId=request.getParameter("id");
			if("".equals(tmpId)||tmpId==null)
			{
				System.out.println("û����Ҫɾ��������");
				request.setAttribute(Constant.ERROR, "û����Ҫɾ��������");
			}else
			{
				int equipmentID=Integer.parseInt(tmpId);
				if((Utils.getUserCommonInfo(user)).getAdminType()==3||(Utils.getUserCommonInfo(user)).getAdminType()==0)
				{
					//ɾ���豸
					deleteEquipment(request,response,equipmentID);
				}else
				{
					System.out.println("��Ǹ����û��Ȩ�޲���");
					request.setAttribute(Constant.ERROR, "��Ǹ����û��Ȩ�޲���");
				}
			}
			response.sendRedirect(request.getContextPath()+"/equipment.html?type=equip");
		}else
		{
			response.sendRedirect(request.getContextPath()+"/equipment.html?type=equip");
			return;
		}
	}
	
	/**
	 * ɾ���豸��Ϣ
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param equipmentID
	 * 		�豸ID
	 * 			int
	 */
	private void deleteEquipment(HttpServletRequest request, HttpServletResponse response, int equipmentID) {
		Equipment equipment=equipmentDao.getEquipmentByEquipmentId(equipmentID);
		//-1״̬���������ѱ�ɾ��
		equipment.setStatus(-1);
		equipmentDao.update(equipment);
	}

	/**
	 * �޸��豸��Ϣ
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 */
	private void updateEquipment(HttpServletRequest request, HttpServletResponse response) {
		int equipmentID=Integer.parseInt(request.getParameter("equipmentID"));
		String equipmentName=request.getParameter("equipmentName");
		double equipmentPrice=Double.parseDouble(request.getParameter("equipmentPrice"));
		int equipmentAmount=Integer.parseInt(request.getParameter("equipmentAmount"));
		int equipmentRemain=Integer.parseInt(request.getParameter("equipmentRemain"));
		int equipmentStatus=Integer.parseInt(request.getParameter("newEquiState"));
		String equipmentSketch=request.getParameter("equipmentSketch");
		
		//�������豸���������豸���������Ĭ��Ϊ�������
		if(equipmentAmount<equipmentRemain)
		{
			equipmentRemain=equipmentAmount;
		}
		
		Equipment newEquipment=new Equipment();
		newEquipment.setEquipmentID(equipmentID);
		newEquipment.setEquipmentName(equipmentName);
		newEquipment.setPrice(equipmentPrice);
		newEquipment.setAmount(equipmentAmount);
		newEquipment.setRemain(equipmentRemain);
		newEquipment.setStatus(equipmentStatus);
		newEquipment.setSketch(equipmentSketch);
		newEquipment.setOpr(1);
		
		if(equipmentService.checktoUpdateEquipmentInfo(newEquipment)){
			equipmentDao.update(newEquipment);
		}
	}


	/**
	 * ���һ̨�豸
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 */
	private void addEquipment(HttpServletRequest request, HttpServletResponse response) {
		String equipmentName=request.getParameter("equipmentName");
		double equipmentPrice=Double.parseDouble(request.getParameter("equipmentPrice"));
		int equipmentAmount=Integer.parseInt(request.getParameter("equipmentAmount"));
		
		int equipmentRemain;
		String remain=request.getParameter("equipmentRemain");
		//�ɿ��ֶεĻ�ȡ���ж�
		if(remain!=null && !"".equals(remain))
		{
			equipmentRemain=Integer.parseInt(remain);
		}else
		{
			//����豸����δ���룬��Ĭ��Ϊ��������ͬ
			equipmentRemain=equipmentAmount;
		}
		int equipmentStatus=Integer.parseInt(request.getParameter("equiStatus"));
		String equipmentSketch=request.getParameter("equipmentSketch");
		
		//����Equipment����
		Equipment equipment=new Equipment();
		equipment.setEquipmentName(equipmentName);
		equipment.setPrice(equipmentPrice);
		equipment.setAmount(equipmentAmount);
		equipment.setRemain(equipmentRemain);
		equipment.setStatus(equipmentStatus);
		equipment.setSketch(equipmentSketch);
		equipment.setOpr(0);
		
		equipmentDao.save(equipment);
	}


	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		doGet(requset,response);
	}
}
