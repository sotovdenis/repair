package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.repositories.ReviewRepo;
import com.example.repairs.services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.reviewRepo = reviewRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }
}
