package com.example.demo.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
				if(userName.equals("john"))
		{
		return new org.springframework.security.core.userdetails.User("john","123",new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("not found");
		}
	}

}
