package com.example.repairs.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    private String login;
    private String password;
    private Order order;
    private Review review;

    public Customer(String name, String email, String phone, String login, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
    }

    protected Customer() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(mappedBy = "customer")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToOne(mappedBy = "customer")
    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
