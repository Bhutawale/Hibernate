package com.Hibernate.HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Test 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.hql.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//INSERTING DATA
		/*
		Student stu1=new Student();
		stu1.setSid(101);
		stu1.setSname("Satish");
		stu1.setCity("Pune");
		
		Student stu2=new Student();
		stu2.setSid(102);
		stu2.setSname("Sanskar");
		stu2.setCity("Mumbai");
		
		Student stu3=new Student();
		stu3.setSid(103);
		stu3.setSname("Satish");
		stu3.setCity("Nashik");
		
		
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		*/
		
		
		
		//GETTING DATA USING HQL
		
		//getting all data.
		
		String query1="from Student"; 
		Query createQuery = session.createQuery(query1);
		List<Student> list = createQuery.list();
		for(Student s:list)
		{
			System.out.println(s.getSname()+":"+s.getCity());
		}
		
		//Getting specific data using where clause
		
		
		String query2="from Student where city='Pune'";
		Query createQuery2 = session.createQuery(query2);
		List<Student> list2 = createQuery2.list();
		for(Student s:list2)
		{
			System.out.println(s.getSname());
		}
		
		String query3="from Student where sname='Sanskar' and city='Mumbai'";
		Query createQuery3 = session.createQuery(query3);
		List<Student> list3 = createQuery3.list();
		System.out.println(list3);
		
		
		
		
		//Deleting single Data
		
		//Query createQuery4 = session.createQuery("delete from Student where city='Nashik'");
		//int i = createQuery4.executeUpdate();
		//System.out.println(i +" Row Deleted");
		
		
		
		
		//Updating Data
		
		Query createQuery5 = session.createQuery("update Student set sname='Sanskruti' where sid=101");
		int update = createQuery5.executeUpdate();
		System.out.println(update+" Row Updated");
		
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
