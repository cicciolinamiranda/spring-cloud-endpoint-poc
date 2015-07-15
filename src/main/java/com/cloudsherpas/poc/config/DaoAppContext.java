package com.cloudsherpas.poc.config;

import com.cloudsherpas.poc.dao.CustomerDao;
import com.cloudsherpas.poc.dao.OrderDao;
import com.cloudsherpas.poc.dao.ProductDao;
import com.cloudsherpas.poc.dao.impl.CustomerDaoImpl;
import com.cloudsherpas.poc.dao.impl.OrderDaoImpl;
import com.cloudsherpas.poc.dao.impl.ProductDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class DaoAppContext {

    @Bean(name="customerDao")
    public CustomerDao getCustomerDao(){
        return new CustomerDaoImpl();
    }

    @Bean(name="orderDao")
    public OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }

    @Bean(name="productDao")
    public ProductDao getProductDao(){
        return new ProductDaoImpl();
    }
}
