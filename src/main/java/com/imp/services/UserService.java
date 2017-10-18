package com.imp.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imp.entities.User;
import com.imp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	public boolean exists(User user) {
		return userRepository.exists(Long.parseLong(user.getBadge()));
	}

	public Iterable<User> findUsers() {
		
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return this.userRepository.findById(id);
	}
	
	public User findByName(String name) {
		return this.userRepository.findByName(name);
	}
	
	public User findByBagde(String bagde) {
		return this.userRepository.findByBadge(bagde);
	}
	
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}



}
