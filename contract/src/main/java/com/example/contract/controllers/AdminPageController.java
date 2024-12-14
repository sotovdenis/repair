package com.example.contract.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface AdminPageController extends BaseController {

	@GetMapping
	String admin();

	@GetMapping("/cars")
	String viewAllCars(Model model);

	@GetMapping("/cars/create")
	String createCarForm(Model model);

	@GetMapping("/categories")
	String viewAllCategories(Model model);

	@GetMapping("/categories/create")
	String createCategoryForm(Model model);

	@GetMapping("/repair")
	String viewAllRepairParts(Model model);

	@GetMapping("/repair/create")
	String createRepairPartForm(Model model);

}
