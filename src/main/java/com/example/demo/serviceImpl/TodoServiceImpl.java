package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void updateTodoById(int id, String todoText) {
		Optional<Todo> todo = todoRepository.findById(id);
		todo.get().setTodoText(todoText);
		todoRepository.save(todo.get());
	}

	@Override
	public void updateTodoStatus(int id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if(todo.get().isCompleted()==true)
			todo.get().setCompleted(false);
		else
			todo.get().setCompleted(true);
		todoRepository.save(todo.get());
		
	}

}
