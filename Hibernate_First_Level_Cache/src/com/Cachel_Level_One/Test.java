package com.Cachel_Level_One;

import org.hibernate.Session;

public class Test 
{
	public static void main(String[] args) {
		

		Session session1=HibernateUtil.getFactory().openSession();
		
		/*
		Student s=new Student();
		s.setId(1);
		s.setName("Satish");
		s.setAddress("Karjat");
		
		session.save(s);*/
		
		Student s1=session1.load(Student.class, 1);
		System.out.println(s1);
		
		System.out.println("after");
		//session.evict(s1);//evict removes the single object from the session
		
		Student s2=session1.load(Student.class, 1);
		System.out.println(s2);
		session1.clear();//it removes all the session objects
		
		Student s3=session1.load(Student.class, 1);
		System.out.println(s3);
		
		/*
		Session session2=HibernateUtil.getFactory().openSession();//if we create a new session then new cache is created 
		//so 1st it will fire the query
		Student s4=session2.load(Student.class, 1);
		System.out.println("new session"+s4);
		*/
		session1.beginTransaction().commit();
		session1.close();
		System.out.println("done");
	}
}
