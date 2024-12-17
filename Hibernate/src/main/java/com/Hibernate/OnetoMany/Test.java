package com.Hibernate.OnetoMany;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.onetomany.cfg.xml")
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		/*
		Question q1=new Question();
		q1.setQid(101);
		q1.setQuestion("Name different types of Laptops?");
		
		Answer ans1=new Answer();
		ans1.setAid(1);
		ans1.setAnswer("Acer");
		
		Answer ans2=new Answer();
		ans2.setAid(2);
		ans2.setAnswer("DELL");
		
		Answer ans3=new Answer();
		ans3.setAid(3);
		ans3.setAnswer("Asus");
		
		List<Answer> answer=new ArrayList<Answer>();
		answer.add(ans1);
		answer.add(ans2);
		answer.add(ans3);
		
		q1.setAnswer(answer);
		
		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		*/
		
		//Getting Data
		Question q=new Question();
		int qid = q.getQid();
		
		System.out.println("Enter Question Id: ");
		Scanner scan=new Scanner(System.in);
		qid=scan.nextInt();
		
		Question question = session.get(Question.class, qid);
		
		System.out.println(question.getQuestion());
		
		for(Answer a:question.getAnswer())
		{
			System.out.println(a.getAnswer());
		}
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
