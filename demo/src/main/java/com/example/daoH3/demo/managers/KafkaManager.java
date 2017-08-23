package com.example.daoH3.demo.managers;

import com.example.daoH3.demo.components.KafkaPersonProducer;
import com.example.daoH3.demo.components.KafkaStringProducer;
import com.example.daoH3.demo.components.ProducerCallback;
import com.example.daoH3.demo.dao.Person;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaManager {
    @Autowired
    KafkaStringProducer kafkaStringProducer;
    @Autowired
    KafkaPersonProducer personProducer;

    public void sendStringRecordToTopic(String key,String value){
        ProducerRecord<String,String> stringRecord = new ProducerRecord<String, String>("my-replicated-topic",key,value);
        kafkaStringProducer.getProducer().send(stringRecord,new ProducerCallback());

    }

    public void sendPersonRecordToTopic(Person person){
        ProducerRecord<String,Person> personRecord = new ProducerRecord<String, Person>("personTopic",person.getPersonName(),person);
        personProducer.getProducer().send(personRecord,new ProducerCallback());

    }

}

