package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.repositories.OrderRepo;
import com.example.repairs.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.orderRepo = orderRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }
}
