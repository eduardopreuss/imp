package com.imp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.imp.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findById(Long id);
	
	public User findByName(String name);
	
	public User findByBadge(String bagde);
	
	public User findByEmail(String email);
	
}
