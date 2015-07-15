package com.cloudsherpas.poc.config;

import com.cloudsherpas.poc.service.CustomerService;
import com.cloudsherpas.poc.service.OrderService;
import com.cloudsherpas.poc.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class ServiceAppContext {

    @Bean(name="customerService")
    public CustomerService getCustomerService(){
        return new CustomerService();
    }

    @Bean(name="orderService")
    public OrderService getOrderService(){
        return new OrderService();
    }

    @Bean(name="productService")
    public ProductService getProductService(){
        return new ProductService();
    }
}
