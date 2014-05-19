/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.HibernateUtil;
import pl.com.softproject.altkom.hibernate.model.Team;

/**
 *
 * @author Administrator
 */
public class TeamDAO {
 private final Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
 
 public Team load(Long id){
     return (Team)session.get(Team.class, id);
 }
 
 public Long save(Team team){
     return (Long)session.save(team);
 }
}
