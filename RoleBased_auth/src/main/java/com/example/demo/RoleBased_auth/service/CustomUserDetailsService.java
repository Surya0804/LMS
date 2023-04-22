package com.example.demo.RoleBased_auth.service;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.RoleBased_auth.entity.Roles;
import com.example.demo.RoleBased_auth.entity.User;
import com.example.demo.RoleBased_auth.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userRepo.findByUsername(username);
	  

	    Set<GrantedAuthority> authorities = new HashSet<>();
	    for (Roles role : user.getRoles()) {
	        authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
	    }

	    return new org.springframework.security.core.userdetails.User(
	        user.getUsername(), user.getPassword(), authorities);
	}



	}


