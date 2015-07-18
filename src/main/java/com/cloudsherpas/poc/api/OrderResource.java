package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.OrderDTO;
import com.cloudsherpas.poc.dto.OrderListDTO;
import com.cloudsherpas.poc.service.OrderService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
public class OrderResource {

    @Autowired
    @Qualifier("orderService")
    @Lazy
    private OrderService orderService;

    @ApiMethod(
            name = "getOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public OrderDTO getOrder(@Named("id") final Long key) {
        return orderService.getOrder(key);
    }

    @ApiMethod(
            name = "getAllOrders",
            path = "orders/all",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @ApiMethod(
            name = "addUpdateOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void addOrder(final OrderDTO orderDTO) {
        orderService.addUpdateOrder(orderDTO);
    }

    @ApiMethod(
            name = "addUpdateOrders",
            path = "orders",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void addOrders(final OrderListDTO orderList) {
        orderService.addUpdateOrders(orderList.getItems());
    }

    @ApiMethod(
            name = "deleteOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteOrder(@Named("id") final Long key) {
        orderService.deleteOrder(key);
    }
}
