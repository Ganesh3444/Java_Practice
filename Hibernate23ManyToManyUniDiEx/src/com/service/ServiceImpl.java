package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;
import com.entity.Teacher;
import com.util.HibernateUtil;

public class ServiceImpl implements Service {

	public static SessionFactory sf = HibernateUtil.geSessionFactory();
	public static Scanner sc = new Scanner(System.in);

	@Override
	public void addTeacherWithStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Teacher t = new Teacher();

		System.out.println("Enter Teacher Name :");
		t.setName(sc.next());

		System.out.println("Enter How Many Students allocate :");
		int a = sc.nextInt();

		for (int i = 0; i < a; i++) {
			Student s = new Student();
			System.out.println("Enter Student Name :");
			s.setSname(sc.next());
			System.out.println("Enter Student Address :");
			s.setAddress(sc.next());

			t.getSlist().add(s);
		}

		session.save(t);
		session.beginTransaction().commit();

	}

	@Override
	public void addTeacherWithExestingStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Student id :");
		int sid = sc.nextInt();
		Student s = session.get(Student.class, sid);

		System.out.println("Enter How Many Students Enter :");
		int a = sc.nextInt();

		for (int i = 0; i < a; i++) {
			Teacher t = new Teacher();
			System.out.println("enter teacher name :");
			t.setName(sc.next());
			t.getSlist().add(s);
			session.save(t);
			session.beginTransaction().commit();
		}

	}

}
