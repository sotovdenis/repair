package com.example.repairs.controllers;

import com.example.contract.controllers.ProfileController;
import com.example.contract.viewmodel.parts.BaseViewModel;
import com.example.contract.viewmodel.parts.ProfileEditForm;
import com.example.contract.viewmodel.parts.ProfileViewModel;
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
	public String getProfile(String id, Model model) {
		CustomerDto customerDto = customerService.getCustomerById(id);

		if (customerDto == null) {
			model.addAttribute("message", "Пользователь не найден");
			return "error";
		}

		ProfileViewModel profileViewModel = new ProfileViewModel(
				id,
				"picture",
				customerDto.getLogin(),
				customerDto.getLogin(),
				customerDto.getPhone()

		);

		model.addAttribute("profile", profileViewModel);
		return "customers/profile";

	}

	@Override
	public String editProfile(String id, Model model) {
		return null;
	}

//	@Override
//	@GetMapping("/{id}/edit")
//	public String editProfile(@PathVariable String id, Model model) {
//		CustomerDto customer = customerService.getCustomerById(id);
//
//		if (customer == null) {
//			model.addAttribute("message", "Пользователь не найден");
//			return "error";
//		}
//
//		ProfileEditForm profileEditForm = new ProfileEditForm(
//				id,
//				customer.getLogin(),
//				customer.getPassword(),
//				customer.getEmail()
//		);
//
//		model.addAttribute("form", profileEditForm);
//		return "customers/edit";
//	}


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
