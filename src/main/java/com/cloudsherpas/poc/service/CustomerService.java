package com.cloudsherpas.poc.service;

import com.cloudsherpas.poc.dao.CustomerDao;
import com.cloudsherpas.poc.dto.CustomerDTO;
import com.cloudsherpas.poc.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    @Autowired()
    @Qualifier("customerDao")
    @Lazy
    private CustomerDao customerDao;

    private ModelMapper modelMapper;

    public CustomerService() {
        modelMapper = new ModelMapper();
    }

    public CustomerDTO getCustomer(final Long key) {
        CustomerDTO result = null;
        Customer customer =  customerDao.get(key);

        if (customer != null){
            result = modelMapper.map(customer, CustomerDTO.class);
        }

        return result;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerDao.getAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customerList) {
            customerDTOList.add(modelMapper.map(customer, CustomerDTO.class));
        }

        return customerDTOList;
    }

    public Long addUpdateCustomer(final CustomerDTO customerDTO) {
        return customerDao.put(modelMapper.map(customerDTO, Customer.class));
    }

    public List<CustomerDTO> addUpdateCustomers(final List<CustomerDTO> customerDTOList) {
        final List<Customer> customerList = new ArrayList<>();

        for (CustomerDTO customerDTO : customerDTOList) {
            customerList.add(modelMapper.map(customerDTO, Customer.class));
        }

        final List<Customer> tmpList = customerDao.putAll(customerList);

        final List<CustomerDTO> customerRespList = new ArrayList<>();
        if (tmpList != null){
            for (Customer tmpCust : tmpList) {
                customerRespList.add(modelMapper.map(tmpCust, CustomerDTO.class));
            }
        }

        return customerRespList;
    }

    public void deleteCustomer(final Long key) {
        customerDao.delete(key);
    }
}
