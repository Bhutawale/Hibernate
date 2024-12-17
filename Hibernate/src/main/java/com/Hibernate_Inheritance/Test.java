package com.Hibernate_Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate_inheritance.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee e=new Employee();
		e.setEname("Satish");
		
		Regular_Employee re=new Regular_Employee();
		re.setEname("Virat");
		re.setEsalary(50000.00);
		re.setBonus(10000);
		
		Contract_Employee ce=new Contract_Employee();
		ce.setEname("Sampat");
		ce.setPay_per_hour(50);
		ce.setContract_duration("12 months");
		
		session.save(e);
		session.save(re);
		session.save(ce);
		
		transaction.commit();
		
		session.close();
		
		factory.close();
	}
}
