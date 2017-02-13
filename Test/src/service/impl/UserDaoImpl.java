package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernate;
import entity.User;
import service.UserDao;

public class UserDaoImpl implements UserDao{

	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean userLogin(User user){
		Transaction tx=null;
		String hqlString="from User where username=? and password=?";
		List<User> list=null;
		
		try {
			Session session=MyHibernate.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery(hqlString);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			list=query.list();
			tx.commit();
			if (list.size()>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
		 
	}

}
