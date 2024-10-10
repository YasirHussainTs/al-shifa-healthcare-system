package com.alshifa.app.repository;

import com.alshifa.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleUser);
}
