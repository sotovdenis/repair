package com.example.repairs.controllers;

import com.example.contract.input.ReviewInputModel;
import com.example.repairs.dto.ReviewDto;
import com.example.repairs.entities.*;
import com.example.repairs.services.CartService;
import com.example.repairs.services.OrderService;
import com.example.repairs.services.RepairPartsService;
import com.example.repairs.services.ReviewService;
import com.example.repairs.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderPageControllerImpl {
    private final OrderService orderService;
    private final CartService cartService;
    private final AuthService authService;
    private final ReviewService reviewService;
    private final RepairPartsService repairPartsService;

    @Autowired
    public OrderPageControllerImpl(OrderService orderService, CartService cartService, AuthService authService, ReviewService reviewService, RepairPartsService repairPartsService) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.authService = authService;
        this.reviewService = reviewService;
        this.repairPartsService = repairPartsService;
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

    @GetMapping("/{id}/review/create")
    public String showReviewForm(@PathVariable String id, Model model) {
        Order orderItem = orderService.findById(id);

        model.addAttribute("orderItem", orderItem);
        model.addAttribute("review", new ReviewInputModel());

        return "review/create";
    }

    @GetMapping("/review/added")
    public String showReviewAddedForm(
//			@PathVariable String id,
//									  Principal principal,
//									  Model model
    ) {
//		String username = principal.getName();
//		User user = authService.getUser(username);
//
//		RepairParts repairParts = repairPartsService.findById(id);
//
//		Review review = reviewService.findAll().stream()
//				.filter(r -> r.getUser().getId().equals(user.getId()))
//				.filter(rep -> rep.getRepairParts().equals(repairParts)).toList().getFirst();

//		model.addAttribute("orderItem", repairParts);
//		model.addAttribute("review", review);

        return "review/added";
    }

    @PostMapping("/{id}/review/create")
    public String createReview(@PathVariable String id,
                               Principal principal,
                               Model model,
                               ReviewInputModel review) {

        String username = principal.getName();
        User user = authService.getUser(username);

        ReviewDto reviewDto = new ReviewDto();

        Review reviewModel = new Review(
                user,
                repairPartsService.findById(id),
                review.getRating(),
                review.getContent(),
                new Timestamp(System.currentTimeMillis())
        );

        reviewDto.setContent(review.getContent());
        reviewDto.setRating(review.getRating());
        reviewDto.setUserId(user.getId());
        System.out.printf("!!!!!!!!!!!!!!!!!!");
        System.out.println(reviewDto.getUserId());
        reviewDto.setRepairPartsId(id);
        System.out.println(reviewDto.getRepairPartsId());
        reviewDto.setDate(String.valueOf(new Timestamp(System.currentTimeMillis())));

        reviewService.addReviewM(reviewModel);

        model.addAttribute("review", reviewModel);

        return "redirect:/review/added";
    }

}
