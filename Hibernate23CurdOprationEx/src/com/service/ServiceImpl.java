package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Product;
import com.util.HibernateUtil;

public class ServiceImpl implements Service {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
		Scanner sc = new Scanner(System.in);

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Product product = new Product();
		System.out.println("Enter Product name :");
		product.setPname(sc.next());
		System.out.println("Enter Product Price:");
		product.setPrice(sc.nextDouble());
		System.out.println("Enter Product Type:");
		product.setType(sc.next());
		session.save(product);
		session.beginTransaction().commit(); 
	}

	@Override
	public void getAllProduct() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		org.hibernate.Query<Product> proQuery = session.createQuery("from Product");
		java.util.List<Product> list = proQuery.getResultList();
		for(Product p : list) {
			System.out.println(p);
		}
		
	}

	@Override
	public void getSingleProduct() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		System.out.println("Enter Product Id :");
		int id = sc.nextInt();
		Product product = session.get(Product.class, id);
		System.out.println(product);
		
		
	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Product For Updation :");
		int id = sc.nextInt();
		Product product = session.get(Product.class, id);
		System.out.println("Enter Updated Product name :");
		product.setPname(sc.next());
		System.out.println("Enter Updated Product Price:");
		product.setPrice(sc.nextDouble());
		System.out.println("Enter Updated Product Type :");
		product.setType(sc.next());
		
		session.save(product);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Product For Delete :");
		int id = sc.nextInt();
		Product product = session.get(Product.class, id);
		session.delete(product);
		session.beginTransaction().commit();

	}

}
