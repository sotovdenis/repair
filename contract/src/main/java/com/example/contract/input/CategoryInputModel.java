package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

public class CategoryInputModel {
    private String car;
    private String name;
    private String brand;

    @NotBlank(message = "ID автомобиля обязателен")
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
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

