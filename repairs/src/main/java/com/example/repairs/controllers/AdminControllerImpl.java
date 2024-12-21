package com.example.repairs.controllers;

import com.example.contract.controllers.AdminPageController;
import com.example.contract.input.CarsInfoInputModel;
import com.example.contract.input.CategoryInputModel;
import com.example.contract.input.RepairPartsInputModel;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.repairs.dto.*;
import com.example.repairs.services.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminPageController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    private final CarsInfoService carsInfoService;

    private final CategoryService categoryService;
    private final RepairPartsService repairPartsService;
    @Autowired
    public AdminControllerImpl(CarsInfoService carsInfoService, CategoryService categoryService,
                               RepairPartsService repairPartsService) {
        this.carsInfoService = carsInfoService;
        this.categoryService = categoryService;
        this.repairPartsService = repairPartsService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(
                title
        );
    }

    @Override
    @GetMapping
    public String admin() {
        return "admin/admin";
    }

    @Override
    @GetMapping("/cars")
    public String viewAllCars(Model model) {
        LOG.log(Level.INFO, "viewedAllCars");
        model.addAttribute("cars", carsInfoService.findAll());
        return "cars/table";
    }

    @Override
    @GetMapping("/cars/create")
    public String createCarForm(Model model) {
        model.addAttribute("carDto", new CarDto());
        return "cars/create";
    }

    @Override
    @PostMapping("/cars/create")
    public String createCar(@ModelAttribute("carDto") CarsInfoInputModel carDto,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/admin/cars/create";
        }
        LOG.log(Level.INFO, "car created {}", carDto.toString());
        carsInfoService.addCarInfo(carDto.getBrandName(), carDto.getVin());
        return "redirect:/admin/cars";
    }

    @Override
    @GetMapping("/categories")
    public String viewAllCategories(Model model) {
        LOG.log(Level.INFO, "all categories viewed");
        model.addAttribute("categories", categoryService.findAll());
        return "categories/table";
    }

    @Override
    @GetMapping("/categories/create")
    public String createCategoryForm(Model model) {
        model.addAttribute("categoryDto", new CategoryDto());
        model.addAttribute("cars", carsInfoService.findAll());
        return "categories/create";
    }

    @Override
    @PostMapping("/categories/create")
    public String createCategory(@ModelAttribute("categoryDto")
                                 CategoryInputModel categoryDto,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cars", carsInfoService.findAll());
            return "categories/create";
        }

        LOG.log(Level.INFO, "category created {}", categoryDto.getName());

        CategoryDto categoryDtoToAdd = new CategoryDto();
        categoryDtoToAdd.setName(categoryDto.getName());
        categoryDtoToAdd.setCar(categoryDto.getCar());
        categoryDtoToAdd.setBrand(categoryDto.getBrand());

        categoryService.addCategory(categoryDtoToAdd);
        return "redirect:/admin/categories";
    }

    @Override
    @GetMapping("/repair")
    public String viewAllRepairParts(Model model) {
        model.addAttribute("repair", repairPartsService.findAll());
        LOG.log(Level.INFO, "viewedAllRepairs");
        return "repair/table";
    }

    @Override
    @GetMapping("/repair/create")
    public String createRepairPartForm(Model model) {
        model.addAttribute("repairPartsDto", new RepairPartsDto());
        model.addAttribute("categories", categoryService.findAll());
        return "repair/create";
    }

    @Override
    @PostMapping("/repair/create")
    public String createRepairPart(@ModelAttribute("repairPartsDto") RepairPartsInputModel repairPartsDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "repair/create";
        }

        LOG.log(Level.INFO, "new repair part created {}", repairPartsDto.getName());

        RepairPartsDto repairPartsDtoToAdd = new RepairPartsDto();
        repairPartsDtoToAdd.setName(repairPartsDto.getName());
        repairPartsDtoToAdd.setCategory(repairPartsDto.getCategory());
        repairPartsDtoToAdd.setDescription(repairPartsDto.getDescription());
        repairPartsDtoToAdd.setPrice(repairPartsDto.getPrice());

        repairPartsService.addRepairPart(repairPartsDtoToAdd);

        return "redirect:/admin/repair";
    }
}
