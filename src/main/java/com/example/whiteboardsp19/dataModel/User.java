package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This object represents an abstract representation of User Object
 * 
 * @author Vaibhav
 *
 */
public class User {
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private List<Course> courses;

	public User() {
		courses = new ArrayList<>();
	}

	public User(Long id, String username, String firstName, String lastName, String role) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		courses = new ArrayList<>();
	}

	public User(String username, String password) {
		this.id = new Date().getTime();
		this.username = username;
		this.password = password;
		courses = new ArrayList<>();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "fName " + firstName + System.lineSeparator() + "lName " + lastName + System.lineSeparator() + "uName "
				+ username + System.lineSeparator() + "password " + password + System.lineSeparator();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof User)) {
			return false;
		}

		User u = (User) obj;

		return (this.username.equals(u.username) && this.password.equals(u.password));
	}
}
