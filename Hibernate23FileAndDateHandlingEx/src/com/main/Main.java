package com.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.FileData;
import com.util.HibernateUtil;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		 // ************ ERROR
		Path path = Paths.get("C:\\Users\\Ganesh Lawange\\Downloads\\abc.txt");
		byte[] fbyte = Files.readAllBytes(path);
		
		Date date = new Date(System.currentTimeMillis());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH-mm-sss");
		String uploadDate = sdf.format(date);
		
		FileData f = new FileData();
		f.setFname(path.toAbsolutePath().toString());
		f.setFdata(fbyte);
		f.setFileDate(uploadDate);
		
		session.save(f);
		session.beginTransaction().commit();
		System.out.println("Done....!");
		
	}

}
