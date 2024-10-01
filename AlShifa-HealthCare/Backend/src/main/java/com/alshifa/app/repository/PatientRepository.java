package com.alshifa.app.repository;

import com.alshifa.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<User, Long> {
}
