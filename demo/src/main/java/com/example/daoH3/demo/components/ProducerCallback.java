package com.example.daoH3.demo.components;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;

public class ProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(e == null){
            System.out.println("Async send succeded");
        }else{
            System.out.println("Async send failed with error " + e);

        }
    }
}
