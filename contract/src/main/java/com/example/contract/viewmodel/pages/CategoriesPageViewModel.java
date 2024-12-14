package com.example.contract.viewmodel.pages;

import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.CategoryViewModel;

import java.util.List;

public record CategoriesPageViewModel(
        BaseViewModel baseViewModel,
        List<CategoryViewModel> categoryViewModels
) {
}
