package com.example.repairs.repositories.impl;

import com.example.repairs.entities.Cart;
import com.example.repairs.repositories.CartRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl extends BaseCRUDRepo<Cart> implements CartRepo {
	public CartRepositoryImpl() {
		super(Cart.class);
	}
}
