package com.example.daoH3.demo.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable{
    public Person() {
    }

    public Person(Integer personId, String personName, String last_name, String address) {
        this.personId = personId;
        this.personName = personName;
        this.last_name = last_name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="person_id")
    private Integer personId;

    @Column(name="name")
    private String personName;

    @Column(name="last_name")
    private String last_name;

    public Integer getPersonId() {
        return personId;
    }

    @Column(name="address")
    private String address;

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
