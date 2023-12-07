package com.okan.developer.springTodo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okan.developer.springTodo.models.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	
	Optional<Users> findByUserNameAndPassword(String userName, String password);

}
