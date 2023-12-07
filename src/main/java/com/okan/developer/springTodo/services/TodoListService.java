package com.okan.developer.springTodo.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okan.developer.springTodo.models.TodoList;
import com.okan.developer.springTodo.repositories.TodoListRepository;

@Service
public class TodoListService {
	@Autowired
	private TodoListRepository todoListRepository;

	
	  public Iterable<TodoList> getAll(String keyword) { if(keyword != null) {
	  return todoListRepository.findAll(keyword); } return
	  todoListRepository.findAll(); }
	 
	

	public Optional<TodoList> getById(Long id) {
		return todoListRepository.findById(id);
	}

	public TodoList save(TodoList todoList) {
		if (todoList.getId() == null) {
			todoList.setDate(LocalDate.now());
		}
		return todoListRepository.save(todoList);
	}

	public void delete(TodoList todoList) {
		todoListRepository.delete(todoList);
	}

}
