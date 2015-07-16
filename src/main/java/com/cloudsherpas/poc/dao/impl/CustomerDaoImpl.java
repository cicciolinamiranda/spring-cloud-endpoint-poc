package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.CustomerDao;
import com.cloudsherpas.poc.model.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    public CustomerDaoImpl() {
        super(Customer.class);
    }
}
