package com.cloudsherpas.poc.dao;

import com.cloudsherpas.poc.model.Customer;
import com.cloudsherpas.poc.model.Order;
import com.cloudsherpas.poc.model.Product;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class DaoManager {

    private static DaoManager self;

    static {
        registerEntities();
    }

    private DaoManager(){}

    public DaoManager getInstance() {
        if (self == null){
            self = new DaoManager();
        }

        return self;
    }

    private static void registerEntities(){
        ObjectifyService.register(Customer.class);
        ObjectifyService.register(Order.class);
        ObjectifyService.register(Product.class);
    }

    private Objectify getObjectify(){
        return ObjectifyService.ofy();
    }




}
