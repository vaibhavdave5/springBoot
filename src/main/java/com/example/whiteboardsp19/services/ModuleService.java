package com.example.whiteboardsp19.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.dataModel.Course;
import com.example.whiteboardsp19.dataModel.User;
import com.example.whiteboardsp19.dataModel.Module;

import java.util.*;

/**
 * This is a rest controller to make the end points for the api - user
 * 
 * @author vaibh
 *
 */
@RestController
public class ModuleService {

	public ModuleService() {

	}
	
	@DeleteMapping("/api/modules/{mid}")
	public List<Module> deleteModule(@PathVariable int mid, HttpSession session){
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course1 : courses) {
			for (int i=0 ; i < course1.getModules().size(); i++) {
				if (course1.getModules().get(i).getId() == mid) {
					course1.getModules().removeIf(p -> p.getId() == mid);
					return course1.getModules();
				}
			}
		}
		return null;
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(@PathVariable int mid, Module module, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course1 : courses) {
			for (int i=0 ; i < course1.getModules().size(); i++) {
				if (course1.getModules().get(i).getId() == mid) {
					course1.getModules().set(i, module);
					return course1.getModules().get(i);
				}
			}
		}
		return null;
	}

	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(@PathVariable int mid, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			for (Module module : course.getModules()) {
				if (module.getId() == mid) {
					return module;
				}
			}
		}
		return null;
	}

	@PostMapping("/api/courses/{cid}/modules")
	public List<Module> createModule(@PathVariable int cid, @RequestBody Module module, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			if (course.getId() == cid) {
				course.getModules().add(module);
				return course.getModules();
			}
		}
		return null;
	}

	@GetMapping("/api/course/{cid}/modules")
	public List<Module> findAllModules(@PathVariable int cid, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			if (course.getId() == cid) {
				return course.getModules();
			}
		}
		return null;
	}

}
