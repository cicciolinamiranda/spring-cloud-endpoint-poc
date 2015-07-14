package com.cloudsherpas.poc.dao.impl;

import com.cloudsherpas.poc.dao.DaoManager;
import com.cloudsherpas.poc.dao.OrderDao;
import com.cloudsherpas.poc.model.Order;
import com.googlecode.objectify.Objectify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

    private static final DaoManager DAO_MANAGER = DaoManager.getInstance();

    @Override
    public List<Order> getAll() {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        List<Order> orders = ofy.load().type(Order.class).list();
        return orders;
    }
}
