package com.hibernate.cascading;

import java.util.ArrayList;
import java.util.List;

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
		
		Person p1=new Person();
		p1.setName("Satish");
		
		Hobby h1=new Hobby();
		h1.setHobby("Reading Books");
		Hobby h2=new Hobby();
		h2.setHobby("Playing Cricket");
		
		List<Hobby> hobbyList=new ArrayList<Hobby>();
		hobbyList.add(h1);
		hobbyList.add(h2);
		
		p1.setHobbies(hobbyList);
		
		session.save(p1);
		
		transaction.commit();
		
		session.close();
		
		factory.close();
	}
}
