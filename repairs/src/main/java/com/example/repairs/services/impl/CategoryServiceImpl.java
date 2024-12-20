package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.CategoryDto;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.Category;
import com.example.repairs.repositories.CarInfoRepo;
import com.example.repairs.repositories.CategoryRepo;
import com.example.repairs.services.CategoryService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@EnableCaching
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepo categoryRepo;
	private final ValidationUtil validationUtil;
	private final ModelMapper modelMapper;
	private final CarInfoRepo carInfoRepo;

	@Autowired
	public CategoryServiceImpl(CategoryRepo categoryRepo, ValidationUtil validationUtil, ModelMapper modelMapper, CarInfoRepo carInfoRepo) {
		this.categoryRepo = categoryRepo;
		this.validationUtil = validationUtil;
		this.modelMapper = modelMapper;
		this.carInfoRepo = carInfoRepo;
	}

	@Override
	@CacheEvict(cacheNames = "categories", allEntries = true)
	public void addCategory(CategoryDto categoryDto) {
		if (!this.validationUtil.isValid(categoryDto)) {
			this.validationUtil.violations(categoryDto)
					.stream()
					.map(ConstraintViolation::getMessage)
					.forEach(System.out::println);
		} else {
			CarsInfo car = carInfoRepo.findById(categoryDto.getCar());

			Category category = this.modelMapper.map(categoryDto, Category.class);
			category.setCar(car);

			this.categoryRepo.save(category);
		}
	}

	@Override
	@Cacheable("categories")
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findById(String id) {
		return categoryRepo.findById(id);
	}

	@Override
	public Category findByName(String name) {
		List<Category> categories = categoryRepo.findAll();
		return categories.stream()
				.filter(category -> category.getName().equals(name))
				.findFirst()
				.orElse(null);
	}
}
