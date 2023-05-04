package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Todo;

public interface TodoService {

	public List<Todo> getTodoList();

	public void addTodo(Todo todo);

	public void removeTodo(int id);

	public void updateTodo(Todo todo);
}
