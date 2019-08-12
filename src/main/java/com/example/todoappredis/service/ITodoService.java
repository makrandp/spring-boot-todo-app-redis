package com.example.todoappredis.service;

import com.example.todoappredis.model.Todo;

public interface ITodoService {
	
	public Todo createTodo(Todo todo);
	public Todo getTodoById(Long todoId);
	public boolean deleteTodo(Long todoId); 
}
