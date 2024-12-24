package com.hibernate.CriteriaAPI;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestCriteria 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
				
		Criteria criteria = session.createCriteria(Teacher.class);
		
		criteria.createAlias("school", "s"); // 's' is the alias for 'school'
		
		//criteria.add(Restrictions.eq("s.name", "DAV"));
		
		criteria.add(Restrictions.like("s.city", "Panvel"));
		
		List<Teacher> teacherList = criteria.list();
		
		for(Teacher teacher:teacherList)
		{
			System.out.println(teacher.getName()+":"+teacher.getSchool().getName());
		}
		
		
		session.close();
		
		factory.close();
	}
}
