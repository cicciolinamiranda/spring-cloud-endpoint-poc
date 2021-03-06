package com.cloudsherpas.poc.service;

import com.cloudsherpas.poc.dao.DaoManager;
import com.cloudsherpas.poc.dao.OrderDao;
import com.cloudsherpas.poc.dao.ProductDao;
import com.cloudsherpas.poc.dao.impl.OrderDaoImpl;
import com.cloudsherpas.poc.dto.OrderDTO;
import com.cloudsherpas.poc.model.Order;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.VoidWork;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    @Autowired
    @Qualifier("orderDao")
    @Lazy
    private OrderDao orderDao;

    @Autowired
    @Qualifier("productDao")
    @Lazy
    private ProductDao productDao;

    private ModelMapper modelMapper;

    private Objectify objectify;

    public OrderService() {
        modelMapper = new ModelMapper();
        objectify = DaoManager.getInstance().getObjectify();
    }

    public OrderDTO getOrder(final Long key) {
        Order order = orderDao.get(key);

        return modelMapper.map(order, OrderDTO.class);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orderList = orderDao.getAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order order : orderList) {
            orderDTOList.add(modelMapper.map(order, OrderDTO.class));
        }

        return orderDTOList;
    }

    public void addUpdateOrder(final OrderDTO orderDTO) {
        objectify.transact(new VoidWork() {
            @Override
            public void vrun() {
                orderDao.put(modelMapper.map(orderDTO, Order.class));
                productDao.decreaseStock(orderDTO.getProductId(), orderDTO.getNoOfItems());
            }
        });
    }

    public void addUpdateOrders(final List<OrderDTO> orderDTOList) {
        for (OrderDTO orderDTO : orderDTOList) {
            addUpdateOrder(orderDTO);
        }
    }

    public void deleteOrder(final Long key) {
        final Order order = orderDao.get(key);

        objectify.transact(new VoidWork() {
            @Override
            public void vrun() {
                orderDao.delete(key);
                productDao.increaseStock(order.getProductId(), order.getNoOfItems());
            }
        });
    }
}
