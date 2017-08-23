package com.example.daoH3.demo.components;

import com.example.daoH3.demo.dao.Person;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Properties;

@Component
@Singleton
public class PersonConsumer {
    public PersonConsumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092,localhost:9093,localhost:9094");
        props.put("group.id","anyGroup");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","com.example.daoH3.demo.components.PersonDeserializer");

        new Thread(() -> {
            KafkaConsumer<String,Person> consumer = new KafkaConsumer<String, Person>(props);

            try {
                consumer.subscribe(Arrays.asList("personTopic"));

                while (true){
                    ConsumerRecords<String,Person> records = consumer.poll(100);
                    for (ConsumerRecord<String,Person> record:records) {
                        System.out.println(record.toString());
                    }
                    consumer.commitAsync();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                consumer.commitSync();
                consumer.close();
            }
        }).start();

    }
}
