package com.imp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imp.entities.User;
import com.imp.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;

	@Autowired
	public UserService(UserRepository ur) {
		this.ur = ur;
	}

	public void saveUser(User user) {
		ur.save(user);
	}

	public Iterable<User> findUsers() {

		return ur.findAll();
	}

	public User findById(Long id) {
		return this.ur.findById(id);
	}

}
