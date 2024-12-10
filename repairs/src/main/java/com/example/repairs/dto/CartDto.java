package com.example.repairs.dto;

public class CartDto {
	private String customerId;
	private String repairPartsId;

	public CartDto(String customerId, String repairPartsId) {
		this.customerId = customerId;
		this.repairPartsId = repairPartsId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getRepairPartsId() {
		return repairPartsId;
	}

	public void setRepairPartsId(String repairPartsId) {
		this.repairPartsId = repairPartsId;
	}
}
