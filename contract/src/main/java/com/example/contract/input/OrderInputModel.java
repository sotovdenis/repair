package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public class OrderInputModel {
    private String customerId;
    private String repairPartsId;
    private double amount;
    private String status;
    private Timestamp date;

    @NotBlank(message = "ID клиента обязателен")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @NotBlank(message = "ID запчасти обязательна")
    public String getRepairPartsId() {
        return repairPartsId;
    }

    public void setRepairPartsId(String repairPartsId) {
        this.repairPartsId = repairPartsId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @NotBlank(message = "Статус обязательный")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotBlank(message = "Дата обязательна")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
