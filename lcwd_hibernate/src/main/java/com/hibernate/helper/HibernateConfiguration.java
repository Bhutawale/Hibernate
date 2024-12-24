package com.hibernate.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    // Singleton instance of SessionFactory
    private static SessionFactory sessionFactory;

    // Static block for initialization
    static {
        try {
            // Load configuration and build SessionFactory
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to create SessionFactory: " + e.getMessage());
        }
    }

    // Method to get the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Method to get a new Session
    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
