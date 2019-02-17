package com.example.whiteboardsp19.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class UserService {
	private List<User> registerUser;
	private User currentUser;

	public UserService() {
		registerUser = new ArrayList<>();
		registerUser.add(new User("John", "Missy"));

	}

	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		if (!registerUser.contains(user)) {
			registerUser.add(user);
		}
		return user;
	}

	@PostMapping("/api/profile")
	public User profile(HttpSession session) {
		return this.currentUser;
	}

	@PostMapping("/api/login")
	public User login(@RequestBody User user, HttpSession session) {
		if (this.registerUser.contains(user)) {
			this.currentUser = user;
			session.setAttribute("user", user);
		}
		return this.currentUser;
	}

	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		this.currentUser = null;
		session.invalidate();
	}

	@GetMapping("/api/users")
	public List<User> findAllUsers(HttpSession session) {
		return this.registerUser;
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") long id, HttpSession session) {

		for (User user : registerUser) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
