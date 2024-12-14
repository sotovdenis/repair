package com.example.contract.viewmodel.pages;

import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.BestRepairsViewModel;
import com.example.contract.viewmodel.parts.CategoryViewModel;

import java.util.List;

public record MainPageViewModel(
        BaseViewModel baseViewModel,
        List<BestRepairsViewModel> bestRepairsViewModel,
        CategoryViewModel categoryViewModel
        ) {
}
