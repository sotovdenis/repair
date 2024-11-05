package com.example.repairs.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class RepairPartsDto {
    private String name;
    private String description;
    private double price;
    private String category;

    protected RepairPartsDto() {
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя детали должно содеражать более 2 символов")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    @NotEmpty
    @Length(min = 20, message = "Вы должны подробнее описать товар")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull
    @NotEmpty
    @Positive
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NotNull
    @NotEmpty
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
