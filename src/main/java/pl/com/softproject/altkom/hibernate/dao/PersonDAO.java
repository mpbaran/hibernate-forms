/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.HibernateUtil;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class PersonDAO {

    private final Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public Person load(Long id) {
        
        final Person person = (Person) currentSession.get(Person.class, id);
        return person;
    }
    

    public void save(Person person) {
        currentSession.save(person);
    }
    
}
