package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.OrderDto;
import com.example.repairs.entities.Order;
import com.example.repairs.entities.User;
import com.example.repairs.repositories.CustomerRepo;
import com.example.repairs.repositories.OrderRepo;
import com.example.repairs.repositories.RepairPartsRepo;
import com.example.repairs.repositories.UserRepository;
import com.example.repairs.services.OrderService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	private final OrderRepo orderRepo;
	private final CustomerRepo customerRepo;
	private final RepairPartsRepo repairPartsRepo;
	private final ValidationUtil validationUtil;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public OrderServiceImpl(OrderRepo orderRepo, CustomerRepo customerRepo, RepairPartsRepo repairPartsRepo, ValidationUtil validationUtil, UserRepository userRepository, ModelMapper modelMapper) {
		this.orderRepo = orderRepo;
		this.customerRepo = customerRepo;
		this.repairPartsRepo = repairPartsRepo;
		this.validationUtil = validationUtil;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void addOrder(OrderDto orderDto) {
		if (!this.validationUtil.isValid(orderDto)) {
			this.validationUtil.violations(orderDto)
					.stream()
					.map(ConstraintViolation::getMessage)
					.forEach(System.out::println);
		} else {
			Order order = new Order(userRepository.findById(orderDto.getUser()),
					repairPartsRepo.findById(orderDto.getRepairPart()),
					repairPartsRepo.findById(orderDto.getRepairPart()).getPrice(),
					"payed",
					new Timestamp(System.currentTimeMillis()));
			this.orderRepo.save(order);
		}
	}

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public List<Order> getAllByUser(String userId) {
		return orderRepo.getAllByUserId(userId);
	}

	@Override
	public Order findById(String id) {
		return orderRepo.findById(id);
	}

}
