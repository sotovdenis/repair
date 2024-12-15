//package com.example.repairs.controllers;
//
//import com.example.contract.controllers.ReviewController;
//import com.example.contract.input.ReviewInputModel;
//import com.example.repairs.dto.ReviewDto;
//import com.example.repairs.entities.User;
//import com.example.repairs.services.CartService;
//import com.example.repairs.services.ReviewService;
//import com.example.repairs.services.impl.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//
//@Controller
//@RequestMapping("/review")
//public class ReviewPageControllerImpl implements ReviewController {
//    private final ReviewService reviewService;
//    private final AuthService authService;
//    private final CartService cartService;
//
//    @Autowired
//    public ReviewPageControllerImpl(ReviewService reviewService, AuthService authService, CartService cartService) {
//        this.reviewService = reviewService;
//        this.authService = authService;
//        this.cartService = cartService;
//    }
//
//    @GetMapping("/create")
//    public String createReview(Model model) {
//        model.addAttribute("review", new ReviewInputModel());
//        return "review/create";
//    }
//
//    @Override
//    @PostMapping("/create")
//    public String createReview(String id, Principal principal, Model model, ReviewInputModel review) {
//        String username = principal.getName();
//        User user = authService.getUsers(username);
//
//        ReviewDto reviewDto = new ReviewDto();
//
//        reviewDto.setContent(review.getContent());
//        reviewDto.setRating(review.getRating());
//        reviewDto.setCustomer(user.getId());
//        reviewDto.setRepairPart(id);
//
//        reviewService.addReview(reviewDto);
//
//        model.addAttribute("review", reviewDto);
//        model.addAttribute("username", username);
//        return "review/added";
//    }
//}
