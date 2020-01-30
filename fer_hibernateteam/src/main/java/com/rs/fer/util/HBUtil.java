package com.rs.fer.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtil {

	public static Session session = null;
	public static SessionFactory factory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(com.rs.fer.bean.User.class);
		cfg.addAnnotatedClass(com.rs.fer.bean.Address.class);
		cfg.addAnnotatedClass(com.rs.fer.bean.Expense.class);
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		session = factory.openSession();
		return session;
	}

	public static void closeSession() {

		session.close();
	}

	public static void closeSessionFactory() {

		factory.close();
	}

	public static void getTransactionCommit() {

		session.beginTransaction().commit();
	}

}
