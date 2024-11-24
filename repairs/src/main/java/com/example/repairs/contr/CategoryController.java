package com.example.repairs.contr;

import com.example.repairs.dto.CategoryDto;
import com.example.repairs.entities.Category;
import com.example.repairs.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }

    @GetMapping("/all")
    List<Category> findAllCategories() {
        return categoryService.findAll();
    }

}
