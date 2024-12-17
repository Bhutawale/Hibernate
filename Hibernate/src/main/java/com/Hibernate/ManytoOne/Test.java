package com.Hibernate.ManytoOne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.manytoone.cfg.xml")
				.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Department dep=new Department();
		dep.setDid(100);
		dep.setDname("Computers");
		
		Employee emp1=new Employee();
		emp1.setEid(101);
		emp1.setDept(dep);
		emp1.setEname("Satish Bhutawale");
		
		Employee emp2=new Employee();
		emp2.setEid(102);
		emp2.setDept(dep);
		emp2.setEname("Bhagyashri");
		
		Employee emp3=new Employee();
		emp3.setEid(103);
		emp3.setDept(dep);
		emp3.setEname("Sanskar");
		
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(dep);
		
		transaction.commit();
		
		session.close();
		factory.close();
	}

}
