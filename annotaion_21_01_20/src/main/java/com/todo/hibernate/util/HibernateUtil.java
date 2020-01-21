package com.todo.hibernate.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.todo.hibernate.model.ToDo;

public class HibernateUtil {
private static SessionFactory factory = null;
static {
	factory = new Configuration().configure().addAnnotatedClass(ToDo.class).buildSessionFactory();
	
}
private HibernateUtil() {}
public static Session getSession()
{
	return factory.openSession();
}
}
