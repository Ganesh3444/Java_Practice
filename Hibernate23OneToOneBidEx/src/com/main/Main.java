package com.main;

import java.util.Scanner;

import com.Service.CarService;
import com.Service.CarServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CarService c = new CarServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. Add Car With Engine Details");
			System.out.println("2. Get All Car With Engine Data Using Car");
			System.out.println("3. Get All Car With Engine Data Using Engine");
			System.out.println("4. Get Single Car With Engine Data Using Car Id");
			System.out.println("5. Get Single Car With Engine Data Using Engine Id");
			System.out.println("6. Update Car With Engine Data Using Car Id");
			System.out.println("7. Update Car With Engine Data Using Engine Id");
			System.out.println("8. Delete Car With Engine Data Using Car");

			int id = sc.nextInt();

			switch (id) {
			case 1:
				c.addCarDetailsWithEngineDetails();
				break;
			case 2:
				c.getAllCarDataWithEngineDataUsingCar();
				break;
			case 3:
				c.getAllCarDataWithEngineDataUsingEngine();
				break;
			case 4:
				c.getSingleDataWithEngineDataUsingCarId();
				break;
			case 5:
				c.getSingleDataWithEngineDataUsingEngineId();
				break;
			case 6:
				c.updateCarAndEngineDataUsingCar();
				break;
			case 7:
				c.updateCarAndEngineDataUsingEngine();
				break;
			case 8:
				c.deleteCarWithBothDetails();
				break;

			default:
				break;
			}

		}

	}

}
