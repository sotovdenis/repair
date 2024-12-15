package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.ReviewDto;
import jakarta.validation.ConstraintViolation;
import com.example.repairs.entities.Review;
import com.example.repairs.repositories.ReviewRepo;
import com.example.repairs.services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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

	@Override
	public void addReview(ReviewDto reviewDto) {
		if (!this.validationUtil.isValid(reviewDto)) {
			this.validationUtil.violations(reviewDto)
					.stream()
					.map(ConstraintViolation::getMessage)
					.forEach(System.out::println);
		} else {
			this.reviewRepo.save(this.modelMapper.map(reviewDto, Review.class));
		}

	}

	@Override
	public void addReviewM(Review review) {
		reviewRepo.save(review);
	}

	@Override
	public void deleteReview(String id) {
		reviewRepo.delete(reviewRepo.findById(id));
	}

	@Override
	public List<Review> findAll() {
		return reviewRepo.findAll();
	}

	@Override
	public Review findById(String id) {
		return reviewRepo.findById(id);
	}

	@Override
	public void updateReviewById(String id, ReviewDto reviewDto) {
		Review review = reviewRepo.findById(id);
		if (!this.validationUtil.isValid(reviewDto)) {
			this.validationUtil.violations(reviewDto)
					.stream()
					.map(ConstraintViolation::getMessage)
					.forEach(System.out::println);
		} else {
			review.setContent(reviewDto.getContent());
			review.setRating(reviewDto.getRating());
			review.setDate(new Timestamp(System.currentTimeMillis()));

			this.reviewRepo.update(review);
		}
	}

	@Override
	public List<ReviewDto> findAllByCategoryName(String categoryName) {
		return reviewRepo.getAllByRepairName(categoryName)
				.stream().
				map(c -> modelMapper.map(Review.class, ReviewDto.class)).toList();
	}

	@Override
	public List<Review> findAllByRepairName(String name) {
		return reviewRepo.findAllByRepairName(name);
	}
}
