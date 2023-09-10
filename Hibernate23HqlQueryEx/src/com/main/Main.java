package com.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.entity.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		
//		Student s = new Student();
//		s.setName("Dhiraj");
//		s.setAddress("Solapur");
//		
//		Session session = sf.openSession();
//		session.save(s);
//		session.beginTransaction().commit();
		
		Session session = sf.openSession();
		
		Query query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		System.out.println(slist);
		
		System.out.println("==========================================================");
		// select * from student where id ?
		query = session.createQuery("from Student where id=:id1");
		query.setParameter("id1", 1);
		Student stu = (Student) query.getSingleResult();
		System.out.println(stu);
		
		System.out.println("============================================================");
		// select * from student where name = ?
		
		query = session.createQuery("from Student where name=:n");
		query.setParameter("n", "Dhiraj");
		Student stu1 = (Student) query.getSingleResult();
		System.out.println(stu1);
		
		System.out.println("============================================================");

		// Update name, address from student where id =?
		
		session.beginTransaction();
		query = session.createQuery("update Student set name=:n, address=:a where id=:id1");
		query.setParameter("n", "Ganesh");
		query.setParameter("a", "Pume");
		query.setParameter("id1", 1);
		
		int i = query.executeUpdate();
		System.out.println("Data Updated...!");
		
		
		
		
		
	}

}
