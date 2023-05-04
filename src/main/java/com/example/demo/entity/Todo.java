package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {

	@Id
	private int id;
	private String todoText;
	private boolean completed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodoText() {
		return todoText;
	}

	public void setTodoText(String todoText) {
		this.todoText = todoText;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todoText=" + todoText + ", completed=" + completed + "]";
	}

	public Todo(int id, String todoText, boolean completed) {
		super();
		this.id = id;
		this.todoText = todoText;
		this.completed = completed;
	}

	public Todo() {
		super();
	}
}
