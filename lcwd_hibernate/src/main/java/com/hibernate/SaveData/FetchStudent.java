package com.hibernate.SaveData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchStudent 
{
	public static void main(String[] args) {
		Configuration cf=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cf.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Student student = session.load(Student.class, 2);
		
		System.out.println(student);
		
		txn.commit();
		
		session.close();
		
		factory.close();
	}
}
