package com.example.repairs.controllers;

import com.example.repairs.dto.ReviewDto;
import com.example.repairs.entities.Review;
import com.example.repairs.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DeleteMapping("/delete")
    void deleteReview(String id) {
        reviewService.deleteReview(id);
    }

    @PatchMapping("/refactor")
    void refactorReview(String id, ReviewDto reviewDto) {
        reviewService.updateReviewById(id, reviewDto);
    }

    @GetMapping("/all")
    List<Review> findAll() {
        return reviewService.findAll();
    }

    @RequestMapping("/{id}")
    Review findById(@PathVariable String id) {
        return reviewService.findById(id);
    }

}