package com.imp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.imp.entities.User;
import com.imp.services.UserService;

@RestController
public class UserController {

	private UserService us;

	public UserController(UserService us) {
		this.us = us;
	}

	@GetMapping("/user")
	public User getUserBy(@RequestParam(value = "id", required = false) Long id) {
		User user = us.findById(id);
		return user;
	}


	@RequestMapping("/api/user")
	public void user(@RequestBody User user) {
		us.saveUser(user);
	}

	@GetMapping("/users")
	public Iterable<User> getAllUsers(){
		return us.findUsers();
	}

}
