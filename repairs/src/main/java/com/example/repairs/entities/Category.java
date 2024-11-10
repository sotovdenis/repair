package com.example.repairs.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    private CarsInfo car;
    private String name;
    private String brand;

    public Category(CarsInfo car, String name, String brand) {
        this.car = car;
        this.name = name;
        this.brand = brand;
    }

    public Category() {
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    public CarsInfo getCar() {
        return car;
    }

    public void setCar(CarsInfo usefulCar) {
        this.car = usefulCar;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
