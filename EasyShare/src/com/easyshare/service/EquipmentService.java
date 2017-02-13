package com.easyshare.service;

import com.easyshare.entity.Equipment;

/**
 * 设备服务
 * @author Administrator
 *
 */
public interface EquipmentService {

	/**
	 * 检查并更新设备对象信息
	 * @param newEquipment
	 * 			Equipment
	 * @return
	 * 		Boolean
	 * 			若返回true，则设备存在，否则不存在
	 * 			若设备存在，并更新设备信息
	 */
	boolean checktoUpdateEquipmentInfo(Equipment newEquipment);
}
