/*
 * Copyright 2014-05-18 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    @ManyToOne
//    @JoinColumn(name = "team_id")
    private Team team;
    
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> message;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
        
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", message" + message.toString() + '}';
    }
 
    
    
}
