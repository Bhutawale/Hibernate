package com.hibernate.manytomany;

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
		
		Employee emp1=new Employee();
		emp1.setName("Satish");
		
		Employee emp2=new Employee();
		emp2.setName("Rahul");
		
		Project p1=new Project();
		p1.setName("Library Management");
		
		
		Project p2=new Project();
		p2.setName("Hotel Management");
		
		
		Project p3=new Project();
		p3.setName("CMS");
		
		List<Employee> empList =new ArrayList<>();
		List<Project> projectList=new ArrayList<Project>();
		
		empList.add(emp1);
		empList.add(emp2);
		
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
		
		emp1.setProject(projectList);
		emp2.setProject(projectList);
		
		p1.setEmp(empList);
		p2.setEmp(empList);
		p3.setEmp(empList);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
