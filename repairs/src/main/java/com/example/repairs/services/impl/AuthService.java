package com.example.repairs.services.impl;


import com.example.repairs.dto.UpdateUserForm;
import com.example.repairs.dto.UserRegistrationDto;
import com.example.repairs.entities.User;
import com.example.repairs.entities.UserRoles;
import com.example.repairs.repositories.UserRepository;
import com.example.repairs.repositories.UserRoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

	private UserRepository userRepository;

	private UserRoleRepository userRoleRepository;


	private PasswordEncoder passwordEncoder;

	public AuthService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userRoleRepository = userRoleRepository;
	}

	public void register(UserRegistrationDto registrationDTO) {
		if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
			throw new RuntimeException("passwords.match");
		}

		Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

		if (byEmail.isPresent()) {
			throw new RuntimeException("email.used");
		}

		var userRole = userRoleRepository.
				findRoleByName(UserRoles.USER).orElseThrow();

		User user = new User(
				registrationDTO.getUsername(),
				passwordEncoder.encode(registrationDTO.getPassword()),
				registrationDTO.getEmail(),
				registrationDTO.getFullname(),
				registrationDTO.getAge()
		);

		user.setRoles(List.of(userRole));

		this.userRepository.save(user);
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
	}

	public void edit(String username, UpdateUserForm updatedUser) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));;

		user.setUsername(updatedUser.getUsername());
		user.setEmail(updatedUser.getEmail());
		user.setPassword(updatedUser.getPassword());
		user.setAge(updatedUser.getAge());

		userRepository.save(user);
	}
}

