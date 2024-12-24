package com.hibernate.SaveData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent 
{
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Student student = session.get(Student.class, 3);
		
		student.setName("Virat");
		student.setCity("USA");
		
		session.update(student);
		
		txn.commit();
		System.out.println("Student with id 3 Updated successfully.");
		session.close();
		factory.close();
	}
}
