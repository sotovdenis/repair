package com.example.repairs.services.impl;

import com.example.repairs.dto.CartDto;
import com.example.repairs.entities.Cart;
import com.example.repairs.repositories.CartRepo;
import com.example.repairs.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	private CartRepo cartRepo;
	private ModelMapper modelMapper;

	@Override
	public void addCart(CartDto cartDto) {
		cartRepo.save(modelMapper.map(cartDto, Cart.class));
	}

	@Override
	public void deleteCartById(String id) {
		cartRepo.delete(cartRepo.findById(id));
	}

	@Override
	public Cart findCartById(String id) {
		return cartRepo.findById(id);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepo.findAll();
	}

	@Override
	public void add(Cart cart) {
		cartRepo.save(cart);
	}

	@Override
	public List<Cart> findByUserId(String currentUserID) {
		return cartRepo.findAll().stream().filter(e -> e.getUserId().getId().equals(currentUserID)).toList();
	}

	@Autowired
	public void setCartRepo(CartRepo cartRepo) {
		this.cartRepo = cartRepo;
	}

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
}
