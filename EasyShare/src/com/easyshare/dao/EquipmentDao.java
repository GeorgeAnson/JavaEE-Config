package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.Equipment;

/**
 * 设备及设备管理接口
 * @author Administrator
 *
 */
public interface EquipmentDao {

	/**
	 * 通过设备ID号查查找设备对象
	 * @param equipmentID
	 * 			Int EquipmentID
	 * @return
	 * 		Equipment
	 */
	Equipment getEquipmentByEquipmentId(int equipmentID);
	
	
	/**
	 * 通过设备名称搜索设备
	 * 如果设备名称为空，则默认搜索所有设备
	 * @param name
	 * 		String	Name
	 * @return
	 * 		List<Equipment>
	 */
	List<Equipment> getEquipmentByName(String name);
	
	/**
	 * 保存设备
	 * @param equipment
	 * 		Equipment
	 */
	void save(Equipment equipment);
	
	/**
	 * 更新设备
	 * @param equipment
	 * 		Equipment
	 */
	void update(Equipment equipment);
}
