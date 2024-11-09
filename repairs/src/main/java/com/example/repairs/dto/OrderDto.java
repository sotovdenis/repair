package com.example.repairs.dto;

public class OrderDto {
    private String customer;
    private String repairPart;

    public OrderDto() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getRepairPart() {
        return repairPart;
    }

    public void setRepairPart(String repairPart) {
        this.repairPart = repairPart;
    }
}
