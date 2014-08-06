package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mapXml.Admin;

import com.util.HibernateUtil;

public class TestMapXml {

	public static void main(String[] agrs) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		System.out.println("Connection : " + session.toString());
		session.beginTransaction();
		
		for (int i = 0; i < 30; i++) {
			Admin  item = new Admin();
			item.setId(i*5+2);
			item.setUsername("name"+i);
			item.setPassword(i*3+"");
			session.save(item);
		}
		
		Query query = session.createQuery("from Admin");
		List<Admin> admins = query.list();
		for (Admin admin : admins) {
			System.out.println(admin.toString());
		}
		
		session.getTransaction().commit();
		sessionFactory.close();
	}
}
