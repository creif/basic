package com.example.daoH3.demo.components;

import com.example.daoH3.demo.dao.Person;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

public class PersonDeserializer implements Deserializer<Person> {
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Person deserialize(String topic, byte[] data) {
        try {
            if (data == null)
                return null;
            else {
                ByteBuffer buffer = ByteBuffer.wrap(data);
                int id = buffer.getInt();
                int sizeOfName = buffer.getInt();
                byte[] nameBytes = new byte[sizeOfName];
                buffer.get(nameBytes);
                String deserializedName = new String (nameBytes,encoding);

                int sizeOfLastName = buffer.getInt();
                byte[] lastNameBytes = new byte[sizeOfLastName];
                buffer.get(lastNameBytes);
                String deserializedLastName = new String (lastNameBytes,encoding);

                int sizeOfAddress = buffer.getInt();
                byte[] addressBytes = new byte[sizeOfAddress];
                buffer.get(addressBytes);
                String deserializedAddress = new String (addressBytes,encoding);

                return new Person(id,deserializedName,deserializedLastName,deserializedAddress);
            }
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when deserializing byte[] to string due to unsupported encoding " + encoding);
        }
    }

    @Override
    public void close() {
        // nothing to do
    }
}
