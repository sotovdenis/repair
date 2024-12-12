package com.example.repairs.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	private User user;
	private RepairParts repairParts;
	private double amount;
	private String status;
	private Timestamp date;

	public Order(User user, RepairParts repairParts, double amount, String status, Timestamp date) {
		this.user = user;
		this.repairParts = repairParts;
		this.amount = amount;
		this.status = status;
		this.date = date;
	}

	protected Order() {
	}

	@OneToOne
	public User getUser() {
		return user;
	}

	public void setUser(User customer) {
		this.user = customer;
	}

	@OneToOne
	public RepairParts getRepairParts() {
		return repairParts;
	}

	public void setRepairParts(RepairParts repairParts) {
		this.repairParts = repairParts;
	}

	@Column(name = "amount", nullable = false)
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "date", nullable = false)
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
