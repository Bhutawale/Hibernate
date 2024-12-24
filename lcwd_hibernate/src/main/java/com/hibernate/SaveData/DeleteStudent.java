package com.hibernate.SaveData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent 
{
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
	
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student del_stu = session.get(Student.class, 2);
		
		session.delete(del_stu);
		
		transaction.commit();
		System.out.println("Student with id 2 deleted successfully.");
		session.close();
		factory.close();
	}
}
