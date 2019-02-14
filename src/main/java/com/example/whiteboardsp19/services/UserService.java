package com.example.whiteboardsp19.services;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.dataModel.User;

import java.util.*;

/**
 * This is a rest controller to make the end points for the api - user
 * 
 * @author vaibh
 *
 */
@RestController
public class UserService {
	private List<User> registerUser;
	private User currentUser;

	public UserService() {
		registerUser = new ArrayList<>();

	}

	@PostMapping("/api/register")
	public User register(@RequestBody User user) {
		if (!registerUser.contains(user)) {
			registerUser.add(user);
		}
		return user;
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
