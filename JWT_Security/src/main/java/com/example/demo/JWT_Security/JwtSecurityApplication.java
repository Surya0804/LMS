package com.example.demo.JWT_Security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.JWT_Security.entity.User;
import com.example.demo.JWT_Security.repository.UserRepository;

@SpringBootApplication
public class JwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}
	@Autowired
private UserRepository userRepository;
	@PostConstruct
	public void initUsers()
	{
		List<User> users=new ArrayList<>();

		users.add(new User(1,"surya","123","s@"));
		users.add(new User(2,"mahi","123","m@"));
		users.add(new User(3,"pawan","123","p@"));
		users.add(new User(4,"tillu","123","t@"));
		userRepository.saveAll(users);
		
	
	}

}
