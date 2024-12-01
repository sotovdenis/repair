package com.example.repairs.controllers;

import com.example.contract.controllers.ProfileController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProfileEditForm;
import com.example.repairs.dto.CustomerDto;
import com.example.repairs.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileControllerImpl implements ProfileController {

    private final CustomerService customerService;

    @Autowired
    public ProfileControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @GetMapping("/{id}/edit")
    public String editProfile(@PathVariable String id, Model model) {
        CustomerDto customer = customerService.getCustomerById(id);

        if (customer == null) {
            model.addAttribute("message", "Пользователь не найден");
            return "error";
        }

        ProfileEditForm profileEditForm = new ProfileEditForm(
                id,
                customer.getLogin(),
                customer.getPassword(),
                customer.getEmail()
        );

        model.addAttribute("form", profileEditForm);
        return "customers/edit";
    }

    @GetMapping("/pidor")
    public String pidor(Model model) {
        return "cars/table";
    }

    @Override
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable String id,
                       @Valid @ModelAttribute("form") ProfileEditForm form,
                       BindingResult bindingResult,
                       Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "editProfile";
        }

        CustomerDto customer = customerService.getCustomerById(id);
        if (customer == null) {
            model.addAttribute("message", "Пользователь не найден");
            return "error";
        }

        customer.setLogin(form.login());
        customer.setPassword(form.password());
        customer.setEmail(form.email());

        customerService.updateCustomerById(id, customer);

        model.addAttribute("message", "Профиль обновлен");

        return "redirect:/profile/{id}/edit";
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(
                title
        );
    }
}
