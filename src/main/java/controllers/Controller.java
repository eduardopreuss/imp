package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.User;
import repositories.UserRepository;


@RestController
public class Controller {
	
	private UserRepository userRep;
	@Autowired
	public Controller(UserRepository userRep) {
		this.userRep = userRep;
	}
	
	@RequestMapping("/api/hello")
	 public String greet() {
	  return "Hello from the other side!!!";
	 }
	
	@RequestMapping("/api/test")
	 public Iterable<User> findAll() {
	  return this.userRep.findAll();
	 }
	
}

