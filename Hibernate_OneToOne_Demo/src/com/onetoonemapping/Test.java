package com.onetoonemapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{
	public static void main(String[] args)
	{
		Configuration cf=new Configuration().configure("Hibernate.cfg.xml");
		
		SessionFactory sf=cf.buildSessionFactory();
		
		Question q1=new Question();
		q1.setQuestion_id(01);
		q1.setQuestion("India's National Animal ?");
		
		Question q2=new Question();
		q2.setQuestion_id(02);
		q2.setQuestion("India's Longest Peninsular river ?"); 
		
		Answer a1=new Answer();
		a1.setAnswer_id(101);
		a1.setAnswer("Royal Bengal Tiger");
			
		Answer a2=new Answer();
		a2.setAnswer_id(102);
		a2.setAnswer("Godavari");
		
		
		q1.setAns(a1);
		q2.setAns(a2);

		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(q1);
		s.save(q2);
		s.save(a1);
		s.save(a2);
		
		tx.commit();
		
		s.close();
		sf.close();
	}
}
