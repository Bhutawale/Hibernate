package com.hibernate.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.helper.HibernateConfiguration;

public class Test 
{
	public static void main(String[] args) 
	{
		SessionFactory factory = HibernateConfiguration.getSessionFactory();
		
		Session session = HibernateConfiguration.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setName("Satish");
		
		Address address=new Address();
		address.setCity("Karjat");
		address.setCountry("India");
		
		emp.setAddress(address);
		
		session.save(emp);
		transaction.commit();
		
		session.close();
		
		factory.close();
	}
}
