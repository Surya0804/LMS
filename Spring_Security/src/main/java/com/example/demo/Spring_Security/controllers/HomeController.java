package com.example.demo.Spring_Security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/land")
public class HomeController {
	//goto home page
	@GetMapping("/home")
	public String goHome()
	{
		return "This is home";
	}
	@GetMapping("/login")
	public String goLogin()
	{
		return "This is Login";
	}
	@GetMapping("/register")
	public String goRegister()
	{
		return "This is register";
	}
}
