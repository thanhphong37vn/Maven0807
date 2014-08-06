package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojo.Student;
import com.util.HibernateUtil;

public class TestAnotation {

	public static void main(String[] agrs) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		System.out.println("Connection : " + session.toString());
		session.beginTransaction();
		
		for (int i = 0; i < 30; i++) {
			Student  item = new Student();
			item.setName("name"+i);
			item.setAge(i*3);
			session.save(item);
		}
		
		Query query = session.createQuery("from Student");
		List<Student> students = query.list();
		for (Student student : students) {
			System.out.println(student.toString());
		}
		
		session.getTransaction().commit();
		sessionFactory.close();
	}
}
