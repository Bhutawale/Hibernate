package com.Hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.lifecycle.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//Transient State
		
		Address ad=new Address();
		ad.setAid(101);
		ad.setCity("Pune");
		
		Student stu=new Student();
		stu.setSname("Satish");
		stu.setSid(111);
		stu.setAddress(ad);
		
		session.save(ad); //Persistent State- change will take place in database.
		session.save(stu);
		
		stu.setSname("Raj"); 
		
		transaction.commit();
		session.close();
		
		stu.setSname("Rahul");//Detatched State- change will not be reflected in the database.
		factory.close();
	}
}
