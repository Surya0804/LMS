package com.example.demo.sql_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sql_practice.Repository.UserRepository;
import com.example.demo.sql_practice.entity.User;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return this.userRepo.save(user);
		
	}

}
