package com.example.repairs.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    private Set<RepairParts> repairParts;
    private CarsInfo usefulCar;
    private String name;
    private String brand;

    public Category(Set<RepairParts> repairParts, CarsInfo usefulCar, String name, String brand) {
        this.repairParts = repairParts;
        this.usefulCar = usefulCar;
        this.name = name;
        this.brand = brand;
    }

    protected Category() {
    }

    @OneToMany(mappedBy = "category")
    public Set<RepairParts> getRepairParts() {
        return repairParts;
    }

    public void setRepairParts(Set<RepairParts> repairParts) {
        this.repairParts = repairParts;
    }

    @ManyToOne
    public CarsInfo getUsefulCar() {
        return usefulCar;
    }

    public void setUsefulCar(CarsInfo usefulCar) {
        this.usefulCar = usefulCar;
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
