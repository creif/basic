package com.example.daoH3.demo.components;

import com.example.daoH3.demo.dao.Person;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.Properties;

@Component
@Singleton
public class KafkaPersonProducer {

    private Producer<String,Person> myProducer;

    public KafkaPersonProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092,localhost:9093,localhost:9094");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","com.example.daoH3.demo.components.PersonSerializer");
        myProducer = new KafkaProducer<String, Person>(props);
    }

    public Producer<String, Person> getProducer() {
        return myProducer;
    }
}
