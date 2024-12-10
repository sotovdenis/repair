package com.example.repairs.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {
	private Customer customerId;
	private RepairParts repairPartsId;

	protected Cart() {
	}

	public Cart(Customer customerId, RepairParts repairPartsId) {
		this.customerId = customerId;
		this.repairPartsId = repairPartsId;
	}

	@OneToOne
	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	@OneToOne
	public RepairParts getRepairPartsId() {
		return repairPartsId;
	}

	public void setRepairPartsId(RepairParts repairPartsId) {
		this.repairPartsId = repairPartsId;
	}
}
