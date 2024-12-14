package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

public class CategoryInputModel {
    private String carId;
    private String name;
    private String brand;

    @NotBlank(message = "ID автомобиля обязателен")
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @NotBlank(message = "Название категории обязательно")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Марка категории обязательна")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

