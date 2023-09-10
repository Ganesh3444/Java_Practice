package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Customer;
import com.entity.Product;
import com.util.HibernateUtil;

public class ServiceImpl implements Service{

	public static SessionFactory sf = HibernateUtil.geSessionFactory();
	public static Scanner sc = new Scanner(System.in);
	
	@Override
	public void addCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Customer c = new Customer();
		System.out.println("Enter Customer Name :");
		c.setName(sc.next());
		System.out.println("Enter Customer Address :");
		c.setAddress(sc.next());
		
		session.save(c);
		session.beginTransaction().commit();
		
		
	}

	@Override
	public void addProductUsingCustomerid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Customer Id :");
		int id = sc.nextInt();
		Customer c = session.get(Customer.class, id);
		Product p = new Product();
		System.out.println("Enter Product Name :");
		p.setPname(sc.next());
		System.out.println("Enter Product Price :");
		p.setPrice(sc.nextDouble());
		
		c.getPlist().add(p);
		session.save(c);
		session.beginTransaction().commit();
		
	}

	@Override
	public void getAllCustomerWithProduct() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		org.hibernate.Query<Customer> query = session.createQuery("from Customer");
		List<Customer> clist = query.getResultList();
		for (Customer c : clist) {
			System.out.println(c);
			
		}
	}
	
	@Override
	public void getSingleCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Customer c = session.get(Customer.class, id);
		System.out.println(c);
		
	}

	@Override
	public void updateCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Customer c = session.get(Customer.class, id);
		System.out.println("Enter Customer Name :");
		c.setName(sc.next());
		System.out.println("Enter Customer Address :");
		c.setAddress(sc.next());
		
		session.update(c);
		session.beginTransaction().commit();
	}

	@Override
	public void updateProductUsingCustomerId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Customer c = session.get(Customer.class, id);
		Product p = new Product();
		System.out.println("Enter Product Name :");
		p.setPname(sc.next());
		System.out.println("Enter Product Price :");
		p.setPrice(sc.nextDouble());
		c.getPlist().add(p);
		session.update(c);
		session.beginTransaction().commit();
	}

	@Override
	public void deleteCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		Customer c = session.get(Customer.class, id);
		session.delete(c);
		session.beginTransaction().commit();
	}

	

}
