package com.example.demo.JWT_Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.JWT_Security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
