package com.example.repairs.repositories.impl;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.Customer;
import com.example.repairs.repositories.CustomerRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

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
