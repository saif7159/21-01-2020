package com.todo.hibernate.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@Table(name = "TODO")
public class ToDo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int todoid;
private String uid;
private String taskname;
private LocalDateTime now;
public ToDo(String uid, String taskname,LocalDateTime now) {
	super();
	this.taskname = taskname;
	this.uid = uid;
	this.now = now;
}
}
