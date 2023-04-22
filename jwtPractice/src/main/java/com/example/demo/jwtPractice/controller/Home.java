package com.example.demo.jwtPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	@GetMapping("/welcome")
public String welcome()
{
	return "This is private page";
}
}
