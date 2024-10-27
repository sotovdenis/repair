package com.example.repairs.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "review")
public class Review extends BaseEntity {
    private Customer customer;
    private RepairParts repairParts;
    private int rating;
    private String content;
    private Timestamp date;

    public Review(Customer customer, RepairParts repairParts, int rating, String content, Timestamp date) {
        this.customer = customer;
        this.repairParts = repairParts;
        this.rating = rating;
        this.content = content;
        this.date = date;
    }

    protected Review() {
    }

    @OneToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne
    public RepairParts getRepairParts() {
        return repairParts;
    }

    public void setRepairParts(RepairParts repairParts) {
        this.repairParts = repairParts;
    }

    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
