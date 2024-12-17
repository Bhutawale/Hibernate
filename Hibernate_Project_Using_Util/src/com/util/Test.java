package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test
{
	public static void main(String[] args) {
		SessionFactory sf=HbUtil.getFactory();
		
		Session session=sf.openSession();
		
		Student s=new Student();
		
		s.setName("Sanskaar");
		s.setAdddress("Nanded");
		
		session.save(s);
		
		session.beginTransaction().commit();
		
		session.close();
	}
}
