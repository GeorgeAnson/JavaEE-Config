package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernate;
import entity.Teacher;
import service.TeacherDao;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public List<Teacher> queryAllTeachers() {
		
		List<Teacher> list=null;
		Transaction tx=null;
		String hql=null;
		
		try {
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Teacher";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return list;
			
		}finally{
			if (tx!=null) {
				tx=null;
				
			}
		}
	 
	}

	@Override
	public boolean addTeacher(Teacher t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTeacher(Teacher tid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeacher(Teacher t) {
		// TODO Auto-generated method stub
		return false;
	}

	 
}
