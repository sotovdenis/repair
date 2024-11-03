package com.example.repairs.services;

import com.example.repairs.entities.Customer;
import org.springframework.stereotype.Service;

public interface CustomerService {
    void addCustomer(Customer customer);
    void updateCustomerById(String id);
    void findCustomerById(String id);
}
