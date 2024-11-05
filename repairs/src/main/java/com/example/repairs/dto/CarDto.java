package com.example.repairs.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CarDto {
    private String brandName;
    private String VIN;

    public CarDto() {
    }

    @NotNull
    @NotEmpty
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @NotNull
    @NotEmpty
    @Length(max = 17, message = "Проверьте введенный VIN!")
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}
