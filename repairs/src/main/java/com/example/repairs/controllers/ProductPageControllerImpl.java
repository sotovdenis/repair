package com.example.repairs.controllers;

import com.example.contract.controllers.ProductController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProductViewModel;
import com.example.contract.viewmodel.parts.ReviewViewModel;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.services.CartService;
import com.example.repairs.services.CategoryService;
import com.example.repairs.services.RepairPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductPageControllerImpl implements ProductController {

	private RepairPartsService repairPartsService;
	private CartService cartService;
	private CategoryService categoryService;

	@Autowired
	public ProductPageControllerImpl(RepairPartsService repairPartsService, CartService cartService, CategoryService categoryService) {
		this.repairPartsService = repairPartsService;
		this.cartService = cartService;
		this.categoryService = categoryService;
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
}
