package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		
//		Car c = new Car();
//		c.setCarname("altroz");
//		c.setModel("2022");
//		
//		Session session = sf.openSession();
//		session.save(c);
//		session.beginTransaction().commit();
		
		Session session = sf.openSession();
		Session session1 = sf.openSession();
		
		System.out.println("**************************************************");
		
		
//		Car c = session.get(Car.class, 1);
//		System.out.println(c.getId());
//		System.out.println(c.getCarname());
//		System.out.println(c.getModel());
		
		System.out.println("******************************");
		
		Car c1 = session.get(Car.class, 1);
		System.out.println(c1.getId());
		System.out.println(c1.getCarname());
		System.out.println(c1.getModel());
		
		
		System.out.println("================================================");
		
		Car c2 = session1.get(Car.class, 1);
		System.out.println(c2.getId());
		System.out.println(c2.getCarname());
		System.out.println(c2.getModel());
		
		System.out.println("**********************");
		
		Car c3 = session1.get(Car.class, 1);
		System.out.println(c3.getId());
		System.out.println(c3.getCarname());
		System.out.println(c3.getModel());
		
		
		//session.evict(c);  //clear particular object cache.
		//session.clear();   // clear all session cache.
		
		
	}

}
