package com.hibernate_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test
{
	public static void main(String[] args) throws IOException 
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
	
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		           
		Employee emp=new Employee();
		emp.setName("Sanskruti");
		emp.setAddress("Delhi");
		
		
		Student stu=new Student();
		stu.setName("Satish");
		stu.setAddress("Pune");
		stu.setPercentage(89.78);
		
		//code for storing image into the database.
		FileInputStream fis=new FileInputStream("src/image1.png"); //throws exception.
		byte[] arr=new byte[fis.available()];
		fis.read(arr);
		stu.setImage(arr);
		
		
		
		session.save(emp);
		session.save(stu);
		
		session.beginTransaction().commit();
		session.close();
	}

}
 