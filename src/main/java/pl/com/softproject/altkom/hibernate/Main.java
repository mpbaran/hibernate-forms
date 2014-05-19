/*
 * Copyright 2014-05-18 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate;

import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.dao.PersonDAO;
import pl.com.softproject.altkom.hibernate.dao.TeamDAO;
import pl.com.softproject.altkom.hibernate.model.Person;
import pl.com.softproject.altkom.hibernate.model.Team;

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
//            Person person = dao.load(1l);
            TeamDAO teamDAO = new TeamDAO();
            
            Team t = teamDAO.load(2L);
            System.out.println(t.toString());
           Person p = new Person();
            if(t != null)
             p.setTeam(t);
           p.setName("Miro");
//            if(person == null)
//                person = new Person();
//            person.setName("Krzychu");
            
            dao.save(p);

            System.out.println("end");

        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            HibernateUtil.getSessionFactory().close();
        }

        
    }

}
