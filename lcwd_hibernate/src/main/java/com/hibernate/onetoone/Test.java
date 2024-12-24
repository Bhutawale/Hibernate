package com.hibernate.onetoone;

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
		
		Question q1=new Question();
		q1.setQuestion("What is Java?");
		Answer a1=new Answer();
		a1.setAnswer("Java is OOP language.");
		q1.setAnswer(a1);
		
		session.save(a1);
		session.save(q1);
		
		transaction.commit();
		session.close();
		
		factory.close();
	}
}
