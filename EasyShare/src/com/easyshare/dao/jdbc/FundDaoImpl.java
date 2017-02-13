package com.easyshare.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.easyshare.dao.FundDao;
import com.easyshare.entity.Fund;
import com.easyshare.utils.Packager;

@Component
@Repository("fundDao")
public class FundDaoImpl extends JDBCBase implements FundDao {

	@Override
	public List<Fund> getFundByTransationName(String transationName) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Fund> funds=new ArrayList<Fund>();
		String sql="SELECT * FROM Fund";
		if(!"".equals(transationName) && transationName!=null)
		{
			sql+=" WHERE FundName="+transationName;
		}
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			
			while(rs.next())
			{
				funds.add(Packager.packFund(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return funds;
	}

	@Override
	public void save(Fund fund) {
		String sql="INSERT INTO Fund VALUES(?,?,?,?,?,?,?,?)";
		Object[] param={
			fund.getFundName(),
			fund.getFundType(),
			fund.getTransationSum(),
			fund.getTransationDetail(),
			fund.getTransationDate(),
			fund.getCommonID(),
			fund.getStatus(),
			fund.getOpr()
		};
		
		//保存交易记录
		saveOrUpdateOrDelete(sql, param);
		
		System.out.println("记录已保存");
	}

	@Override
	public void update(Fund fund) {
		StringBuilder sql=new StringBuilder("UPDATE Fund SET FundName=?, FundType=?, TransationSum=?, CommonID=?, Status=?, Opr=?");
		ArrayList<Object> fundParam=new ArrayList<Object>();
		fundParam.add(fund.getFundName());
		fundParam.add(fund.getFundType());
		fundParam.add(fund.getTransationSum());
		fundParam.add(fund.getCommonID());
		fundParam.add(fund.getStatus());
		fundParam.add(fund.getOpr());
		//若明细不为空
		if(fund.getTransationDetail()!=null)
		{
			sql.append(", TransationDetail=?");
			fundParam.add(fund.getTransationDetail());
		}
		//若日期不为空
		if(fund.getTransationDate()!=null)
		{
			sql.append(", TransationDate=?");
			fundParam.add(fund.getTransationDate());
		}
		//记录ID
		sql.append(" WHERE FundID=?");
		fundParam.add(fund.getFundID());
		//格式化
		Object[] param=fundParam.toArray();
		//更新一条记录
		saveOrUpdateOrDelete(sql.toString(), param);
		
		System.out.println("已更新一条记录");
	}

	@Override
	public Fund getFundByFundID(int fundID) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Fund fund=null;
		
		String sql="SELECT * FROM Fund WHERE FundID="+fundID;
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				fund=Packager.packFund(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return fund;
	}

}
