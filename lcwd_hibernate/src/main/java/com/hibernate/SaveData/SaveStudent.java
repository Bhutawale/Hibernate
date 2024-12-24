package com.hibernate.SaveData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveStudent 
{
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Student st1=new Student();
		st1.setName("Satish");
		st1.setCity("Pune");
		
		Student st2=new Student(202, "Sagar", "Mumbai");
		
		
		
		session.save(st1);
		session.save(st2);
		txn.commit();
		System.out.println("Student saved.");
		session.close();
		factory.close();
	}
}
