package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	
	
	public static void getMovies(Session session) {  // Always hit the database 
		Movies movies = session.get(Movies.class, 1);
		System.out.println(movies.getId());
		System.out.println(movies.getName());
		System.out.println(movies.getPrice());
		
		// eager loading 
		// throw null pointer exception if object/element is not found
		// always hit database
		// performance is slow
		
	}
	
	public static void loadMovie(Session session) {
		Movies movies = session.load(Movies.class, 2);
		System.out.println(movies.getId());
		System.out.println(movies.getName());
		System.out.println(movies.getPrice());
		
		// lazy loading
		//throw object not found exception if object/element is not found
		// is retrieve partial data.
		// performance is high.
	}
	
	
	public static void updateMovies(Session session) {

		Movies movies = session.get(Movies.class, 1);
		System.out.println(movies.getId());
		System.out.println(movies.getName());
		System.out.println(movies.getPrice());
		
		System.out.println("===========================================");
		
		movies.setName("jailer");
		movies.setPrice(300);
		session.update(movies);
		session.beginTransaction().commit();
		
	}
	
	public static void deleteMovie(Session session) {
		

		Movies movies = session.get(Movies.class, 6);
		System.out.println(movies.getId());
		System.out.println(movies.getName());
		System.out.println(movies.getPrice());
		
		System.out.println("===========================================");
		
		session.delete(movies);
		session.beginTransaction().commit();
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
//		
//		Movies movies = new Movies();
//		movies.setName("heart of stone");
//		movies.setPrice(260);
//		
//		session.save(movies);
//		session.beginTransaction().commit();
		
		
		getMovies(session);
		loadMovie(session);
		//updateMovies(session);
		//deleteMovie(session);
		
	}

}
