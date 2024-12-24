package com.hibernate.onetomany;

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
		
		Question q1=new Question();
		q1.setQuestion("Name 3 Wild Animals?");
		Answer a1=new Answer();
		a1.setAnswer("Tiger");
		Answer a2=new Answer();
		a2.setAnswer("Lion");
		Answer a3=new Answer();
		a3.setAnswer("Cheetha");
		
		List<Answer> answerList=new ArrayList<Answer>();
		answerList.add(a1);
		answerList.add(a2);
		answerList.add(a3);
		
		q1.setAnswers(answerList);
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		session.save(q1);
		
		//Fetching Data
//		Question question = session.get(Question.class, 1);
//		
//		List<Answer> answers = question.getAnswers();
//		System.out.println(question.getQuestion());
//		for(Answer a:answers)
//			System.out.println(a.getAnswer());
//		
		transaction.commit();
		session.close();
		factory.close();
	}
}
