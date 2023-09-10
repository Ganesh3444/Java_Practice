package com.controller;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.service.Service;
import com.service.ServiceImpl;
import com.util.HibernateUtil;

public class HomeController {

	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Service service = new ServiceImpl();

		while (true) {
			System.out.println("1. Add Customer :");
			System.out.println("2. Add Product Using costomer id :");
			System.out.println("3. Get All Customer :");
			System.out.println("4. Update Customer :");
			System.out.println("5. Update Priduct Using Id :");
			System.out.println("6. Delete Customer :");

			int id = sc.nextInt();

			switch (id) {
			case 1:

				service.addCustomer();
				break;
			case 2:

				service.addProductUsingCustomerid();
				break;
			case 3:

				service.getAllCustomerWithProduct();
				break;
			case 4:

				service.updateCustomer();
				break;
			case 5:

				service.updateProductUsingCustomerId();
				break;
			case 6:

				service.deleteCustomer();
				break;

			default:
				break;
			}

		}

	}

}
