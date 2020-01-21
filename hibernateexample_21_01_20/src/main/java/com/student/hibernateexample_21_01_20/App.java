package com.student.hibernateexample_21_01_20;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.model.Student;

public class App 
{
    public static void main( String[] args )
    {	
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
    	try {
        session.getTransaction().begin();
        String[] idarr = UUID.randomUUID().toString().split("-");
        String id = idarr[0];
        Date d = new Date();
        SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy");
        d = sdf.parse("19-02-1997");
        Student s = new Student(id, "Manu Khurana", d);
        session.save(s);
        session.getTransaction().commit();
    }
    catch (Exception e) {
		e.printStackTrace();
	}
    finally
    {
    	session.close();
    	
    }
    }
}
