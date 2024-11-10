package com.example.repairs.dto;

public class RenameCustomerDto {
    private String id;
    private String newLogin;

    public RenameCustomerDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewLogin() {
        return newLogin;
    }

    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }
}
