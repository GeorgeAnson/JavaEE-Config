package com.easyshare.service;

import com.easyshare.entity.Equipment;

/**
 * �豸����
 * @author Administrator
 *
 */
public interface EquipmentService {

	/**
	 * ��鲢�����豸������Ϣ
	 * @param newEquipment
	 * 			Equipment
	 * @return
	 * 		Boolean
	 * 			������true�����豸���ڣ����򲻴���
	 * 			���豸���ڣ��������豸��Ϣ
	 */
	boolean checktoUpdateEquipmentInfo(Equipment newEquipment);
}
