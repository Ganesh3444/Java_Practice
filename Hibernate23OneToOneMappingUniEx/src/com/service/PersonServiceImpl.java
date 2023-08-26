package com.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.AdharDetails;
import com.entity.Person;
import com.util.HibernateUtil;

public class PersonServiceImpl implements PersonService {

	SessionFactory sf = HibernateUtil.geSessionFactory();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addPersonDetails() {
		// TODO Auto-generated method stub
		Person ps = new Person();
		AdharDetails ad = new AdharDetails();
		System.out.println("Enter Person Name :");
		ps.setName(sc.next());
		System.out.println("Enter Person Mobile Number :");
		ps.setMobno(sc.next());
		System.out.println("Enter Adhar No :");
		ad.setPadharno(sc.nextLong());
		System.out.println("Enter Your Adderess :");
		ad.setAddress(sc.next());
		ps.setAdharDetails(ad);
		Session session = sf.openSession();
		session.save(ps);
		session.beginTransaction().commit();
	}

	@Override
	public void getAllDeatils() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		org.hibernate.Query<Person> query = session.createQuery("from Person");
		List<Person> plist = query.getResultList();
		
		for(Person p :plist) {
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getMobno());
			System.out.println(p.getAdharDetails().getAddress());
			System.out.println(p.getAdharDetails().getPadharno());
		}
	}

	@Override
	public void getSingleDetail() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getMobno());
		System.out.println(p.getAdharDetails().getAddress());
		System.out.println(p.getAdharDetails().getPadharno());
	}

	@Override
	public void updateOnlyPerson() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		
		System.out.println("Enter Name :");
		p.setName(sc.next());
		System.out.println("Enter Mobile Number :");
		p.setMobno(sc.next());
		
		session.save(p);
		session.beginTransaction().commit();
	}

	@Override
	public void updateAdharNoUsingPersonId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		AdharDetails ad = new AdharDetails();
		
		System.out.println("Enter Adhar No :");
		ad.setPadharno(sc.nextLong());
		System.out.println("Enter Address :");
		ad.setAddress(sc.next());
		
		p.setAdharDetails(ad);
		session.update(p);
		session.beginTransaction().commit();
	}

	@Override
	public void deleteAllDetailsUsingId() {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		
		session.delete(p);
		session.beginTransaction().commit();
		
	}

}
