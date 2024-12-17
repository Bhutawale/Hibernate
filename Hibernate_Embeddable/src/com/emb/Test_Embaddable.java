package com.emb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test_Embaddable 
{
	public static void main(String[] args)
	{
		Configuration cf=new Configuration();
		cf.configure("com/emb/hibernate.cfg.xml");
		SessionFactory factory=cf.buildSessionFactory();
		
//		//Data inserted using setters and getters
//		
//		Certificate cer=new Certificate();
//		cer.setCourse("Android");
//		cer.setDuration(2);
//		
//		Student stu=new Student();
//		stu.setSid(101);
//		stu.setSname("Satish");
//		stu.setCerti(cer);

		//Data insertion using constructors.
		
		Certificate cer=new Certificate("Java Programming",3);
		
		Student stu=new Student(105,"Satish",cer);
		
		Certificate cer1=new Certificate("Spring Boot",2);
		
		Student stu1=new Student(104,"Sanskaar",cer1);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(stu);
		session.save(stu1);
		
		tx.commit();
		
		session.close();
		factory.close();
		
	}

}
