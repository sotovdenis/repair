package com.example.repairs.controllers;

import com.example.contract.controllers.MainPageController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.repairs.entities.Category;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.services.CategoryService;
import com.example.repairs.services.RepairPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
public class MainPageControllerImpl implements MainPageController {

    private final RepairPartsService repairPartsService;
    private final CategoryService categoryService;

    @Autowired
    public MainPageControllerImpl(RepairPartsService repairPartsService, CategoryService categoryService) {
        this.repairPartsService = repairPartsService;
        this.categoryService = categoryService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping
    public String listMainPage(Model model) {
        List<Category> categoryList = categoryService.findAll().stream().limit(5).collect(Collectors.toList());

        List<RepairParts> repairPartsList = repairPartsService.findAll().stream().limit(5).collect(Collectors.toList());

        model.addAttribute("categories", categoryList);
        model.addAttribute("repairParts", repairPartsList);

        return "main";
    }
}
