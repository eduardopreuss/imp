package com.imp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imp.entities.User;
import com.imp.services.UserService;

@RestController
public class UserController {

	private UserService us;


	@GetMapping("/user")
	public String userForm(Model model, @RequestParam(value = "id", required = false) Long id) {
		model.addAttribute("user", new User());
		return "user";
	}

	@PostMapping("/user")
	public void user(@ModelAttribute User user) {
		us.saveUser(user);
	}
}
