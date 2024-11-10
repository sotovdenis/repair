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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
