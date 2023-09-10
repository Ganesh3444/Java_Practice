package com.main;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;

import com.entity.Student;
import com.util.HibernateUtil;

public class App {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	public static void addStudent() {
		
		Session session = sf.openSession();
		Student s = new Student();
		s.setName("Dhiraj");
		s.setAddress("pune");
		s.setMarks(81.65);
		
		session.save(s);
		session.beginTransaction().commit();
		
	}
	
	public static void getAllStudent() {
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		javax.persistence.criteria.CriteriaQuery<Student> query = builder.createQuery(Student.class);
		
		Root<Student> root = query.from(Student.class);
							query.select(root);
							
		org.hibernate.Query<Student> query2 = session.createQuery(query);
		List<Student> slist = query2.getResultList();
		System.out.println(slist);
		
	}
	
	
	public static void getSingleStudent() {
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		javax.persistence.criteria.CriteriaQuery<Student> query = builder.createQuery(Student.class);
		
		Root<Student> root = query.from(Student.class);
							query.select(root).where(builder.equal(root.get("id"), 1));
							
		org.hibernate.Query<Student> query2 = session.createQuery(query);
		Student stu = query2.getSingleResult();
		System.out.println(stu);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//addStudent();
		//getAllStudent();
		getSingleStudent();
		
	}

}
