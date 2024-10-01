package com.plumcity.plum_city.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plumcity.plum_city.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
