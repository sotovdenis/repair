package com.example.repairs.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "review")
public class Review extends BaseEntity {
	private User users;
	private RepairParts repairParts;
	private int rating;
	private String content;
	private Timestamp date;

	public Review(User users, RepairParts repairParts, int rating, String content, Timestamp date) {
		this.users = users;
		this.repairParts = repairParts;
		this.rating = rating;
		this.content = content;
		this.date = date;
	}

	protected Review() {
	}

	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id" , nullable = false)
	public User getUsers() {
		return users;
	}

	public void setUsers(User customer) {
		this.users = customer;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "repair_parts_id" , nullable = false)
	public RepairParts getRepairParts() {
		return repairParts;
	}

	public void setRepairParts(RepairParts repairParts) {
		this.repairParts = repairParts;
	}

	@Column(name = "rating", nullable = false)
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "date", nullable = false)
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
