package com.example.demo.Spring_Security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Spring_Security.models.User;

@Service
public class UserService {
	List<User> list=new ArrayList<>();
	public UserService()
	{
		list.add(new User("abc","123","surya@gmail.com"));
		list.add(new User("xyz","456","z@gmail.com"));

	}
	//get All users
	public List<User> getAllUsers()
	{
		return this.list;
	}
	//get single user
	public User getUserByUsername(String username)
	{
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().get();
	}
	//add user
	public User addUser(User user)
	{
		this.list.add(user);
		return user;
	}

}
