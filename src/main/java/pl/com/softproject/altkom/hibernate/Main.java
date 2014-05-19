/*
 * Copyright 2014-05-18 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.dao.MessageDAO;
import pl.com.softproject.altkom.hibernate.dao.PersonDAO;
import pl.com.softproject.altkom.hibernate.dao.TeamDAO;
import pl.com.softproject.altkom.hibernate.model.Message;
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
            TeamDAO teamDAO = new TeamDAO();
            MessageDAO messageDAO = new MessageDAO();
            Team t = new Team();
            t.setName("Team 1");
            teamDAO.save(t);
            
            Person p = new Person();
            p.setId(1L);
            p.setName("Janusz");
            p.setTeam(t);
//            Person person = dao.load(1l);
//            dao.save(p);
            List<Message> list = new ArrayList<>();
            Message m;
            for (int i = 5; i < 8; i++){
                m = new Message();
                m.setSender(p);
                m.setSubject(""+i);
                m.setContent("Wiadomość" + i);
//                messageDAO.save(m);
                list.add(m);
            }
            p.setMessage(list);
            
            
//            dao.save(p);
//            System.out.println(t.toString());
//           Person p = new Person();
//            if(t != null)
//             p.setTeam(t);
//           p.setName("Miro");
//            if(person == null)
//                person = new Person();
//            person.setName("Krzychu");
            
            dao.save(p);
            
            System.out.println(p.toString());
            System.out.println("end");

        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            HibernateUtil.getSessionFactory().close();
        }

        
    }

}
