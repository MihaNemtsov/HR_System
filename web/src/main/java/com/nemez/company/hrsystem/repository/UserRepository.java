package com.nemez.company.hrsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nemez.company.hrsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
