package com.manytomanymapping;

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
		
		Employee e=new Employee();
		e.setEid(101);
		e.setEname("Satish");
		
		Employee e1=new Employee();
		e1.setEid(102);
		e1.setEname("Nital");
		
		Project p=new Project();
		p.setPid(11);
		p.setPname("Inventory Management System");
		
		Project p1=new Project();
		p1.setPid(22);
		p1.setPname("Hospital Management System");
		
		List<Employee> elist=new ArrayList<>();
		elist.add(e);
		elist.add(e1);
		
		List<Project> plist=new ArrayList<>();
		plist.add(p);
		plist.add(p1);
		
		e.setProject(plist);
		e1.setProject(plist);
		p.setEmployee(elist);
		p1.setEmployee(elist);
		
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(e);
		s.save(e1);
		s.save(p);
		s.save(p1);
		
		tx.commit();
		s.close();
		
		sf.close();
	}
}
