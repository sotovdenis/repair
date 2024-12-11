package com.example.repairs.services;

import com.example.repairs.entities.User;

public interface UserService {
	void addUser(User user);
	void updateUserByUsername(String username);
}
