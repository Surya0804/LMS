package com.example.demo.Spring_Security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Spring_Security.models.User;
import com.example.demo.Spring_Security.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
  private UserService userService;

	
	
	
	
	
	//get all users
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	@GetMapping("/getUserByUsername/{username}")
	public User getUserByUsername(@PathVariable String username)
	{
		return userService.getUserByUsername(username);
	}
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
}
