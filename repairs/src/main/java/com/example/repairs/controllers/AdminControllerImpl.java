package com.example.repairs.controllers;

import com.example.contract.controllers.AdminPageController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.repairs.dto.*;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.Category;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminPageController {
	@Override
	public BaseViewModel createBaseViewModel(String title) {
		return new BaseViewModel(
				title
		);
	}

	private final CarsInfoService carsInfoService;
	private final CategoryService categoryService;
	private final CustomerService customerService;
	private final OrderService orderService;
	private final RepairPartsService repairPartsService;
	private final ReviewService reviewService;

	@Autowired
	public AdminControllerImpl(CarsInfoService carsInfoService, CategoryService categoryService,
	                           CustomerService customerService, OrderService orderService,
	                           RepairPartsService repairPartsService, ReviewService reviewService) {
		this.carsInfoService = carsInfoService;
		this.categoryService = categoryService;
		this.customerService = customerService;
		this.orderService = orderService;
		this.repairPartsService = repairPartsService;
		this.reviewService = reviewService;
	}

	@GetMapping
	public String admin() {
		return "admin/admin";
	}

	@GetMapping("/cars")
	public String viewAllCars(Model model) {
		model.addAttribute("cars", carsInfoService.findAll());
		return "cars/table";
	}

	@GetMapping("/cars/create")
	public String createCarForm(Model model) {
		model.addAttribute("carDto", new CarDto());
		return "cars/create";
	}

	@PostMapping("/cars/create")
	public String createCar(@ModelAttribute("carDto") CarDto carDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/admin/cars/create";
		}
		carsInfoService.addCarInfo(carDto.getBrandName(), carDto.getVin());
		return "redirect:/admin/cars";
	}


	@GetMapping("/categories")
	public String viewAllCategories(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "categories/table";
	}

	@GetMapping("/categories/create")
	public String createCategoryForm(Model model) {
		model.addAttribute("categoryDto", new CategoryDto());
		model.addAttribute("cars", carsInfoService.findAll());
		return "categories/create";
	}

	@PostMapping("/categories/create")
	public String createCategory(@ModelAttribute("categoryDto")
	                                 CategoryDto categoryDto,
	                             BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("cars", carsInfoService.findAll());
			return "categories/create";
		}

		categoryService.addCategory(categoryDto);
		return "redirect:/admin/categories";
	}


	@GetMapping("/repair")
	public String viewAllRepairParts(Model model) {
		model.addAttribute("repair", repairPartsService.findAll());
		return "repair/table";
	}

	@GetMapping("/repair/create")
	public String createRepairPartForm(Model model) {
		model.addAttribute("repairPartsDto", new RepairPartsDto());
		model.addAttribute("categories", categoryService.findAll());
		return "repair/create";
	}

	@PostMapping("/repair/create")
	public String createRepairPart(@ModelAttribute("repairPartsDto") RepairPartsDto repairPartsDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("categories", categoryService.findAll());
			return "repair/create";
		}

		repairPartsService.addRepairPart(repairPartsDto);

		return "redirect:/admin/repair";
	}
}
