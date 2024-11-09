package com.example.repairs.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CategoryDto {
    private String name;
    private String brand;
    private String carBrand;
    private String usefulCar;

    public CategoryDto() {
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @NotNull
    @NotEmpty
    public String getUsefulCar() {
        return usefulCar;
    }

    public void setUsefulCar(String usefulCar) {
        this.usefulCar = usefulCar;
    }
}
