package com.okan.developer.springTodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.okan.developer.springTodo.services.TodoListService;

@Controller

public class HomeController {
	@Autowired
	private TodoListService todoListService;
	
	
	  @GetMapping("/todo") public ModelAndView index(String keyword) {
	  
	  ModelAndView modelAndView = new ModelAndView("todo");
	  modelAndView.addObject("todoList", todoListService.getAll(keyword)); return
	  modelAndView; }
	 
	
	

}
