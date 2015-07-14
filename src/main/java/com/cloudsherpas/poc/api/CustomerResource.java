package com.cloudsherpas.poc.api;

import com.cloudsherpas.poc.dto.CustomerDTO;
import com.cloudsherpas.poc.model.Customer;
import com.cloudsherpas.poc.service.CustomerService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;

@Api(
        name = "poc",
        version = "1"
)
@Component
public class CustomerResource {

    @Autowired
    @Qualifier("customerService")
    @Lazy
    private CustomerService customerService;

    public CustomerResource() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        ObjectifyService.begin();
    }

    @ApiMethod(
            name = "getCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.GET
    )
    public CustomerDTO getCustomer(@Named("customerKey") final String key) {
        return customerService.getCustomer(key);
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
            name = "addCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void addCustomer(final CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
    }

//    @ApiMethod(
//            name = "addCustomers",
//            path = "customers",
//            httpMethod = ApiMethod.HttpMethod.POST
//    )
//    public void addCustomers(final List<CustomerDTO> customerDTOList) {
//        customerService.addCustomers(customerDTOList);
//    }

    @ApiMethod(
            name = "updateCustomer",
            path = "customer",
            httpMethod = ApiMethod.HttpMethod.PUT
    )
    public void updateCustomer(final CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
    }

//    @ApiMethod(
//            name = "updateAllCustomers",
//            path = "customers/all",
//            httpMethod = ApiMethod.HttpMethod.PUT
//    )
//    public void updateCustomers(final List<CustomerDTO> customerDTOList) {
//        customerService.updateAllCustomers(customerDTOList);
//    }

    @ApiMethod(
            name = "deleteCustomer",
            path = "customer/{key}",
            httpMethod = ApiMethod.HttpMethod.DELETE
    )
    public void deleteCustomer(@Named("key") final String key) {
        customerService.deleteCustomer(key);
    }
}
