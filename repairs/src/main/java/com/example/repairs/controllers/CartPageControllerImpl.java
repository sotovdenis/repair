package com.example.repairs.controllers;

import com.example.contract.controllers.CartPageController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.repairs.entities.RepairParts;
import com.example.repairs.services.RepairPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartPageControllerImpl implements CartPageController {

    private final RepairPartsService repairPartsService;

    @Autowired
    public CartPageControllerImpl(RepairPartsService repairPartsService) {
        this.repairPartsService = repairPartsService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(
                title
        );
    }

    @Override
    public String listProducts(Model model) {

        List<RepairParts> repairParts = repairPartsService.findAll();

        if (repairParts.isEmpty()) {
            model.addAttribute("message", "???");
        }

        return "cart";
    }
}
