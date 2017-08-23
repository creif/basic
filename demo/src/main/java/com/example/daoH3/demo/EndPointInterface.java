package com.example.daoH3.demo;

import com.example.daoH3.demo.dao.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dao")
public interface EndPointInterface {

    @GET
    @Produces("text/plain")
    @Path("/hello")
    String message();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/person/{id}")
    Response getPerson(@PathParam("id") Integer id);
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/person")
    Response createPerson(Person person);
}
