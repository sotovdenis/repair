package com.example.repairs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ReviewDto {
    private int rating;
    private String content;
    private String customer;
    private String repairPart;


    protected ReviewDto() {
    }

    @NotNull
    @NotEmpty
    public int getRating() {
        return rating;
    }

    public void setRating(@Max(5) int rating) {
        this.rating = rating;
    }

    @NotNull
    @NotEmpty
    @Length(min = 5, message = "Расскажите подробнее про этот товар")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")
    public String getRepairPart() {
        return repairPart;
    }

    public void setRepairPart(String repairPart) {
        this.repairPart = repairPart;
    }
}
