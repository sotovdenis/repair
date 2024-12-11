package com.example.repairs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateUserForm {
	private String username;
	private String email;
	private String password;
	private int age;

	public UpdateUserForm(String username, String email, String password, int age) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	@NotNull
	@NotEmpty
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@NotEmpty
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull
	@NotEmpty
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Min(value = 18, message = "Error under 18!")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
