package com.okan.developer.springTodo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.okan.developer.springTodo.models.TodoList;
@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long>{
	@Query("SELECT t FROM TodoList t WHERE t.title LIKE %?1%")
	public List<TodoList> findAll(String keyword);
	
	
}
