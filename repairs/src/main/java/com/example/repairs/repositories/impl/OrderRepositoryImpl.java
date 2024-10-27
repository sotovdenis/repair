package com.example.repairs.repositories.impl;

import com.example.repairs.entities.Order;
import com.example.repairs.repositories.OrderRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends BaseCRUDRepo<Order> implements OrderRepo {
    public OrderRepositoryImpl() {
        super(Order.class);
    }
}
