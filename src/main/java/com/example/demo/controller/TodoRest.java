package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoRest {

	Logger log = LoggerFactory.getLogger(TodoRest.class);

	@Autowired
	private TodoService todoService;

	@GetMapping("/getTodo")
	public String getTodos(Model model) {
		List<Todo> list = todoService.getTodoList();
		model.addAttribute("todoList", list);
		return "Todo";
	}

	@PostMapping("/addTodo")
	public String createTodo(@ModelAttribute("todo") Todo todo, Model model) {
		log.info("enter in addTodo Rest with Requested Data : {}", todo);
		todoService.addTodo(todo);
		List<Todo> list = todoService.getTodoList();
		model.addAttribute("todoList", list);
		return "redirect:/todo/getTodo";
	}

	@DeleteMapping("/removeTodo/{id}")
	public String deleteTodo(@PathVariable int id, Model model) {
		log.info("enter in removeTodo Rest with id : {}", id);
		todoService.removeTodo(id);
		List<Todo> list = todoService.getTodoList();
		model.addAttribute("todoList", list);
		return "Todo";
	}

	@PutMapping("/updateTodo")
	public String updateTodo(@RequestBody Todo todo, Model model) {
		todoService.updateTodo(todo);
		List<Todo> list = todoService.getTodoList();
		model.addAttribute("todoList", list);
		return "Todo";
	}

	// Might be not used for update the task completion update
//	@PutMapping("/updateTaskCompletion")
//	public String updateTaskCompletion(@RequestBody Todo todo, Model model) {
//		todoService.updateTodo(todo);
//		List<Todo> list = todoService.getTodoList();
//		model.addAttribute("todoList", list);
//		return "Todo";
//	}

}
