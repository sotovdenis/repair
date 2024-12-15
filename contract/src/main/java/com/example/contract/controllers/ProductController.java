package com.example.contract.controllers;

import com.example.contract.viewmodel.parts.ProductViewModel;
import com.example.contract.viewmodel.parts.ReviewViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface ProductController extends BaseController {

    @GetMapping("/{name}")
    String viewRepairDetail(
            @PathVariable String name,
            Model model,
            ProductViewModel productViewModel
    ) throws Exception;

}
