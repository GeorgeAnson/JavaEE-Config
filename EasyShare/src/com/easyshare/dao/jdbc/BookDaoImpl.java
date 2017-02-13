package com.easyshare.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.easyshare.dao.BookDao;
import com.easyshare.entity.Book;
import com.easyshare.entity.ManageBook;
import com.easyshare.utils.Packager;

@Component
@Repository("bookDao")
public class BookDaoImpl extends JDBCBase implements BookDao {

	@Override
	public Book getBookById(int bookID) {
		//
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Book book=null;
		String sql="SELECT * FROM Books WHERE BookID="+bookID;
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				book=Packager.packBook(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();	
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return book;
	}

	@Override
	public List<Book> getBookByCondition(String condition) {
		
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Book> books=new ArrayList<Book>();
		String sql=null;
		try 
		{
			/*** 暂时的判断两种情况，一种直接输出所有书本，一种输出用户参数指定的书本类型 ***/
			if(condition==null)
			{
				System.out.println("null条件");
				sql="SELECT * FROM Books";
				ps=conn.prepareStatement(sql);
				rs=query(ps);
			}else
			{
				System.out.println("非空条件");
				sql="SELECT * FROM Books WHERE BookName=? OR Author=?";
				Object[] param={condition,condition};
				ps=conn.prepareStatement(sql);
				rs=query(ps,param);
			}
			//数据打包
			while(rs.next())
			{
				books.add(Packager.packBook(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return books;
	}

	@Override
	public void save(Book book) {
		String sql="INSERT INTO Books VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] bparam={
				book.getBookName(),
				book.getAuthor(),
				book.getPublishCompany(),
				book.getAmount(),
				book.getRemain(),
				book.getPrice(),
				book.getModifyDate(),
				book.getStatus(),
				book.getOpr()};
		
		saveOrUpdateOrDelete(sql, bparam);
		System.out.println("book信息保存成功");		
	}

	@Override
	public void update(Book book) {
		StringBuilder sql=new StringBuilder("UPDATE Books SET Amount=?,Remain=?,Price=?,Status=?,Opr=?");
		ArrayList<Object> comp=new ArrayList<Object>();
		comp.add(book.getAmount());
		comp.add(book.getRemain());
		comp.add(book.getPrice());
		comp.add(book.getStatus());
		comp.add(book.getOpr());
		
		if(book.getBookName()!=null)
		{
			sql.append(",BookName=?");
			comp.add(book.getBookName());
		}
		
		if(book.getAuthor()!=null)
		{
			sql.append(",Author=?");
			comp.add(book.getAuthor());
		}
		
		if(book.getPublishCompany()!=null)
		{
			sql.append(",PublishCompany=?");
			comp.add(book.getPublishCompany());
		}
		
		if(book.getModifyDate()!=null)
		{
			sql.append(",ModifyDate=?");
			comp.add(book.getModifyDate());
		}
		
		sql.append(" WHERE BookID=?");
		comp.add(book.getBookID());
		
		Object[] bparam=comp.toArray();
		saveOrUpdateOrDelete(sql.toString(), bparam);
		
		System.out.println("书本信息修改成功");
	}

	@Override
	public List<ManageBook> getBookByBorrowUserCommonID(int commonID) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ManageBook> manageBooks=new ArrayList<ManageBook>();
		String sql="SELECT * FROM ManageBooks";
		
		//如果CommonID传入-1，则默认检索所有数据，否则检索对应commonID数值
		if(commonID!=-1)
		{
			sql+=" WHERE CommonID="+commonID;
		}
		
		try 
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			while(rs.next())
			{
				manageBooks.add(Packager.packManageBooks(rs));
			}
		} catch (SQLException e)
		{
			System.out.println("借出信息查询失败");
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		return manageBooks;
	}

	@Override
	public void saveManageBook(ManageBook manageBook) {
		
		String sql="INSERT INTO ManageBooks VALUES(?,?,?,?)";
		Object[] param={
			manageBook.getCommonID(),
			manageBook.getBookID(),
			manageBook.getBorrowDate(),
			manageBook.getReturnDate()
		};
		
		saveOrUpdateOrDelete(sql, param);
		System.out.println("保存一条借书还书信息");
		
		update(manageBook.getBook());
		System.out.println("更新书本信息成功");
	}

	@Override
	public void update(ManageBook manageBook) {
		String sql="UPDATE ManageBooks SET ReturnDate=? WHERE ManageBookID=?";
		Object[] param={
			manageBook.getReturnDate(),
			manageBook.getManageBookID()
		};
		
		saveOrUpdateOrDelete(sql, param);
		System.out.println("一条还书信息");
		
		update(manageBook.getBook());
		System.out.println("更新书本信息成功");
	}

	@Override
	public ManageBook getManageBookByManageBookID(int manageBookID) {
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ManageBook manageBook=null;
		String sql="SELECT * FROM ManageBooks WHERE ManageBookID="+manageBookID;
		try
		{
			ps=conn.prepareStatement(sql);
			rs=query(ps);
			if(rs.next())
			{
				manageBook=Packager.packManageBooks(rs);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();	
		}finally
		{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return manageBook;
	}

}
