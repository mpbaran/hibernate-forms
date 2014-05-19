/*
 * Copyright 2014-05-18 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate;

import org.hibernate.Session;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("start");
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        System.out.println("end");
        
        HibernateUtil.getSessionFactory().close();
    }
    
}
