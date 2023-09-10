package com.main;

import java.util.Scanner;

import com.service.Service;
import com.service.ServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Service s = new ServiceImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.addTeacherWithStudent");
			System.out.println("2.Add Teacher With Exesting Student");

			int id = sc.nextInt();

			switch (id) {
			case 1:
				s.addTeacherWithStudent();
				break;
			case 2:
				s.addTeacherWithExestingStudent();
				break;

			default:
				break;
			}
		}

	}

}
