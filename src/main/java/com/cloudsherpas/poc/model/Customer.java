package com.cloudsherpas.poc.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import org.joda.time.DateTime;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Customer {

    @Id
    private Long id;
    private String name;
    private String emailAddress;
    private DateTime dateCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
