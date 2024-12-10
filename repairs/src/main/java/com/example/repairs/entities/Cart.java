package com.example.repairs.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {
	private User userId;
	private RepairParts repairPartsId;

	protected Cart() {
	}

	public Cart(User userId, RepairParts repairPartsId) {
		this.userId = userId;
		this.repairPartsId = repairPartsId;
	}

	@OneToOne
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@OneToOne
	public RepairParts getRepairPartsId() {
		return repairPartsId;
	}

	public void setRepairPartsId(RepairParts repairPartsId) {
		this.repairPartsId = repairPartsId;
	}
}
