package com.example.repairs.services;

import com.example.repairs.dto.ReviewDto;
import com.example.repairs.entities.Review;

import java.util.List;

public interface ReviewService {
    void addReview(ReviewDto reviewDto);

    void deleteReview(String id);

    List<Review> findAll();

    Review findById(String id);

    void updateReviewById(String id, ReviewDto reviewDto);

    List<ReviewDto> findAllByCategoryName(String categoryName);

    List<Review> findAllByRepairName(String name);
}
