package com.onetomanymapping;

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
		Configuration cf=new Configuration().configure("Hibernate.cfg.xml");
		
		SessionFactory sf=cf.buildSessionFactory();
		
		Question q1=new Question();
		q1.setQid(01);
		q1.setQue("What is your Mobile Number Satish ?");
		
		Answer a1=new Answer();
		a1.setAid(101);
		a1.setAns("9011150573");
		
		
		Answer a2=new Answer();
		a2.setAid(102);
		a2.setAns("7499151108");
		
		//Adding answers to the list.
		List<Answer> l1=new ArrayList<>();
		l1.add(a1);
		l1.add(a2);
		
		//one question has many answers.
		q1.setAnswer(l1);
		
		
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(q1);
		s.save(a1);
		s.save(a2);
		
		
		tx.commit();
		
		//Fetching the data from the database.
		
		Question q=s.get(Question.class, 01);
		System.out.println(q.getQue());
		
		for(Answer a:q.getAnswer())
		{
			System.out.println(a.getAns());
		}
		
		s.close();
		sf.close();
	}
}
