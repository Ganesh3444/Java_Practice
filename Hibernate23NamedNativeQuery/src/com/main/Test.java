package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.util.HibernateUtil;

public class Test {
	
	public static void addEmployeeData(Session session) {
		
		Employee emp = new Employee();
		emp.setName("ganesh");
		emp.setAddress("pune");
		
		session.beginTransaction();
		
		org.hibernate.query.Query<Employee> query = session.getNamedNativeQuery("insert");
		query.setParameter(1, emp.getId());
		query.setParameter(2, emp.getName());
		query.setParameter(3, emp.getAddress());
		
		query.executeUpdate();    // ************ ERROR
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		addEmployeeData(session);  // ************ ERROR
		
	}

}
