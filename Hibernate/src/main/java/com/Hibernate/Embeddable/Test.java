package com.Hibernate.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{

	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.emb.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student stu1=new Student();
		stu1.setSid(101);
		stu1.setSname("Satish");
		Address address=new Address();
		address.setCity("Pune");
		stu1.setAddress(address);
		
		session.save(stu1);
		transaction.commit();
	
		session.close();
		factory.close();
		
	}

}
