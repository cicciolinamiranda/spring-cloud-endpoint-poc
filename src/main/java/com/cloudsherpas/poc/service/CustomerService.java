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

    public CustomerDTO getCustomer(final String key) {
        CustomerDTO result = null;

        Customer customer =  customerDao.get(key);

        if (customer != null){
            modelMapper.map(customer, CustomerDTO.class);
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

    public void addCustomer(final CustomerDTO customerDTO) {
        customerDao.add(modelMapper.map(customerDTO, Customer.class));
    }

    public void addCustomers(final List<CustomerDTO> customerDTOList) {
        List<Customer> customerList = new ArrayList<>();

        for (CustomerDTO customerDTO : customerDTOList) {
            customerList.add(modelMapper.map(customerDTO, Customer.class));
        }

        customerDao.addAll(customerList);
    }

    public void updateCustomer(final CustomerDTO customerDTO) {
        customerDao.update(modelMapper.map(customerDTO, Customer.class));
    }

    public void updateAllCustomers(final List<CustomerDTO> customerDTOList) {
        List<Customer> customerList = new ArrayList<>();

        for (CustomerDTO customerDTO : customerDTOList) {
            customerList.add(modelMapper.map(customerDTO, Customer.class));
        }

        customerDao.updateAll(customerList);
    }

    public void deleteCustomer(final String key) {
        customerDao.delete(key);
    }
}
