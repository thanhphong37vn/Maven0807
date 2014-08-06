package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory buildSessionFactory = getBuildSessionFactory();

	@SuppressWarnings("deprecation")
	public static SessionFactory getBuildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory;
		
	}

	public void shutdown() {
		getBuildSessionFactory().close();
	}

}
