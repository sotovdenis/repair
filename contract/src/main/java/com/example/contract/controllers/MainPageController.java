package com.example.contract.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface MainPageController extends BaseController {

    @GetMapping
    public String listMainPage(Model model);

}
