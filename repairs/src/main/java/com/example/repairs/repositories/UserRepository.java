package com.example.repairs.repositories;

import com.example.repairs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	User getUserByUsername(String username);
	User findById(String id);
	Optional<User> findByUsername(String username);
}
