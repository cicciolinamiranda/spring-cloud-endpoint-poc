package com.cloudsherpas.poc.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Order {

    @Id
    private String id;
    @Parent
    private Key<Customer> owner;
    private String productId;
    private int noOfItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Key<Customer> getOwner() {
        return owner;
    }

    public void setOwner(Key<Customer> owner) {
        this.owner = owner;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductName() {
        this.productId = productId;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems() {
        this.noOfItems = noOfItems;
    }
}
