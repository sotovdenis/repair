package com.example.repairs.controllers;

import com.example.repairs.dto.OrderDto;
import com.example.repairs.entities.Cart;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.entities.User;
import com.example.repairs.services.CartService;
import com.example.repairs.services.OrderService;
import com.example.repairs.services.RepairPartsService;
import com.example.repairs.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartPageControllerImpl {

	private final CartService cartService;
	private final OrderService orderService;
	private final RepairPartsService repairPartsService;
	private final AuthService authService;

	@Autowired
	public CartPageControllerImpl(CartService cartService,
	                              OrderService orderService,
	                              RepairPartsService repairPartsService,
	                              AuthService authService) {
		this.cartService = cartService;
		this.orderService = orderService;
		this.repairPartsService = repairPartsService;
		this.authService = authService;
	}

	@GetMapping("/user")
	public String listProducts(Model model, Principal principal) {

		String username = principal.getName();
		User user = authService.getUser(username);

		List<Cart> carts = cartService.findByUserId(user.getId());

		if (carts.isEmpty()) {
			model.addAttribute("message", "Ваша корзина пуста.");
			return "cart/cart";
		}

		List<RepairParts> repairPartsList = carts.stream().map(Cart::getRepairPartsId).collect(Collectors.toList());

		double totalPrice = 0d;
		for (RepairParts r : repairPartsList) {
			totalPrice += r.getPrice();
		}

		model.addAttribute("total", totalPrice);
		model.addAttribute("repairPartsList", repairPartsList);
		model.addAttribute("user", user);

		return "cart/cart";
	}

	@PostMapping("/user")
	public String order(Model model,
	                    Principal principal) {
		String username = principal.getName();
		User user = authService.getUser(username);

		List<Cart> carts = cartService.findByUserId(user.getId());

		for (Cart cart : carts) {
			OrderDto orderDto = new OrderDto();
			orderDto.setUser(cart.getUserId().getId());
			orderDto.setRepairPart(cart.getRepairPartsId().getId());
			orderService.addOrder(orderDto);
		}

		model.addAttribute("order", orderService.getAllByUser(user.getId()));

		return "order/create";
	}
}
