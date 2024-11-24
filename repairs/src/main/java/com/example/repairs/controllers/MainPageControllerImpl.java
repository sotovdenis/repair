package com.example.repairs.controllers;

import com.example.contract.controllers.MainPageController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageControllerImpl implements MainPageController {

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping("/main/repairs")
    public String listRepairs(Model model) {
        return "listRepairs";
    }

    @Override
    @GetMapping("/main/categories")
    public String listCategories(Model model) {
        return "listCategories";
    }
}
