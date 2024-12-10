package com.example.repairs.services;

import com.example.repairs.dto.CartDto;
import com.example.repairs.entities.Cart;

import java.util.List;

public interface CartService {
	void addCart(CartDto cartDto);
	void deleteCartById(String id);
	Cart findCartById(String id);
	List<Cart> findAll();
}
