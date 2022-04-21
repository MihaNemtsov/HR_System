package com.nemez.company.hrsystem.repository;

import com.nemez.company.hrsystem.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
}
