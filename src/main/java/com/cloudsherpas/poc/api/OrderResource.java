package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.OrderDTO;
import com.cloudsherpas.poc.service.OrderService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
public class OrderResource {
    private OrderService orderService;

    public OrderResource() {
        orderService = new OrderService();
    }

    @ApiMethod(
            name = "getOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public OrderDTO getOrder(@Named("orderKey") final String key) {
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
            name = "addOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addOrder(final OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
    }

    @ApiMethod(
            name = "addOrders",
            path = "orders",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addOrders(final List<OrderDTO> orderDTOList) {
        orderService.addOrders(orderDTOList);
    }

    @ApiMethod(
            name = "updateOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateOrder(final OrderDTO orderDTO) {
        orderService.updateOrder(orderDTO);
    }


    @ApiMethod(
            name = "updateAllOrders",
            path = "orders/all",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateAllOrders(final List<OrderDTO> orderDTOList) {
        orderService.updateAllOrders(orderDTOList);
    }

    @ApiMethod(
            name = "deleteOrder",
            path = "order",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteOrder(final String key) {
        orderService.deleteOrder(key);
    }
}
