package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public class ReviewInputModel {
    private String customerId;
    private String repairPartsId;
    private int rating;
    private String content;
    private Timestamp date; // Использовать соответствующий формат даты

    @NotBlank(message = "ID клиента обязателен")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @NotBlank(message = "ID запчасти обязателен")
    public String getRepairPartsId() {
        return repairPartsId;
    }

    public void setRepairPartsId(String repairPartsId) {
        this.repairPartsId = repairPartsId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @NotBlank(message = "Контент отзыва обязателен")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotBlank(message = "Дата обязательна")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}

