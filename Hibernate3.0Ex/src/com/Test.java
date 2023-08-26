package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Employee emp = new Employee();
		emp.setId(111);
		emp.setName("Ganesh");
		emp.setAddress("Pune");
		
		Session session = sf.openSession();
		session.save(emp);
		
		session.beginTransaction().commit();
		System.out.println("Created Succesful");
		
		
	}

}
