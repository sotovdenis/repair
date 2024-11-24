package com.example.repairs.controllers;

import com.example.contract.controllers.CartPageController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartPageControllerImpl implements CartPageController {
    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(
                title
        );
    }

    @Override
    public String listProducts(Model model) {
        return null;
    }
}
