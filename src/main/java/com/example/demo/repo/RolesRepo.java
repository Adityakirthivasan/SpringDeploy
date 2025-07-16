package com.example.demo.repo;

import com.example.demo.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolesRepo extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(String roleName);
}
