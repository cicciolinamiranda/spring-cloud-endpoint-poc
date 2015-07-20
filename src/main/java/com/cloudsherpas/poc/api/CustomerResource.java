package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.CustomerDTO;
import com.cloudsherpas.poc.dto.CustomerListDTO;
import com.cloudsherpas.poc.service.CustomerService;
import com.cloudsherpas.poc.util.GenericEndpointErrorResponse;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(
        name = "poc",
        version = "v1",
        description = "Sample API for Google Cloud Endpoints - Spring Framework POC"
)
public class CustomerResource {

    @Autowired
    @Qualifier("customerService")
    @Lazy
    private CustomerService customerService;

    @ApiMethod(
            name = "getCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public CustomerDTO getCustomer(@Named("id") final Long key) throws NotFoundException {

        final CustomerDTO customer = customerService.getCustomer(key);

        if (customer == null) {
            GenericEndpointErrorResponse.entityNotFound();
        }

        return customer;
    }

    @ApiMethod(
            name = "getAllCustomers",
            path = "customers/all",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiMethod(
            name = "addUpdateCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public Map<String, Long> addUpdateCustomer(final CustomerDTO customerDTO) {
        final Long key = customerService.addUpdateCustomer(customerDTO);
        final Map<String, Long> result = new HashMap<>();

        if (key != null){
            result.put("key", key);
        }

        return result;
    }

    @ApiMethod(
            name = "addUpdateCustomers",
            path = "customers",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public List<CustomerDTO> addCustomers(final CustomerListDTO customerList) {
        return customerService.addUpdateCustomers(customerList.getItems());
    }

    @ApiMethod(
            name = "deleteCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteCustomer(@Named("id") final Long key) {
        customerService.deleteCustomer(key);
    }
}
