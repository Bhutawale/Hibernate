package com.Hibernate_Practice.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session openSession = factory.openSession();
        
        //Creating Student
        Student stu1=new Student();
        stu1.setSname("Bhagyashri");
        stu1.setSaddress("France");
        
        Student stu2=new Student();
        stu2.setSname("Sanket");
        stu2.setSaddress("Germany");
        
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        session.save(stu1);
        session.save(stu2);
        session.getTransaction().commit();
        session.close();
        factory.close();
        
    }
}
