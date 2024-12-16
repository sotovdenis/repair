package com.example.repairs.repositories;

import com.example.repairs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
	void save(User user);
	void update(User user);
	User findById(String id);
	void saveAll(List<User> users);
	Optional<User> findOptionalByUsername(String username);
	Optional<User> findByEmail(String email);
	long count();
	List<User> findAll();
	Optional<User> findByUsername(String username);

	User getUserByUsername(String param);
}
