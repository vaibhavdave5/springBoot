package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.whiteboardsp19.dataModel.Lesson;
import com.example.whiteboardsp19.dataModel.User;

public class LessonService {

	
	
	public LessonService() {

	}

	@PostMapping("/api/module/{mid}/lesson")
	public void createLesson(@PathVariable int mid, @RequestBody Lesson lesson) {
		
	}

	@PostMapping("/api/profile")
	public User profile() {
		return this.currentUser;
	}

	@PostMapping("/api/login")
	public User login(@RequestBody User user) {
		if (this.registerUser.contains(user)) {
			this.currentUser = user;
		}
		return this.currentUser;
	}

	@PostMapping("/api/logout")
	public void logout() {
		this.currentUser = null;
	}

	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return this.registerUser;
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int id) {

		for (User user : registerUser) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

}
