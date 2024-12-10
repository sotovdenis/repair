package com.example.repairs.repositories;

import com.example.repairs.entities.Role;
import com.example.repairs.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, String> {
	Optional<Role> findRoleByName(UserRoles role);
}
