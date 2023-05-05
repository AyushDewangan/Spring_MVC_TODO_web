package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);

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
		try {
			todoRepository.save(todo);
		} catch (Exception e) {
			log.error("exception occurred while saveTodo : ", e);
		}
	}

	@Override
	public void updateTodoById(int id, String todoText) {
		try {
			Optional<Todo> todo = todoRepository.findById(id);
			todo.get().setTodoText(todoText);
			todoRepository.save(todo.get());
		} catch (Exception e) {
			log.error("exception occurred while updating text : ", e);
		}
	}

	@Override
	public void updateTodoStatus(int id) {
		try {
			Optional<Todo> todo = todoRepository.findById(id);
			if(todo.get().isCompleted() == true)
				todo.get().setCompleted(false);
			else
				todo.get().setCompleted(true);
			todoRepository.save(todo.get());
		} catch (Exception e) {
			log.error("exception occurred while updating status : ", e);
		}
	}

}
