package com.example.contract.input;

import jakarta.validation.constraints.NotBlank;

public class CustomerInputModel {
    private String name;
    private String email;
    private String phone;
    private String login;
    private String password;

    @NotBlank(message = "Имя обязательно")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Email обязателен")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Номер телефона обязателен")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotBlank(message = "Логин обязателен")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @NotBlank(message = "Пароль обязателен")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
