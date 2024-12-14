package com.example.contract.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reviews")
public interface ReviewController {

    @GetMapping("/list")
    String listReviews(Model model);

    @GetMapping("/{id}")
    String viewReview(
            @PathVariable("id") String id,
            Model model
    );
}
