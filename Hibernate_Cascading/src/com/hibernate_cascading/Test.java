package com.hibernate_cascading;

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
		Configuration cf=new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf=cf.buildSessionFactory();
		
		
		Question q1=new Question();
		q1.setQid(01);
		q1.setQuestion("Name 5 Wild Animals");
		
		Answer a1=new Answer(101,"Lion");
		Answer a2=new Answer(102,"Tiger");
		Answer a3=new Answer(103,"Giraffe");
		Answer a4=new Answer(104,"Monkey");
		Answer a5=new Answer(105,"Elephant");
		
		List<Answer> list=new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
		Session s=sf.openSession();
		
		q1.setAnswer(list);  //Here we have passed all answer list to question q1.
		
		Transaction tx=s.beginTransaction();
		
		
		s.save(q1);
//Here we have saved only question and NOT answers.
//Since we have done cascading all answer relating to question are automatically saved.
		 
		tx.commit();
		
		s.close();
		
		sf.close();
	}
}
