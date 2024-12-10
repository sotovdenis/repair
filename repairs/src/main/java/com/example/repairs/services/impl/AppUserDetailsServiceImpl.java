package com.example.repairs.services.impl;

import com.example.repairs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class AppUserDetailsServiceImpl implements UserDetailsService {
	private UserRepository userRepository;

	public AppUserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.map(u -> new User(
						u.getUsername(),
						u.getPassword(),
						u.getRoles().stream()
								.map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName().name()))
								.collect(Collectors.toList())
				)).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
	}
}

