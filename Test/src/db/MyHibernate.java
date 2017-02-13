package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

 
 
public class MyHibernate {
	 private static  SessionFactory sessionFactory;
	 
	 private MyHibernate(){
		 
	 }
	 
	public  static  SessionFactory getSessionFactory(){
		if (sessionFactory==null) {
			Configuration configuration=new Configuration().configure();
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory =configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;
				 
		}else {
			return sessionFactory;
		}
	}
			
			 
 
}
