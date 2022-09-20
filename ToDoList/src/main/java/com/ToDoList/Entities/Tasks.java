package com.ToDoList.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TASKS")
public class Tasks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int TaskNo;
	private String Date;
	private  String Description;
	private String Status;
	private String Heading;
	
	@ManyToOne
	private User user;

	public int getTaskNo() {
		return TaskNo;
	}

	public void setTaskNo(int taskNo) {
		TaskNo = taskNo;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getHeading() {
		return Heading;
	}

	public void setHeading(String heading) {
		Heading = heading;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
