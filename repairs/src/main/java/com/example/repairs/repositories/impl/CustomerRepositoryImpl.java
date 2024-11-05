package com.example.repairs.repositories.impl;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.Customer;
import com.example.repairs.repositories.CustomerRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;

import jakarta.persistence.TypedQuery;
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

    @Override
    public Customer findByLogin(String login) {
        String jpql = "SELECT c FROM Customer c WHERE c.login = :login";
        TypedQuery<Customer> query = super.getEntityManager().createQuery(jpql, Customer.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

}
