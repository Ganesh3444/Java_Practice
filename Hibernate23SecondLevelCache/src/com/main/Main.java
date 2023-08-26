package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;
import com.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.geSessionFactory();
		
//		Session session = sf.openSession();
//		Student s = new Student();
//		s.setName("Dhiraj");
//		s.setAddress("pune");
//		
//		session.save(s);
//		session.beginTransaction().commit();
		
		
		// get data From Database
		Session session = sf.openSession();
		Student s = session.get(Student.class, 1);
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getAddress());
		
		System.out.println("***********************************");
		
		Session session1 = sf.openSession();
		Student s1 = session1.get(Student.class, 1);
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getAddress());
		
		
	}

}
