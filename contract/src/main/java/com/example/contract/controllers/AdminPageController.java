package com.example.contract.controllers;

import com.example.contract.input.CarsInfoInputModel;
import com.example.contract.input.CategoryInputModel;
import com.example.contract.input.RepairPartsInputModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface AdminPageController extends BaseController {


    String admin();

    String viewAllCars(Model model);

    String createCarForm(Model model);

    String createCar(@ModelAttribute("carDto") CarsInfoInputModel carDto,
                     BindingResult result, Model model);

    String viewAllCategories(Model model);

    String createCategoryForm(Model model);

    String createCategory(@ModelAttribute("categoryDto") CategoryInputModel categoryDto,
                          BindingResult result, Model model);

    String viewAllRepairParts(Model model);

    String createRepairPartForm(Model model);

    String createRepairPart(@ModelAttribute("repairPartsDto") RepairPartsInputModel repairPartsDto,
                            BindingResult result, Model model);

}
