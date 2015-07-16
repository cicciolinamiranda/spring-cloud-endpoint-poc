package com.cloudsherpas.poc.dto;

import java.util.List;

public class OrderListDTO {
    private List<OrderDTO> items;

    public List<OrderDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderDTO> items) {
        this.items = items;
    }
}
