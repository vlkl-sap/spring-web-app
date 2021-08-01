package com.github.mibo.spring.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStore extends JpaRepository<User, String> {
  Optional<User> findByName(String name);
}
