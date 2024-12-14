package com.example.contract.viewmodel.pages;

import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProductViewModel;
import com.example.contract.viewmodel.parts.ReviewViewModel;

import java.util.List;

public record ProductPageViewModel(
        BaseViewModel baseViewModel,
        ProductViewModel productViewModel,
        List<ReviewViewModel> reviewViewModel
) {
}
