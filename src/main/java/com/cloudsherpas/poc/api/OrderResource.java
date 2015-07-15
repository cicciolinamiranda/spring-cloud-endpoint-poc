package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.OrderDTO;
import com.cloudsherpas.poc.service.OrderService;
import com.cloudsherpas.poc.util.JsonConversionUtility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.appengine.repackaged.com.google.api.client.json.Json;
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
    public void addOrders(final String requestJson) {
        final List<OrderDTO> orderDTOList = JsonConversionUtility.convertJsonToObject(requestJson,
                new TypeReference<List<OrderDTO>>() {
                });

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
    public void updateAllOrders(final String requestJson) {
        final List<OrderDTO> orderDTOList = JsonConversionUtility.convertJsonToObject(requestJson,
                new TypeReference<List<OrderDTO>>() {
                });

        orderService.updateAllOrders(orderDTOList);
    }

    @ApiMethod(
            name = "deleteOrder",
            path = "order/{key}",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteOrder(@Named("key") final String key) {
        orderService.deleteOrder(key);
    }
}
