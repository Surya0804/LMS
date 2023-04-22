package com.example.demo.RoleBased_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RoleBased_auth.entity.User;
import com.example.demo.RoleBased_auth.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
private UserRepository userRepo;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin")
	public ResponseEntity<?> getAdmin(@RequestBody User user1) throws Exception
	{
		User user=userRepo.findByUsername(user1.getUsername());
		if(user.getPassword().equals(user1.getPassword()))
		{
			return ResponseEntity.ok("Admin Login Successfull");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}
	
}
