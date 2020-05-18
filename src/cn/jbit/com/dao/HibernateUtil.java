package cn.jbit.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private static final ThreadLocal sessionTl=new ThreadLocal();
 private static Configuration cf;
 private final static SessionFactory sf;
 /**
  * ����Configuration�����SessionFactory����
  */
 static{
	 try {
		cf=new Configuration().configure("hibernate.cfg.xml");
		sf=cf.buildSessionFactory();
	} catch (Throwable e) {
		e.printStackTrace();
		throw new ExceptionInInitializerError();
	}
 }
 /**
  * ��session
  * @return session
  */
 public static Session currentsession()
 {
	 Session session=(Session)sessionTl.get();
	 if(session==null)
	 {
		 session=sf.openSession();
		 sessionTl.set(session);
	 }
	 return session;
 }
 /**
  * �ر�session
  */
 public static void closeSession(){
	 Session session=(Session)sessionTl.get();
	 sessionTl.set(null);
	 session.close();
 }
}
