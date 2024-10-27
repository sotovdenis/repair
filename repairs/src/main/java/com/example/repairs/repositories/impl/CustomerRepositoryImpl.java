package com.example.repairs.repositories.impl;

import com.example.repairs.entities.Customer;
import com.example.repairs.repositories.CustomerRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends BaseCRUDRepo<Customer> implements CustomerRepo {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    public void doSomething() {
        System.out.println("Hello");
    }

}
