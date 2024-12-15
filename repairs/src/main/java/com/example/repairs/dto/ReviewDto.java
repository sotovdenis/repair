package com.example.repairs.dto;

import jakarta.validation.constraints.Max;

public class ReviewDto {
    private int rating;
    private String content;
    private String userId;
    private String repairPartsId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;


    public ReviewDto() {
    }

//    @NotNull
//    @NotEmpty
    public int getRating() {
        return rating;
    }

    public void setRating(@Max(6) int rating) {
        this.rating = rating;
    }

//    @NotNull
//    @NotEmpty
//    @Length(min = 5, message = "Расскажите подробнее про этот товар")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    @NotNull
//    @NotEmpty
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

//    @NotNull
//    @NotEmpty
    public String getRepairPartsId() {
        return repairPartsId;
    }

    public void setRepairPartsId(String repairPartsId) {
        this.repairPartsId = repairPartsId;
    }
}
