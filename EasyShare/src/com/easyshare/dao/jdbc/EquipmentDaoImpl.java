package com.easyshare.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.easyshare.dao.EquipmentDao;
import com.easyshare.entity.Equipment;
import com.easyshare.utils.Packager;

@Component
@Repository("equipmentDao")
public class EquipmentDaoImpl extends JDBCBase implements EquipmentDao{

	@Override
	public Equipment getEquipmentByEquipmentId(int equipmentID) {
		Equipment equipment=null;
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Equipments WHERE EquipmentID="+equipmentID;

		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				equipment=Packager.packEquipment(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return equipment;
	}

	@Override
	public List<Equipment> getEquipmentByName(String name) {

		List<Equipment> equipments=new ArrayList<Equipment>();
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT * FROM Equipments";
		if(name!=null && !"".equals(name))
		{
			System.out.println("有查询条件");
			sql+=" WHERE EquipmentName="+name;
		}
		
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				equipments.add(Packager.packEquipment(rs));
			}
		} catch (SQLException e)
		{
			
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return equipments;
	}

	@Override
	public void save(Equipment equipment) {
		String sql="INSERT INTO Equipments VALUES(?,?,?,?,?,?,?)";
		Object[] param={
			equipment.getEquipmentName(),
			equipment.getPrice(),
			equipment.getAmount(),
			equipment.getRemain(),
			equipment.getStatus(),
			equipment.getOpr(),
			equipment.getSketch()
			
		};
		
		saveOrUpdateOrDelete(sql, param);
		System.out.println("存储一台设备");
	}

	@Override
	public void update(Equipment equipment) {
		StringBuilder sql=new StringBuilder("UPDATE Equipments SET EquipmentName=?, Amount=?, Remain=?, Status=?, Price=?, Opr=?");
		ArrayList<Object> equipmentParam=new ArrayList<Object>();
		equipmentParam.add(equipment.getEquipmentName());
		equipmentParam.add(equipment.getAmount());
		equipmentParam.add(equipment.getRemain());
		equipmentParam.add(equipment.getStatus());
		equipmentParam.add(equipment.getPrice());
		equipmentParam.add(equipment.getOpr());
		
		if(equipment.getSketch()!=null)
		{
			sql.append(", Sketch=?");
			equipmentParam.add(equipment.getSketch());
		}
		
		sql.append(" WHERE EquipmentID=?");
		equipmentParam.add(equipment.getEquipmentID());
		
		Object[] param=equipmentParam.toArray();
		saveOrUpdateOrDelete(sql.toString(), param);
		
		System.out.println("设备信息更新");
	}

}
