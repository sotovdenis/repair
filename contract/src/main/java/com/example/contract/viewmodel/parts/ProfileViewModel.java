package com.example.contract.viewmodel.parts;

public class ProfileViewModel {
    private String id;
    private String picture;
    private String login;
    private String email;
    private String phone;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProfileViewModel(String id, String picture, String login, String email, String phone) {
        this.id = id;
        this.picture = picture;
        this.login = login;
        this.email = email;
        this.phone = phone;
    }
}
