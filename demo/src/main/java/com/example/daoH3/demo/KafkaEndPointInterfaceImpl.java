package com.example.daoH3.demo;

import com.example.daoH3.demo.dao.Person;
import com.example.daoH3.demo.managers.KafkaManager;
import com.example.daoH3.demo.managers.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class KafkaEndPointInterfaceImpl implements KafkaEndPointInterface{
    @Autowired
    KafkaManager kafkaManager;
    @Autowired
    private PersonManager personManager;

    public String message(){
        return "hello";
    }

    public Response sendMessage(String key,String value){
        kafkaManager.sendStringRecordToTopic(key,value);
        return Response.ok().build();
    }

    public Response sendPerson(Integer personId){
        kafkaManager.sendPersonRecordToTopic(personManager.getPersonById(personId));
        return Response.ok().build();
    }
}
