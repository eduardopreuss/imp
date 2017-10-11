package com.imp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imp.entities.User;
import com.imp.repositories.UserRepository;

@RestController
public class UserController {

	private UserRepository ur;
	
	@Autowired
	public UserController(UserRepository ur) {
		this.ur = ur;
	}
	
	@GetMapping("/user")
	public String userForm(Model model, @RequestParam(value = "id", required = false) Long id) {
			model.addAttribute("user", new User());
		return "user";
	}
	
	@PostMapping("/user")
	public void addUser(@ModelAttribute User user) {
		ur.save(user);
	}
}
