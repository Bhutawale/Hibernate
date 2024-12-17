package com.Hibernate.Cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee emp1=new Employee();
		emp1.setId(102);
		emp1.setName("Satish");
		
		Address add1=new Address(11,"Pune");
		Address add2=new Address(12,"Mumbai");
		Address add3=new Address(13,"Nashik");
		
		List<Address> address=new ArrayList<Address>();
		address.add(add1);
		address.add(add2);
		address.add(add3);
		
		emp1.setAddress(address);
		
		session.save(emp1);
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
