package com.example.demo.jwt.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	@RequestMapping("/welcome")
 public String welcome()
 {
	 return "This is private page";
 }
}
