package com.example.repairs.services.impl;

import com.example.repairs.config.validator.ValidationUtil;
import com.example.repairs.dto.CarDto;
import com.example.repairs.dto.CategoryDto;
import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.Category;
import com.example.repairs.repositories.CategoryRepo;
import com.example.repairs.services.CategoryService;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {
        if (!this.validationUtil.isValid(categoryDto)) {
            this.validationUtil.violations(categoryDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            this.categoryRepo.save(this.modelMapper.map(categoryDto, Category.class));
//            TODO: Спросить, как проставить внешние ключи (может через поиск по другим сущностям?)
//            джоины лучше писать как кастом в репах или искать все во всех и пересекать множества по условию?
//            к примеру на фронте можно будет выбрать из списка и указать их айдишники, получается внешние ключи попадают в дто????
//            кастомерСервИмпл еще вопросы, КарИнфоРепоИмпл
//            ЗАчем viewModels?
        }
    }
}
