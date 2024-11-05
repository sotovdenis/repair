package com.example.repairs.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CustomerDto {
    private String name;
    private String email;
    private String phone;
    private String login;
    private String password;

    public CustomerDto(){
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Email должно содеражать более 2 символов")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @NotEmpty
    @Length(min = 10, max = 11, message = "Проверьте номер телефона")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Имя должно содеражать более 2 символов")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Пароль должен содеражать более 2 символов")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
