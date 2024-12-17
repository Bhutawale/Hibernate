package com.manytoonemapping;

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
		q1.setQid(111);
		q1.setQuestion("Which Laptops do you have Satish ?");
		
		Answer a1=new Answer();
		a1.setAid(1001);
		a1.setAnswer("Dell");
		
		Answer a2=new Answer();
		a2.setAid(1002);
		a2.setAnswer("Acer");
		
		Answer a3=new Answer();
		a3.setAid(1003);
		a3.setAnswer("HP");
		
		//Adding answers to the list.
		List<Answer> l1=new ArrayList<>();
		l1.add(a1);
		l1.add(a2);
		l1.add(a3);
		
		//one question has many answers.
		q1.setAns(l1);
		a1.setQuestion(q1);
		a2.setQuestion(q1);
		a3.setQuestion(q1);
		
		
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(a3);
	
		
		tx.commit();
		
		//Fetching the data from the database.
		
//		Question q=s.get(Question.class, 01);
//		System.out.println(q.getQuestion());
//		
//		for(Answer a:q.getAns())
//		{
//			System.out.println(a.getAnswer());
//		}
//		
		s.close();
		sf.close();
	}
}

	

