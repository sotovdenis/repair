package com.example.contract.viewmodel.pages;

import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProfileViewModel;

import java.util.List;

public record ProfilePageViewModel(
        BaseViewModel baseViewModel,
        List<CartPageViewModel> cartPageViewModels,
        ProfileViewModel profileViewModel
) {
}
