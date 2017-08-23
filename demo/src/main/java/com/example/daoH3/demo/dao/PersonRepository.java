package com.example.daoH3.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;



    public Person getPersonById(int personId) {
        Person person =  entityManager.unwrap(Session.class).get(Person.class, personId);
        return person;
    }
    public Person createPerson(Person person) {
        Session session= entityManager.unwrap(Session.class);
        session.save(person);
        session.flush();
        session.evict(person);
        return person;
    }
}
