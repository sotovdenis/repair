package com.example.repairs.services;

import com.example.repairs.dto.CustomerDto;
import com.example.repairs.entities.Customer;
import org.springframework.stereotype.Service;

public interface CustomerService {
    void addCustomer(CustomerDto customer);
    void updateCustomerByLogin(String login, String newLogin);
    Customer findCustomerByLogin(String login);
}
