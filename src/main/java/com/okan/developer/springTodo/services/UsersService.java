package com.okan.developer.springTodo.services;

import org.springframework.stereotype.Service;

import com.okan.developer.springTodo.models.Users;
import com.okan.developer.springTodo.repositories.UsersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	public Users registerUsers(String userName, String password, String email) {
		if(userName == null || password == null) {
			return null;
		}else {
			Users users = new Users();
			users.setUserName(userName);
			users.setPassword(password);
			users.setEmail(email);
			return usersRepository.save(users);
		}
	}
	
	public Users authenticate(String userName, String password) {
		return usersRepository.findByUserNameAndPassword(userName, password).orElse(null);
	}

}
