package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.common.HibernateUtil;
import com.model.Address;
import com.model.Student;

public class Operation 
{
	Scanner sc=new Scanner(System.in);
	SessionFactory sf=HibernateUtil.getFactory();
	
	Student s=new Student();
	
	public void insertData()
	{
		Address addr=new Address();
		
		Session session=sf.openSession();
		
		System.out.println("pls enter student name");
		s.setName(sc.next());
		
		System.out.println("pls enter area name");
		addr.setArea(sc.next());
		
		System.out.println("pls enter city name");
		addr.setCityname(sc.next());
		
		s.setAddress(addr);
		session.save(s);
		session.beginTransaction().commit();
		session.close();
		System.out.println("data inserted");
		
	}
	public void showAll()
	{
		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(Student.class);
		
		List<Student>list=criteria.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		session.close();
	}
	
	public void update()
	{
		Session session=sf.openSession();
		showAll();
		System.out.println("pls enter the id which you want to update");
		
		int id=sc.nextInt();
		Student s1=session.get(Student.class, id);
		
		System.out.println("pls enetr student name");
		s1.setName(sc.next());
		
		System.out.println("pls enter area name");
		s1.getAddress().setArea(sc.next());
		
		System.out.println("pls enter city name ");
		s1.getAddress().setCityname(sc.next());
		
		
		session.update(s1);
		session.beginTransaction().commit();
		session.close();
		System.out.println("data updated");
		showAll();
		
	}
	
	public void delete()
	{
		Session session=sf.openSession();
		showAll();
		System.out.println("select the id wchich you want to delete");
		int id=sc.nextInt();
		Student s2=session.get(Student.class, id);
		
		session.delete(s2);
		session.beginTransaction().commit();
		session.close();
		showAll();
		System.out.println("data deleted");
		
		
	}

}
