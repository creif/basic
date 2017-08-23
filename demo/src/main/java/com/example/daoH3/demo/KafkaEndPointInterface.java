package com.example.daoH3.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kafka")
public interface KafkaEndPointInterface {

    @GET
    @Produces("text/plain")
    @Path("/hello")
    String message();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/send/{key}/{value}")
    Response sendMessage(@PathParam("key") String key,@PathParam("value") String value);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/send/person/{id}")
    Response sendPerson(@PathParam("id")Integer personId);
}
