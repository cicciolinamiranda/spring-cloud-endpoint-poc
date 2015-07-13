package com.cloudsherpas.poc.model;

import org.joda.time.DateTime;

public class Customer {
    private String name;
    private String emailAddress;
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
