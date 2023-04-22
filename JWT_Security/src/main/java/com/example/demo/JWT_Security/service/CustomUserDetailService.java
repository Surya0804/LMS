package com.example.demo.JWT_Security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.JWT_Security.entity.User;
import com.example.demo.JWT_Security.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService 
{
	@Autowired
private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=userRepository.findByUsername(username);
	
	      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	    
	
	}

}
