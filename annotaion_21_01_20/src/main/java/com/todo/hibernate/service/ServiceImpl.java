package com.todo.hibernate.service;

import java.time.LocalDateTime;
import java.util.List;

import com.todo.hibernate.dao.ToDoDaoImpl;
import com.todo.hibernate.model.ToDo;

public class ServiceImpl implements Service {
	ToDoDaoImpl tdao = null;
	{
		tdao = new ToDoDaoImpl();
	}
	@Override
	public ToDo createToDo(ToDo todo) {
		
		return tdao.createToDo(todo);
	}

	@Override
	public List<ToDo> getAllToDo() {
		
		return tdao.getAllToDo();
	}

	@Override
	public ToDo findById(int id) {
		
		return tdao.findById(id);
	}

	@Override
	public ToDo updateToDo(int id, String taskname, LocalDateTime now) {
		
		return tdao.updateToDo(id, taskname, now);
	}

	@Override
	public void deleteTodo(int id) {
		tdao.deleteTodo(id);
		
	}

	@Override
	public void saveAndExit() {
		tdao.saveAndExit();
		
	}

}
