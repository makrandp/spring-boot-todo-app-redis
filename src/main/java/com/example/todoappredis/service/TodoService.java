package com.example.todoappredis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoappredis.cache.Cache;
import com.example.todoappredis.model.Todo;

import redis.clients.jedis.Jedis;

@Service
public class TodoService implements ITodoService {

	@Autowired
	private Cache cache;
	private Jedis jedis;
	private String todoCachePrefix = "todo_";
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Todo createTodo(Todo todo) {
		Long todoId = todo.getId();
		return (Todo) cache.setItem(todoCachePrefix + todoId, todo);
	}

	@Override
	public Todo getTodoById(Long id) {
		return (Todo) cache.getItem(todoCachePrefix + id, Todo.class);
	}

	@Override
	public boolean deleteTodo(Long todoId) {
		return cache.deleteItem(todoCachePrefix + todoId);
	}

}
