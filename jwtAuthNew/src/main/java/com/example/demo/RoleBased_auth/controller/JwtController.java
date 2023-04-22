package com.example.demo.RoleBased_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RoleBased_auth.helper.JwtUtil;
import com.example.demo.RoleBased_auth.models.JwtRequest;
import com.example.demo.RoleBased_auth.models.JwtResponse;
import com.example.demo.RoleBased_auth.service.CustomUserDetails;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class JwtController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetails customUserDetails;
	@Autowired
	private JwtUtil jwtUtil;
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest);
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("bad credentials");
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails= customUserDetails.loadUserByUsername(jwtRequest.getUsername());
		String token=jwtUtil.generateToken(userDetails);
		System.out.println("jwt token"+token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
