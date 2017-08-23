package com.example.daoH3.demo.components;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.Properties;

@Component
@Singleton
public class KafkaStringProducer {

    private Producer<String,String> myProducer;

    public KafkaStringProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092,localhost:9093,localhost:9094");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        myProducer = new KafkaProducer<String, String>(props);
    }

    public Producer<String, String> getProducer() {
        return myProducer;
    }
}
