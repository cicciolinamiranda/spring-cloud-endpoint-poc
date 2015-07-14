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

    private DaoManager() {
    }

    public static DaoManager getInstance() {
        if (self == null) {
            self = new DaoManager();
        }

        return self;
    }

    private static void registerEntities() {
        ObjectifyService.begin();

        ObjectifyService.factory().register(Customer.class);
        ObjectifyService.factory().register(Order.class);
        ObjectifyService.factory().register(Product.class);
    }

    public Objectify getObjectify() {
        return ObjectifyService.ofy();
    }




}
