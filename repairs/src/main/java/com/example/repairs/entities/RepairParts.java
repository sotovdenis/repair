package com.example.repairs.entities;

import jakarta.persistence.*;
import org.attoparser.dom.Text;

@Entity
@Table(name = "repairs")
public class RepairParts extends BaseEntity {
    private String name;
    private String description;
    private double price;
    private Category category;
    private Order order;
    private Review review;

    public RepairParts(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    protected RepairParts() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToOne(mappedBy = "repairParts")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToOne(mappedBy = "repairParts")
    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
