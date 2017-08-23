package com.example.daoH3.demo;

import com.example.daoH3.demo.dao.Person;
import com.example.daoH3.demo.managers.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
//@Path("/")
public class EndPointInterfaceImpl implements EndPointInterface {

    @Autowired
    private PersonManager personManager;

    @Override
    public String message() {
        return "hi";
    }

    @Override
    public Response getPerson(Integer id){
        return Response.ok(personManager.getPersonById(id)).build();
    }

    @Override
    public Response createPerson(Person person) {
        if(person == null){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        personManager.createPerson(person);
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
