package com.example.daoH3.demo.managers;

import com.example.daoH3.demo.dao.Person;
import com.example.daoH3.demo.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonManager {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(readOnly = true)
    public Person getPersonById(int personId) {
        return personRepository.getPersonById(personId);
    }
    @Transactional(rollbackFor = Exception.class)
    public Person createPerson(Person person) {
       return personRepository.createPerson(person);
    }

}
