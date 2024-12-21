package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

public class CarsInfoInputModel {
    private String brandName;
    private String vin;

    @NotBlank(message = "Марка автомобиля обязательна")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @NotBlank(message = "VIN код обязателен")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}

