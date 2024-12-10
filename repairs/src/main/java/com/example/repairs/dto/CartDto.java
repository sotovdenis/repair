package com.example.repairs.dto;

public class CartDto {
	private String userId;
	private String repairPartsId;

	public CartDto(String userId, String repairPartsId) {
		this.userId = userId;
		this.repairPartsId = repairPartsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRepairPartsId() {
		return repairPartsId;
	}

	public void setRepairPartsId(String repairPartsId) {
		this.repairPartsId = repairPartsId;
	}
}
