package service.impl;

import java.util.List;
 
 


import javax.servlet.SessionTrackingMode;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernate;
import entity.Student;
import service.StudentDao;
 
public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> queryAllStudents() {

		Transaction tx=null;
		List<Student> list=null;
		String hql="";
		try {
			
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Student";
			Query query=session.createQuery(hql);
			list=query.list();
			System.out.println("-----testStudent--------");
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
	public Student queryStudentBySid(String sid) {

		Transaction tx=null;
		Student student=null; 
		String hql="";
		try {
			   
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			student =(Student)session.get(Student.class, sid);
			System.out.println(student);
			tx.commit();
			return student;
		 
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return student;

		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
		 
		
	}

	@Override
	public boolean addStudent(Student s) {
		 
		s.setSid(getNewSid());
		Transaction tx=null;
		 
		try {
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
 
		}finally{
			 if (tx!=null) {
				tx=null;
				
			}
		}
		
		
		
	}

	@Override
	public boolean updateStudent(Student s) {
		
		Transaction tx=null;
		try {
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}	
		 
	}

	@Override
	public boolean deleteStudent(String sid) {
		Transaction tx=null;
		
		
		try {
		
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Student student=(Student) session.get(Student.class, sid);
			session.delete(student);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			 e.printStackTrace();
			 
			 return false;
			
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}
	// 生成学生学号
	public String getNewSid(){
		Transaction tx=null;
		 String hql="";
		try {
		 
		Session session=MyHibernate.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		hql="select max(sid) from Student";
		Query query=session.createQuery(hql);
		String sid=(String)query.uniqueResult();
		if ("".equals(sid) || sid==null) {
			sid="S0000001";
		}else {
			String temp=sid.substring(1);
			int i=Integer.parseInt(temp);
			i++;
			temp=String.valueOf(i);
			int len=temp.length();
			for (int j = 0; j <7-len; j++) {
				temp="0"+temp;
			}
			sid="S"+temp;
		}
		tx.commit();
		return sid;
		
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		}finally{
			if (tx!=null) {
				
				tx=null;
			}
		}
		
	}
	 

 
	 
}
