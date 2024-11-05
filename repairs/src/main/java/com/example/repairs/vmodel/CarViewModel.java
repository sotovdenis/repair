package com.example.repairs.vmodel;

public class CarViewModel {
    private String brandName;
    private String VIN;

    public CarViewModel() {
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}
