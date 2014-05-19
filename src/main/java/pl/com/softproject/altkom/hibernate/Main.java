/*
 * Copyright 2014-05-18 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate;

import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.dao.PersonDAO;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("start");

        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            PersonDAO dao = new PersonDAO();
            Person person = dao.load(1l);
            
            if(person == null)
                person = new Person();
            person.setName("Krzychu");
            
            dao.save(person);

            System.out.println("end");

        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            HibernateUtil.getSessionFactory().close();
        }

        
    }

}
