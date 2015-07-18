package com.cloudsherpas.poc.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Order {

    @Id
    private Long id;
    @Parent
    private Key<Customer> owner;
    private Long productId;
    private int noOfItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Key<Customer> getOwner() {
        return owner;
    }

    public void setOwner(Key<Customer> owner) {
        this.owner = owner;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems() {
        this.noOfItems = noOfItems;
    }
}
