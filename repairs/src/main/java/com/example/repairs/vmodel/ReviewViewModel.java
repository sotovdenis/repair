package com.example.repairs.vmodel;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ReviewViewModel {
    private int rating;
    private String content;

    protected ReviewViewModel() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(@Max(5)int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
