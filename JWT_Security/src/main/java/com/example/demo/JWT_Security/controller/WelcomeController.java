package com.example.demo.JWT_Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JWT_Security.entity.AuthRequest;
import com.example.demo.JWT_Security.service.CustomUserDetailService;
import com.example.demo.JWT_Security.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class WelcomeController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@GetMapping("/welcome")
  public String welcome()
  {
	  return "Welcome Surya";
  }
	@PostMapping("/token")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		}
		catch(Exception e)
		{
			throw new Exception("Invalid dude");
		}
		UserDetails userDetails=customUserDetailService.loadUserByUsername(authRequest.getUsername());
		return jwtUtil.generateToken(userDetails);
	}
}
