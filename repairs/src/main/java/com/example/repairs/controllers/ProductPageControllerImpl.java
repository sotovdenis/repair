package com.example.repairs.controllers;

import com.example.contract.controllers.ProductController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProductViewModel;
import com.example.contract.viewmodel.parts.ReviewViewModel;
import com.example.repairs.dto.CartDto;
import com.example.repairs.dto.CategoryDto;
import com.example.repairs.dto.ReviewDto;
import com.example.repairs.entities.Cart;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.entities.Review;
import com.example.repairs.entities.User;
import com.example.repairs.services.CartService;
import com.example.repairs.services.CategoryService;
import com.example.repairs.services.RepairPartsService;
import com.example.repairs.services.ReviewService;
import com.example.repairs.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductPageControllerImpl implements ProductController {

	private RepairPartsService repairPartsService;
	private CartService cartService;
	private CategoryService categoryService;
	private ReviewService reviewService;
	private AuthService authService;

	@Autowired
	public ProductPageControllerImpl(RepairPartsService repairPartsService, CartService cartService,
	                                 CategoryService categoryService, ReviewService reviewService, AuthService authService) {
		this.repairPartsService = repairPartsService;
		this.cartService = cartService;
		this.categoryService = categoryService;
		this.reviewService = reviewService;
		this.authService = authService;
	}

	@Override
	public BaseViewModel createBaseViewModel(String title) {
		return new BaseViewModel(
				title
		);
	}

	@Override
	@GetMapping("/{name}")
	public String viewRepairDetail(@PathVariable String name,
	                               Model model,
	                               ProductViewModel productViewModel) {

		RepairParts repairParts = repairPartsService.findByName(name);
		List<Review> reviews = reviewService.findAllByRepairName(name);

		// Установите детали продукта
		productViewModel.setDescription(repairParts.getDescription());
		productViewModel.setName(repairParts.getName());
		productViewModel.setBrandName(categoryService.findById(repairParts.getCategory().getId()).getBrand());
		productViewModel.setPicture("url");
		productViewModel.setPrice(repairParts.getPrice());

		// Создайте новый список для отзывов
		List<ReviewViewModel> reviewViewModel = new ArrayList<>();

		// Преобразуйте каждый отзыв в ReviewViewModel
		for (Review review : reviews) {
			ReviewViewModel reviewView = new ReviewViewModel(review.getContent(), review.getRating());
			reviewViewModel.add(reviewView);
		}

		// Добавьте заполненные списки в модель
		model.addAttribute("review", reviewViewModel);
		model.addAttribute("product", productViewModel);

		return "product/view";
	}


	@GetMapping("/p/{categoryName}")
	public String getRepairPartsByCategory(@PathVariable String categoryName, Model model) {
		List<RepairParts> repairParts = repairPartsService.getByCategoryName(categoryName);

		model.addAttribute("repairParts", repairParts);
		model.addAttribute("product", repairParts);

		return "product/products";

	}

//	@PostMapping("/add")
//	public String addToCart(Principal principal, String repairPartsId, RedirectAttributes redirectAttributes) {
//		String username = principal.getName();
//		User user = authService.getUserId(username);
//
//		CartDto cartDto = new CartDto(user.getId(), repairPartsId);
//
//		RepairParts repairParts = repairPartsService.findById(cartDto.getRepairPartsId());
//
//		cartService.addCart(cartDto);
//
//		redirectAttributes.addFlashAttribute("message", "Товар добавлен в корзину!");
//
//		return "redirect:product/products";
//	}


//	@GetMapping("/add/{name}")
//	public String add(Model model, @PathVariable String name) {
//		RepairParts repairParts = repairPartsService.findByName(name);
//
//		model.addAttribute("return", repairParts);
//		return "cart/added";
//	}
//
	@PostMapping("/add/{name}")
	public String addToCart(@PathVariable String name,
			Model model,
			Principal principal) {
		String username = principal.getName();
		User user = authService.getUser(username);

//		CartDto cartDto = new CartDto(user.getId(), repairPartsService.findByName(name).getId());
		Cart cart = new Cart(user, repairPartsService.findByName(name));
		RepairParts out = repairPartsService.findByName(name);

//		cartDto.setUserId(user.getId());


		model.addAttribute("return", out);
		cartService.add(cart);
		return "cart/added";
	}
}

