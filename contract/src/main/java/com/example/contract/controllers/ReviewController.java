package com.example.contract.controllers;

import com.example.contract.input.ReviewInputModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

public interface ReviewController {

    String createReview(@PathVariable String id, Principal principal, Model model, ReviewInputModel review);
}
