package com.cloudsherpas.poc.model;

import org.joda.time.DateTime;
import com.googlecode.objectify.annotation.Id;

public class Customer {
    @Id
    private String emailAddress;
    private String name;
    private DateTime dateCreated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress() {
        this.emailAddress = emailAddress;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
