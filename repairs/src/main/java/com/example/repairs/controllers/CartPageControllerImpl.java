package com.example.repairs.controllers;

import com.example.contract.controllers.CartPageController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.repairs.entities.Cart;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.services.CartService;
import com.example.repairs.services.RepairPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartPageControllerImpl implements CartPageController {

	private final CartService cartService;


	@Autowired
	public CartPageControllerImpl(CartService cartService) {
		this.cartService = cartService;
	}

	@Override
	public BaseViewModel createBaseViewModel(String title) {
		return new BaseViewModel(
				title
		);
	}

	@Override
	public String listProducts(Model model) {

		List<Cart> carts = cartService.findAll();

		if (carts.isEmpty()) {
			model.addAttribute("message", "???");
		}

		return "cart";
	}
}
