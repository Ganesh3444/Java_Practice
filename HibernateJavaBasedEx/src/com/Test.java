package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Employee emp = new Employee();
		emp.setName("Ganesh");
		emp.setAddress("Pune");
		
		Session session = sf.openSession();
		session.save(emp);
		session.beginTransaction().commit();
		
		
		
	}

}
