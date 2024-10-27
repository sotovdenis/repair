package com.example.repairs.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cars")
public class CarsInfo extends BaseEntity {
    private String brandName;
    private String VIN;
    private Set<Category> categories;

    public CarsInfo(String brandName, String VIN) {
        this.brandName = brandName;
        this.VIN = VIN;
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
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @OneToMany(mappedBy = "usefulCar")
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
