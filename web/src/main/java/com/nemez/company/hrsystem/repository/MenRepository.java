package com.nemez.company.hrsystem.repository;

import com.nemez.company.hrsystem.model.Mens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenRepository extends JpaRepository<Mens, Integer> {
}
