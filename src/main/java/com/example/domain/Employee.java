package com.example.domain;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import  org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Created by vivek on 1/15/2017.
 */
@Document(collection="Employee")
public class Employee {

    @Id
    private ObjectId id;
    @Field("firstName")private String firstName;
    @Field("lastName")private String lastName;
    @Field("employeePicture") private Binary employeePicture;

    @PersistenceConstructor Employee(){}

    @PersistenceConstructor
    public Employee(ObjectId id, String firstName, String lastName, Binary employeePicture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeePicture = employeePicture;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Binary getEmployeePicture() {
        return employeePicture;
    }
}
