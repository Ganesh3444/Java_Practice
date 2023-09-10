package com.app;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.entity.Employee;
import com.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

//		Employee e = new Employee();
//		e.setName("kalyani");
//		e.setAddress("pune");
//		e.setSalery(18000);
//		
//		session.save(e);
//		session.beginTransaction().commit();

		// list of employee
		Criteria c = session.createCriteria(Employee.class);
		List<Employee> elist = c.list();
		System.out.println(elist);

		// get list of salery equal
		c = session.createCriteria(Employee.class);
		c.add(Restrictions.eq("salery", 18000));
		List<Employee> elist1 = c.list();
		System.out.println(elist1);

		// get salery greater than equal
		c = session.createCriteria(Employee.class);
		c.add(Restrictions.ge("salery", 18000));
		List<Employee> elist2 = c.list();
		System.out.println(elist2);

		// get salery less than equal
		c = session.createCriteria(Employee.class);
		c.add(Restrictions.le("salery", 18000));
		List<Employee> elist3 = c.list();
		System.out.println(elist3);

		// get salery greater than
		c = session.createCriteria(Employee.class);
		c.add(Restrictions.gt("salery", 18000));
		List<Employee> elist4 = c.list();
		System.out.println(elist4);

		// get name employee like
		c = session.createCriteria(Employee.class);
		c.add(Restrictions.like("name", "gan%"));
		List<Employee> elist5 = c.list();
		System.out.println(elist5);

		// get name employee ilike
		c = session.createCriteria(Employee.class);
		c.add(Restrictions.ilike("name", "Gan%"));
		List<Employee> elist6 = c.list();
		System.out.println(elist6);

		// sort name descnding order
		c = session.createCriteria(Employee.class);
		c.addOrder(org.hibernate.criterion.Order.desc("name"));
		List<Employee> elist7 = c.list();
		System.out.println(elist7);

	}

}
