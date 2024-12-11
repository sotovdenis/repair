package com.example.repairs.vmodel;


public class UserProfileView {
	private String username;

	private String email;

	private String fullName;

	private String password;

	private int age;

	public UserProfileView() {
	}

	public UserProfileView(String username, String email, String password, String fullName, int age) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

