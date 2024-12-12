package com.example.repairs.controllers;

import com.example.repairs.entities.Cart;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.entities.User;
import com.example.repairs.services.CartService;
import com.example.repairs.services.OrderService;
import com.example.repairs.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderPageControllerImpl {
	private final OrderService orderService;
	private final CartService cartService;
	private final AuthService authService;

	@Autowired
	public OrderPageControllerImpl(OrderService orderService, CartService cartService, AuthService authService) {
		this.orderService = orderService;
		this.cartService = cartService;
		this.authService = authService;
	}

	@GetMapping("/user")
	public String orderPage(Model model, Principal principal) {
		String username = principal.getName();
		User user = authService.getUser(username);

		var carts = cartService.findByUserId(user.getId());
		List<RepairParts> repairPartsList = carts.stream().map(Cart::getRepairPartsId).toList();

		double totalPrice = 0d;
		for (RepairParts r : repairPartsList) {
			totalPrice += r.getPrice();
		}

		var orders = orderService.getAllByUser(user.getId());

		model.addAttribute("user", user);
		model.addAttribute("total", totalPrice);
		model.addAttribute("orders", orders);

		return "order/orders";

	}

}
