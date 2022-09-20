package com.ToDoList.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name="USER")
public class User {
	
	
	private String Name;
	
	
	private String Email;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id 
	private int SerialNo;
	
	private String role;
	
	@NotBlank
	private String Password;
	
	private String Profession;
	private int  ToDoCount;
	private String Image;
	
	@OneToMany(cascade= CascadeType.ALL,orphanRemoval = true)
	private List<Tasks> tasks = new ArrayList<Tasks>();

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}

	

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public int getToDoCount() {
		return ToDoCount;
	}

	public void setToDoCount(int toDoCount) {
		ToDoCount = toDoCount;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	
	

}
