package com.example.todoappredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoappredis.model.Todo;
import com.example.todoappredis.service.ITodoService;

@RestController
@RequestMapping("/cache")
public class CacheController {
	
	@Autowired
	ITodoService todoService;
	
	@GetMapping("/")
	public String index() 
	{
		return "Use /cache/todo route";
	}
	
	@GetMapping("/todo/{id}")
	public Todo findTodoById(@PathVariable(value = "id") Long todoId)
	{
		return todoService.getTodoById(todoId);
	}
	
	@PostMapping("/todo")
	public Todo createTodo(@RequestBody Todo todo) 
	{
		return todoService.createTodo(todo);
	}
	
	@DeleteMapping("todo/{id}")
	public boolean deleteTodo(@PathVariable(value = "id") Long todoId)
	{
		return todoService.deleteTodo(todoId);
	}

}
