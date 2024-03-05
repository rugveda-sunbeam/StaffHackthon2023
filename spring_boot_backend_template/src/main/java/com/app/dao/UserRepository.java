package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 Optional<User> findByUsernameAndPassword(String username, String password);
}
