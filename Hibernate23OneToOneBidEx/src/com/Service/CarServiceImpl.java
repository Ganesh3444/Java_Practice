package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Car;
import com.entity.Engine;
import com.util.HibernateUtil;

public class CarServiceImpl implements CarService{

	public static SessionFactory sf = HibernateUtil.geSessionFactory();
	public static Scanner sc = new Scanner(System.in);
	
	@Override
	public void addCarDetailsWithEngineDetails() {
		// TODO Auto-generated method stub
		Car c = new Car();
		Engine e = new Engine();
		Session session = sf.openSession();
		System.out.println("Enter Car Name :");
		c.setCname(sc.next());
		System.out.println("Enter Car Model :");
		c.setCmodel(sc.next());
		System.out.println("Enter Engine Model :");
		e.setEmodel(sc.next());
		System.out.println("Enter Engine Power :");
		e.setEpower(sc.next());
		c.setEngine(e);
		e.setCar(c);
		session.save(c);
		session.save(e);
		session.beginTransaction().commit();
		
		
		
	}

	@Override
	public void getAllCarDataWithEngineDataUsingCar() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Car> query = session.createQuery("from Car");
		List<Car> clist = query.getResultList();
		System.out.println(clist);
		
	}

	@Override
	public void getAllCarDataWithEngineDataUsingEngine() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Engine> query = session.createQuery("from Engine");
		List<Engine> elist = query.getResultList();
		System.out.println(elist);
	}

	@Override
	public void getSingleDataWithEngineDataUsingEngineId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Engine Id :");
		int id = sc.nextInt();
		Engine e = session.get(Engine.class, id);
		System.out.println(e.getEmodel());
		System.out.println(e.getEpower());
		System.out.println(e.getCar().getCname());
		System.out.println(e.getCar().getCmodel());
	}

	@Override
	public void getSingleDataWithEngineDataUsingCarId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter car Id :");
		int id = sc.nextInt();
		Car c = session.get(Car.class, id);
		System.out.println(c.getCname());
		System.out.println(c.getCmodel());
		System.out.println(c.getEngine().getEmodel());
		System.out.println(c.getEngine().getEpower());
	}

	@Override
	public void updateCarAndEngineDataUsingCar() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Engine e = new Engine();
		System.out.println("Enter car Id :");
		int id = sc.nextInt();
		Car c = session.get(Car.class, id);
		System.out.println("Enter Car Name :");
		c.setCname(sc.next());
		System.out.println("Enter Car Model :");
		c.setCmodel(sc.next());
		System.out.println("Enter Engine Model :");
		e.setEmodel(sc.next());
		System.out.println("Enter Engine Power :");
		e.setEpower(sc.next());
		c.setEngine(e);
		e.setCar(c);
		session.update(c);
		session.update(e);
		session.beginTransaction().commit();
		
	}

	@Override
	public void updateCarAndEngineDataUsingEngine() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Car c = new Car();
		System.out.println("Enter Engine Id :");
		int id = sc.nextInt();
		Engine e = session.get(Engine.class, id);
		System.out.println("Enter Car Name :");
		c.setCname(sc.next());
		System.out.println("Enter Car Model :");
		c.setCmodel(sc.next());
		System.out.println("Enter Engine Model :");
		e.setEmodel(sc.next());
		System.out.println("Enter Engine Power :");
		e.setEpower(sc.next());
		c.setEngine(e);
		e.setCar(c);
		session.update(c);
		session.update(e);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteCarWithBothDetails() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Engine e = new Engine();
		System.out.println("Enter car Id :");
		int id = sc.nextInt();
		Car c = session.get(Car.class, id);
		
		session.delete(c);
		session.delete(e);
		session.beginTransaction().commit();
	}

}
