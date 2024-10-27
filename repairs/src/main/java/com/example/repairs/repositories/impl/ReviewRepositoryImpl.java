package com.example.repairs.repositories.impl;

import com.example.repairs.entities.Review;
import com.example.repairs.repositories.ReviewRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl extends BaseCRUDRepo<Review> implements ReviewRepo {
    public ReviewRepositoryImpl() {
        super(Review.class);
    }
}
