package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Student s = new Student();
		s.setId(123);
		s.setName("ganesh");
		s.setAddress("pune");
		
		Session session = sf.openSession();
		session.save(s);
		
		session.beginTransaction().commit();

	}

}
