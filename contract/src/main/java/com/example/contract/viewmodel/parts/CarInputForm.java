package com.example.contract.viewmodel.parts;

import jakarta.validation.constraints.NotBlank;

public record CarInputForm(
		@NotBlank
		String brandName,
		@NotBlank
		String vin
) {
}
