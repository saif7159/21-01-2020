package com.todo.hibernate.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.todo.hibernate.model.ToDo;
import com.todo.hibernate.util.HibernateUtil;

public class ToDoDaoImpl implements ToDoDao {
	
	private Session s = null;
	private Transaction transaction=null;
	List<ToDo> list = null;
	{	
		
		s = HibernateUtil.getSession();
		transaction = s.getTransaction();
		list = new ArrayList<ToDo>();
		
	}
	
	
	@Override
	public ToDo createToDo(ToDo todo) {
		transaction.begin();
		s.save(todo);
		transaction.commit();
		return todo;
	}

	@Override
	public List<ToDo> getAllToDo() {
		list = s.createQuery("from ToDo").list();
		return list;
		
	}

	@Override
	public ToDo findById(int id) {
		ToDo todo = s.get(ToDo.class, id);
		return todo;
	}

	@Override
	public ToDo updateToDo(int id, String taskname, LocalDateTime now) {
		
		ToDo todo = s.get(ToDo.class, id);
		if(todo!=null)
		{	transaction.begin();
			todo.setTaskname(taskname);
			todo.setNow(now);
			s.save(todo);
			transaction.commit();
			System.out.println("Updated");
		}
		return todo;	
	}

	@Override
	public void deleteTodo(int id) {
		ToDo todo = s.get(ToDo.class, id);
		if(todo!=null)
		{	transaction.begin();
			s.delete(todo);
			transaction.commit();
			System.out.println("Deleted");
		}
		
	}

	@Override
	public void saveAndExit() {
		s.close();
		System.exit(0);
		
	}



}
