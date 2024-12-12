package com.example.repairs.services;

import com.example.repairs.dto.OrderDto;
import com.example.repairs.entities.Order;

import java.util.List;

public interface OrderService {
    void addOrder(OrderDto orderDto);
    List<Order> findAll();
    List<Order> getAllByUser(String userId);
}
