package com.example.contract.viewmodel.parts;

import jakarta.validation.constraints.NotBlank;

public record RepairInputForm(
		@NotBlank
		String name,
		@NotBlank
		String description,
		double price,
		@NotBlank
		String category
) {
}
