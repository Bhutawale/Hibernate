package com.Hibernate.ManytoMany;

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
		SessionFactory factory = new Configuration()
					.configure("hibernate.manytomany.cfg.xml")
					.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee e1=new Employee();
		Employee e2=new Employee();
		
		e1.setEid(101);
		e1.setEname("Satish");
		
		e2.setEid(102);
		e2.setEname("Sanskruti");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(111);
		p1.setPname("Hotel Mgmt");
		
		p2.setPid(222);
		p2.setPname("Library Mgmt");
		
		List<Employee> empl=new ArrayList<Employee>();
		empl.add(e1);
		empl.add(e2);
		
		List<Project> proj=new ArrayList<Project>();
		proj.add(p1);
		proj.add(p2);
		
		e1.setProject(proj);
		p1.setEmp(empl);
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
