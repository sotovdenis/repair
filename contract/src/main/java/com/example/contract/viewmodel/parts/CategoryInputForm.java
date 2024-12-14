package com.example.contract.viewmodel.parts;

import jakarta.validation.constraints.NotBlank;

public record CategoryInputForm(
		@NotBlank
		String name,
		@NotBlank
		String brand,
		@NotBlank
		String car
) {
}
