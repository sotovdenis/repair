package com.example.repairs.controllers;

import com.example.contract.controllers.ProductController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProductViewModel;
import com.example.contract.viewmodel.parts.ReviewViewModel;
import com.example.repairs.dto.CartDto;
import com.example.repairs.dto.ReviewDto;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.entities.Review;
import com.example.repairs.entities.User;
import com.example.repairs.services.CartService;
import com.example.repairs.services.CategoryService;
import com.example.repairs.services.RepairPartsService;
import com.example.repairs.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductPageControllerImpl implements ProductController {

	private RepairPartsService repairPartsService;
	private CartService cartService;
	private CategoryService categoryService;
	private ReviewService reviewService;

	@Autowired
	public ProductPageControllerImpl(RepairPartsService repairPartsService, CartService cartService, CategoryService categoryService, ReviewService reviewService) {
		this.repairPartsService = repairPartsService;
		this.cartService = cartService;
		this.categoryService = categoryService;
		this.reviewService = reviewService;
	}

	@Override
	public BaseViewModel createBaseViewModel(String title) {
		return new BaseViewModel(
				title
		);
	}

	@Override
	@GetMapping("/{id}")
	public String viewRepairDetail(@PathVariable String id,
	                               Model model,
	                               ReviewViewModel reviewViewModel,
	                               ProductViewModel productViewModel) {
		RepairParts repairParts = repairPartsService.findById(id);

		productViewModel.setDescription(repairParts.getDescription());
		productViewModel.setName(repairParts.getName());
		productViewModel.setBrandName(categoryService.findById(repairParts.getCategory().getId()).getBrand());
		productViewModel.setPicture("url");
		productViewModel.setPrice(repairParts.getPrice());

		model.addAttribute("review", reviewViewModel);
		model.addAttribute("product", productViewModel);

		return "product/view";

	}

	@GetMapping("/p/{categoryName}")
	public String getRepairPartsByCategory(@PathVariable String categoryName, Model model) {
		List<RepairParts> repairParts = repairPartsService.getByCategoryName(categoryName);

		model.addAttribute("repairParts", repairParts);

		return "product/products";

	}

	@PostMapping("/add")
	public String addToCart(@RequestParam String repairPartsId, @AuthenticationPrincipal User currentUser) {
		CartDto cartDto = new CartDto(currentUser.getId(), repairPartsId);
		cartService.addCart(cartDto);

		return "redirect:/p/" + repairPartsId;
	}
}

