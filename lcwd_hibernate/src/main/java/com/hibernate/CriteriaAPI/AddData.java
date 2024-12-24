package com.hibernate.CriteriaAPI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddData
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		School school=new School();
		school.setName("Ryan");
		school.setCity("Kharghar");
		
		Teacher teacher=new Teacher();
		teacher.setName("Bharat");
		teacher.setSchool(school);
		
		session.save(teacher);
		
		transaction.commit();
		
		System.out.println("Data Saved Successfully.");
		
		session.close();
		
		factory.close();
 	}
}
