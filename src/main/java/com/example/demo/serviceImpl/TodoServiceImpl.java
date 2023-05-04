package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getTodoList() {
		return todoRepository.findAll();
	}

	@Override
	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public void removeTodo(int id) {
		todoRepository.deleteById(id);
	}

	@Override
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
		
	}

}
