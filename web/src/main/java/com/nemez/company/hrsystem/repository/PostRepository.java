package com.nemez.company.hrsystem.repository;

import com.nemez.company.hrsystem.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
