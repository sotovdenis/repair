package com.example.repairs.dto;

public class TopDto {
	private String id;
	private String name;
	private double sum;

	public TopDto(String id, String name, double sum) {
		this.id = id;
		this.name = name;
		this.sum = sum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
}
