package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

public class RepairPartsInputModel {
    private String name;
    private String description;
    private double price;
    private String categoryId;

    @NotBlank(message = "Название запчасти обязательно")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Описание запчасти обязательно")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NotBlank(message = "ID категории обязателен")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}

