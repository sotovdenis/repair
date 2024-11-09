package com.example.repairs.repositories.impl;

import com.example.repairs.entities.CarsInfo;
import com.example.repairs.entities.Category;
import com.example.repairs.repositories.CategoryRepo;
import com.example.repairs.repositories.base.BaseCRUDRepo;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl extends BaseCRUDRepo<Category> implements CategoryRepo {
    public CategoryRepositoryImpl() {
        super(Category.class);
    }
}
