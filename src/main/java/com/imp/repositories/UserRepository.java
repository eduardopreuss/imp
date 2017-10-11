package com.imp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.imp.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
