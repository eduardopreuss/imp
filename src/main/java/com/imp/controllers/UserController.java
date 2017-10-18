package com.imp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imp.entities.User;
import com.imp.enums.EmploymentStatus;
import com.imp.services.UserService;

@RestController
public class UserController {

private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	

	
	@GetMapping("/user")
	public User getUserBy(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "badge", required = false) String badge) {
		User user = new User();
		if(id!=null) {
			user = userService.findById(id);	
		}else {
			if(name!=null) {
				user = userService.findByName(name);
			}else {
				if(email!=null) {
					user = userService.findByEmail(email);
				}else {
					user = userService.findByBagde(badge);
				}
			}
		}
					
		return user;		
	}

	@GetMapping("/users")
	public Iterable<User> getAllUsers(){
		return userService.findUsers();
	}
	
}
