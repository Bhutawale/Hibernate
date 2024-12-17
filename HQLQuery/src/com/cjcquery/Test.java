 package com.cjcquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test 
{
		public static void main(String[] args)
{
	

	SessionFactory sf=HibernateUtil.getFactory();
	
//	Session session=sf.openSession();
//	
//	Student s=new Student();
//	s.setName("Sanskaar");
//	s.setAddr("Karjat");
//	session.save(s);
//	session.beginTransaction().commit();
//	session.close();
	
//	{
//		Session session=sf.openSession();
//	
//		Query<Student>query = session.createQuery("from Student");
//		List<Student> list = query.getResultList();
//		
//		for (Student student : list)
//		{
//			System.out.println(student);
//			
//		}
//		session.close();
//	}
//	
//	
//	{
//		Session session=sf.openSession();
//		Query<Student>query=session.createQuery("from Student where id=:id");
//		
	//	query.setInteger("id", 1);
	
//		List<Student>list=query.getResultList();
//		for (Student student : list)
//		{
//			System.out.println(student);
//			
//		}
//		session.close();
//			
//	}
//	
//	{
//		Session session=sf.openSession();
//		session.beginTransaction();
//		Query<Student> query=session.createQuery("delete from Student where id=:id2");
//		query.setInteger("id2", 2);
//		//List<Student>list=query.getResultList();
//		int i=query.executeUpdate();
//		System.out.println(i);
//		session.close();
//		System.out.println("data deleted");
//		
//	}
//	
	{
		
		Session session=sf.openSession();
		session.beginTransaction();
		Query<Student>query = session.createQuery("update Student set name=:n,addr=:ad where id=:id");
		query.setParameter("id", 2);
		query.setString("n", "Sameer");
		query.setString("ad", "Kalhapur"); 
		
		query.executeUpdate();
		
		session.close();
		System.out.println("data updated");
		
	}
	sf.close();
	System.out.println("done");
}

}

