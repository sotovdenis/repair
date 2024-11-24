package com.example.repairs.services;

import com.example.repairs.dto.CustomerDto;
import com.example.repairs.dto.RenameCustomerDto;
import com.example.repairs.entities.Category;
import com.example.repairs.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDto customer);
    void updateCustomerLoginById(RenameCustomerDto renameCustomerDto);
    List<Customer> findAll();
    void updateCustomerById(String id, CustomerDto customerDto);
    CustomerDto getCustomerById(String id);
}
