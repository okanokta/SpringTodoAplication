package com.okan.developer.springTodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.okan.developer.springTodo.models.TodoList;
import com.okan.developer.springTodo.services.TodoListService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class TodoFormController {
	@Autowired
	public TodoListService todoListService;

	@GetMapping("/create-todo")
	public String showCreateForm(TodoList todoList) {
		
		return "new-todo-list";

	}

	@PostMapping("/todo")
	public String createTodoList(@Valid TodoList todoList, BindingResult bindingResult, Model model) {
		
		TodoList list = new TodoList();
		list.setTitle(todoList.getTitle());
		list.setDescription(todoList.getDescription());
		list.setCompleted(todoList.getCompleted());
		todoListService.save(todoList);

		return "redirect:/todo";
	}

	@GetMapping("/delete/{id}")
	public String deleteTodoList(@PathVariable("id") Long id, Model model) {
		TodoList todoList = todoListService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("TodoList id:" + id + " not found"));
		todoListService.delete(todoList);
		return "redirect:/todo";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		
		TodoList todoList = todoListService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("TodoList id:" + id + " not found"));
		model.addAttribute("todo", todoList);
		return "edit-todo-list";

	}

	@PostMapping("/todo/{id}")
	public String updateTodoList(@PathVariable("id") Long id, @Valid TodoList todoList, BindingResult bindingResult,
			Model model) {
		
		TodoList list = todoListService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("TodoList id:" + id + " not found"));
		list.setCompleted(todoList.getCompleted());
		list.setDescription(todoList.getDescription());
		todoListService.save(list);
		return "redirect:/todo";
	}

}
