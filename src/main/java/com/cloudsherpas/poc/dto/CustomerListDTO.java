package com.cloudsherpas.poc.dto;

import java.util.List;

public class CustomerListDTO {

    private List<CustomerDTO> items;

    public List<CustomerDTO> getItems() {
        return items;
    }

    public void setItems(List<CustomerDTO> items) {
        this.items = items;
    }
}
