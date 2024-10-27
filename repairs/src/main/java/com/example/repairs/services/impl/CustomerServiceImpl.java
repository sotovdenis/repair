package com.example.repairs.services.impl;

import com.example.repairs.entities.Customer;
import com.example.repairs.repositories.CustomerRepo;
import com.example.repairs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }
}
