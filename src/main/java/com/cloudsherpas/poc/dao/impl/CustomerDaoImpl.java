package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.CustomerDao;
import com.cloudsherpas.poc.dao.DaoManager;
import com.cloudsherpas.poc.model.Customer;
import com.googlecode.objectify.Objectify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    private static final DaoManager DAO_MANAGER = DaoManager.getInstance();

    @Override
    public List<Customer> getAll() {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        List<Customer> customers = ofy.load().type(Customer.class).list();
        return customers;
    }
}
