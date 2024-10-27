package com.example.repairs.repositories.impl;

import com.example.repairs.entities.Category;
import com.example.repairs.repositories.CategoryRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends BaseCRUDRepo<Category> implements CategoryRepo {
    public CategoryRepositoryImpl() {
        super(Category.class);
    }
}
