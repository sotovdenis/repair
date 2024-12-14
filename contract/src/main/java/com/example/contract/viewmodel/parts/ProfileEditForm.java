package com.example.contract.viewmodel.parts;

import jakarta.validation.constraints.NotBlank;

public record ProfileEditForm(
		@NotBlank
		String id,
		@NotBlank
		String login,
		@NotBlank
		String password,
		@NotBlank
		String email,
		int age
) {
}
