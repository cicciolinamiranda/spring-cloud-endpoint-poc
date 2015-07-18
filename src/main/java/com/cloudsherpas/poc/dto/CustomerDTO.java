package com.cloudsherpas.poc.dto;

import com.cloudsherpas.poc.util.JodaDateTimeDeserializer;
import com.cloudsherpas.poc.util.JodaDateTimeSerializer;
import com.google.appengine.repackaged.org.codehaus.jackson.map.annotate.JsonDeserialize;
import com.google.appengine.repackaged.org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

public class CustomerDTO {

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonDeserialize(using= JodaDateTimeDeserializer.class)
    public DateTime getDateCreated() {
        return dateCreated;
    }

    @JsonSerialize(using= JodaDateTimeSerializer.class)
    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
