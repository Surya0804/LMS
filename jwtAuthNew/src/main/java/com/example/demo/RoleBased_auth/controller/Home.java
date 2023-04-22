package com.example.demo.RoleBased_auth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {
	@GetMapping("/welcome")
public String welcome()
{
	return "Home Welcome";
}
	@GetMapping("/hai")
public String hai()
{
	return "Home hai";
}
}
