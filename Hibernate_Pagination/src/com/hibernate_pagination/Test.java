package com.hibernate_pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Test 
{
	public static void main(String[] args) 
	{
		SessionFactory sf=hibernateutil.getFactory();
		
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		Employee e1=new Employee(10,"Satish","Nanded");
		Employee e2=new Employee(11,"Sam","Karjat");
		Employee e3=new Employee(12,"Sagar","Nerul");
		Employee e4=new Employee(13,"Sameer","CBD");
		Employee e5=new Employee(14,"Natraj","Alibaug");
		Employee e6=new Employee(15,"Arjun","Panvel");
		Employee e7=new Employee(16,"Ram","Pune");
		Employee e8=new Employee(17,"Shyam","Nagar");
		Employee e9=new Employee(18,"Viraj","Surat");
		Employee e10=new Employee(19,"Virat","MP");
		
		s.save(e1);s.save(e2);s.save(e3);s.save(e4);s.save(e5);s.save(e6);
		s.save(e7);s.save(e8);s.save(e9);s.save(e10);
		
		tx.commit();
		
		s.close();
		
		
		{
			Session s1=sf.openSession();
			Query<Employee> q1= s1.createQuery("from Employee");
			
			q1.setFirstResult(3); //index number from where to start for displaying data.
			
			q1.setMaxResults(7);  //max. rows to show data.ss
			
			List<Employee> list=q1.list();
			
			for(Employee emp:list)
			{
				System.out.println(emp);
			}
			
			
			s1.close();
		}
		
		
		
		
		
		
		
		sf.close();
	}
}
