package com.Hibernate.Onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test
{

	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.onetoone.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		/*Employee emp=new Employee();
		emp.setEid(1001);
		emp.setEname("Satish Bhutawale");
		
		
		Department dep=new Department();
		dep.setDid(2002);
		dep.setDname("Computers");
		emp.setEdep(dep);
		
		session.save(emp);
		session.save(dep);
		
		Employee emp2=new Employee();
		emp2.setEid(1002);
		emp2.setEname("Bhagyashri Bhutawale");
		
		Department dep2=new Department();
		dep2.setDid(2001);
		dep2.setDname("IT");
		emp2.setEdep(dep2);
		
		session.save(emp2);
		session.save(dep2);
		*/
		
		Employee employee = session.get(Employee.class, 1002);
		System.out.println(employee.getEdep());
		
		transaction.commit();
		
		session.close();
		factory.close();
	}

}
