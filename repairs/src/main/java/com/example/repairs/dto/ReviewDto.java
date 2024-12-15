package com.example.repairs.dto;

import jakarta.validation.constraints.Max;

public class ReviewDto {
    private int rating;
    private String content;
    private String usersId;
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
    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
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
