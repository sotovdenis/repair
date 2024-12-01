package com.example.repairs.services;

import com.example.repairs.dto.CategoryDto;
import com.example.repairs.entities.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDto categoryDto);
    List<Category> findAll();
    Category findById(String id);
    Category findByName(String name);
}
