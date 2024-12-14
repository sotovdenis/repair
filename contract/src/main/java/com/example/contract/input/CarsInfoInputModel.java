package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

public class CarsInfoInputModel {
    private String brandName;
    private String VIN;

    @NotBlank(message = "Марка автомобиля обязательна")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @NotBlank(message = "VIN код обязателен")
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}

