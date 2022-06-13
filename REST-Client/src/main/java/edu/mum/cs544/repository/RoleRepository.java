package edu.mum.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}