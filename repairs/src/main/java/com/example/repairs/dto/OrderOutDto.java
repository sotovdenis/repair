package com.example.repairs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderOutDto {
	private String repairName;
	private double price;
	private String status;
	private String dateOfOrder;

	public OrderOutDto(String repairName, double price, String status, String dateOfOrder) {
		this.repairName = repairName;
		this.price = price;
		this.status = status;
		this.dateOfOrder = dateOfOrder;
	}

	@NotNull
	@NotEmpty
	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@NotNull
	@NotEmpty
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@NotNull
	@NotEmpty
	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
}
