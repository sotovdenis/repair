package com.example.repairs.dto;

public class OrderDto {
    private String user;
    private String repairPart;

    public OrderDto() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRepairPart() {
        return repairPart;
    }

    public void setRepairPart(String repairPart) {
        this.repairPart = repairPart;
    }
}
