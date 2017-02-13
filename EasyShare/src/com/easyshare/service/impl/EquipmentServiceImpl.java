package com.easyshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyshare.dao.EquipmentDao;
import com.easyshare.dao.jdbc.EquipmentDaoImpl;
import com.easyshare.entity.Equipment;
import com.easyshare.service.EquipmentService;

@Service("equipmentSerice")
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	EquipmentDao equipmentDao=new EquipmentDaoImpl();
	
	@Override
	public boolean checktoUpdateEquipmentInfo(Equipment newEquipment) {
		Equipment oldEquipment=equipmentDao.getEquipmentByEquipmentId(newEquipment.getEquipmentID());
		if(oldEquipment!=null)
		{
			//更新设备名
			if(!oldEquipment.getEquipmentName().equals(newEquipment.getEquipmentName()))
			{
				oldEquipment.setEquipmentName(newEquipment.getEquipmentName());
			}
			//更新设备价格
			if(oldEquipment.getPrice()!=newEquipment.getPrice())
			{
				oldEquipment.setPrice(newEquipment.getPrice());
			}
			//更新设备库存量
			if(oldEquipment.getAmount()!=newEquipment.getAmount())
			{
				oldEquipment.setAmount(newEquipment.getAmount());
			}
			//更新设备库存余量
			if(oldEquipment.getRemain()!=newEquipment.getRemain())
			{
				oldEquipment.setRemain(newEquipment.getRemain());
			}
			//更新设备状态
			if(oldEquipment.getStatus()!=newEquipment.getStatus())
			{
				oldEquipment.setStatus(newEquipment.getStatus());
			}
			//更新设备简述
			if(!oldEquipment.getSketch().equals(newEquipment.getSketch()))
			{
				oldEquipment.setSketch(newEquipment.getSketch());
			}
			return true;
		}
		return false;
	}

}
