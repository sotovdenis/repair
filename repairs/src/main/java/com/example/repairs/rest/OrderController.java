package com.example.repairs.rest;

import com.example.repairs.dto.OrderDto;
import com.example.repairs.entities.Order;
import com.example.repairs.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    void addOrder(OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @GetMapping("/all")
    List<Order> findAll() {
        return  orderService.findAll();
    }

}
