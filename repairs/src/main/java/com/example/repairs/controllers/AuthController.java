package com.example.repairs.controllers;

import com.example.repairs.dto.UserRegistrationDto;
import com.example.repairs.entities.User;
import com.example.repairs.services.impl.AuthService;
import com.example.repairs.vmodel.UserProfileView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@ModelAttribute("userRegistrationDto")
	public UserRegistrationDto initForm() {
		return new UserRegistrationDto();
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String doRegister(@Valid UserRegistrationDto userRegistrationDto,
	                         BindingResult bindingResult,
	                         RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);

			return "redirect:/users/register";
		}

		this.authService.register(userRegistrationDto);

		return "redirect:/users/login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login-error")
	public String onFailedLogin(
			@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
			RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
		redirectAttributes.addFlashAttribute("badCredentials", true);

		return "redirect:/main";
	}

	@GetMapping("/profile")
	public String profile(Principal principal, Model model) {
		String username = principal.getName();
		User user = authService.getUser(username);

		UserProfileView userProfileView = new UserProfileView(
				username,
				user.getEmail(),
				user.getFullName(),
				user.getAge()
		);

		model.addAttribute("user", userProfileView);

		return "customers/profile";
	}
}
