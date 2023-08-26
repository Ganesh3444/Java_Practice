package com.main;

import java.util.Scanner;

import com.service.PersonService;
import com.service.PersonServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonService ps = new PersonServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.Add Person Details");
			System.out.println("2.Get All Deatils");
			System.out.println("3.Set Single Detail");
			System.out.println("4.Update Only Person");
			System.out.println("5.Update Adhar Number Using PersonId");
			System.out.println("6.Delete All Details UsingId");

			int id = sc.nextInt();

			switch (id) {
			case 1:

				ps.addPersonDetails();
				break;

			case 2:

				ps.getAllDeatils();
				break;

			case 3:

				ps.getSingleDetail();
				break;

			case 4:

				ps.updateOnlyPerson();
				break;
			case 5:

				ps.updateAdharNoUsingPersonId();
				break;

			case 6:

				ps.deleteAllDetailsUsingId();
				break;

			default:
				break;
			}

		}

	}

}
