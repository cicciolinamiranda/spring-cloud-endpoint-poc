package com.cloudsherpas.poc.service;

import com.cloudsherpas.poc.dao.OrderDao;
import com.cloudsherpas.poc.dao.impl.OrderDaoImpl;
import com.cloudsherpas.poc.dto.OrderDTO;
import com.cloudsherpas.poc.model.Order;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderDao orderDao;
    private ModelMapper modelMapper;

    public OrderService() {
        orderDao = new OrderDaoImpl();
        modelMapper = new ModelMapper();
    }

    public OrderDTO getOrder(final String key) {
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

    public void addOrder(final OrderDTO orderDTO) {
        orderDao.add(modelMapper.map(orderDTO, Order.class));
    }

    public void addOrders(final List<OrderDTO> orderDTOList) {
        List<Order> orderList = new ArrayList<>();

        for (OrderDTO orderDTO : orderDTOList) {
            orderList.add(modelMapper.map(orderDTO, Order.class));
        }

        orderDao.addAll(orderList);
    }

    public void updateOrder(final OrderDTO orderDTO) {
        orderDao.update(modelMapper.map(orderDTO, Order.class));
    }

    public void updateAllOrders(final List<OrderDTO> orderDTOList) {
        List<Order> orderList = new ArrayList<>();

        for (OrderDTO orderDTO : orderDTOList) {
            orderList.add(modelMapper.map(orderDTO, Order.class));
        }

        orderDao.updateAll(orderList);
    }

    public void deleteOrder(final String key) {
        orderDao.delete(key);
    }
}
