package com.example.contract.viewmodel.parts;

public class ReviewViewModel {
    private String review;
    private int rating;


    public ReviewViewModel(String review, int rating) {
        this.review = review;
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
