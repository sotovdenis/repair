package com.example.repairs.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class CarsInfo extends BaseEntity {
    private String brandName;
    private String vin;

    public CarsInfo(String brandName, String vin) {
        this.brandName = brandName;
        this.vin = vin;
    }


    protected CarsInfo() {
    }

    @Column(name = "brand", nullable = false)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "vin", nullable = false)
    public String getVin() {
        return vin;
    }

    public void setVin(String VIN) {
        this.vin = VIN;
    }

}
