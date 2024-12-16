package com.example.contract.viewmodel.pages;

import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProductViewModel;

public record ProductsInCategoryPageViewModel(
        BaseViewModel baseViewModel,
        ProductViewModel productViewModel
) {
}