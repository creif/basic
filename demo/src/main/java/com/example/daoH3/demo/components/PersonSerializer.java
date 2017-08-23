package com.example.daoH3.demo.components;

import com.example.daoH3.demo.dao.Person;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

public class PersonSerializer implements Serializer<Person> {
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Person data) {
        int sizeOfName;
        int sizeOfLastName;
        int sizeOfAddress;
        byte[] serializedName,serializedLastName,serializedAddress;

        try {
            if (data == null)
                return null;
            else {
                serializedName = data.getPersonName().getBytes(encoding);
                sizeOfName = serializedName.length;
                serializedLastName = data.getLast_name().getBytes(encoding);
                sizeOfLastName = serializedLastName.length;
                serializedAddress = data.getAddress().getBytes(encoding);
                sizeOfAddress = serializedAddress.length;

                ByteBuffer buffer  = ByteBuffer.allocate( 4+ 4 + sizeOfName + 4 + sizeOfLastName + 4 + sizeOfAddress);
                buffer.putInt(data.getPersonId());
                buffer.putInt(sizeOfName);
                buffer.put(serializedName);
                buffer.putInt(sizeOfLastName);
                buffer.put(serializedLastName);
                buffer.putInt(sizeOfAddress);
                buffer.put(serializedAddress);
                return buffer.array();
            }
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Error when serializing string to byte[] due to unsupported encoding " + encoding);
        }
    }

    @Override
    public void close() {
        // nothing to do
    }
}