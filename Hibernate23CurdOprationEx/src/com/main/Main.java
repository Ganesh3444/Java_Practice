package com.main;

import java.util.Scanner;

import com.service.Service;
import com.service.ServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("******************* start *******************");

		Service service = new ServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.Add Product");
			System.out.println("2.Get All Product");
			System.out.println("3.Get Single Product");
			System.out.println("4.Update Product");
			System.out.println("5.Delete Product");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				service.addProduct();
				break;

			case 2:

				service.getAllProduct();
				break;

			case 3:

				service.getSingleProduct();
				break;

			case 4:

				service.updateProduct();
				break;

			case 5:

				service.deleteProduct();
				break;

			default:
				break;
			}
		}

	}

}
