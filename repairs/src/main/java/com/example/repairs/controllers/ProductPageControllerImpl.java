package com.example.repairs.controllers;

import com.example.contract.controllers.ProductController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ReviewViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPageControllerImpl implements ProductController {
    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(
                title
        );
    }

    @Override
    public String viewRepairDetail(String id, Model model, ReviewViewModel reviewViewModel) {
        return null;
    }
}
