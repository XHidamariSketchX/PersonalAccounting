package com.cornu.PA.util.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;
	static
	{
		try{
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	public static void closeSession(Session session){
		if(session!=null)
			session.close();
	}
}
