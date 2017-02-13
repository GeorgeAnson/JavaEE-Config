package com.easyshare.dao;

import java.util.List;

import com.easyshare.entity.Equipment;

/**
 * �豸���豸����ӿ�
 * @author Administrator
 *
 */
public interface EquipmentDao {

	/**
	 * ͨ���豸ID�Ų�����豸����
	 * @param equipmentID
	 * 			Int EquipmentID
	 * @return
	 * 		Equipment
	 */
	Equipment getEquipmentByEquipmentId(int equipmentID);
	
	
	/**
	 * ͨ���豸���������豸
	 * ����豸����Ϊ�գ���Ĭ�����������豸
	 * @param name
	 * 		String	Name
	 * @return
	 * 		List<Equipment>
	 */
	List<Equipment> getEquipmentByName(String name);
	
	/**
	 * �����豸
	 * @param equipment
	 * 		Equipment
	 */
	void save(Equipment equipment);
	
	/**
	 * �����豸
	 * @param equipment
	 * 		Equipment
	 */
	void update(Equipment equipment);
}
