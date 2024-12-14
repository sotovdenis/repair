package com.example.contract.viewmodel.parts;

import jakarta.validation.constraints.NotBlank;

public class BestRepairsViewModel {
    private double price;
    private int rating;
    private String picture;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @NotBlank
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
