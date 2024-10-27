package com.example.repairs.repositories;

import com.example.repairs.entities.Category;
import com.example.repairs.repositories.base.CreateRepo;
import com.example.repairs.repositories.base.ReadRepo;
import com.example.repairs.repositories.base.UpdateRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CreateRepo<Category>, ReadRepo<Category>, UpdateRepo<Category> {
}