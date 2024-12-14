package com.example.contract.controllers;

import com.example.contract.viewmodel.parts.ProfileEditForm;
import com.example.contract.viewmodel.parts.ProfileViewModel;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public interface ProfileController extends BaseController {

	@GetMapping("/{id}")
	String getProfile(@PathVariable String id,
	                  Model model);

	@GetMapping("/{id}/edit")
	String editProfile(
			@PathVariable String id,
			Model model
	);

	@PostMapping("/{id}/edit")
	String edit(
			@PathVariable String id,
			@Valid @ModelAttribute("form") ProfileEditForm form,
			BindingResult bindingResult,
			Model model
	);


}
