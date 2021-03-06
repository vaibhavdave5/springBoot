package com.example.whiteboardsp19.services;


import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.dataModel.Course;
import com.example.whiteboardsp19.dataModel.Lesson;
import com.example.whiteboardsp19.dataModel.User;
import com.example.whiteboardsp19.dataModel.Module;
import com.example.whiteboardsp19.dataModel.Topic;

import java.util.*;

/**
 * This is a rest controller to make the end points for the api - user
 * 
 * @author vaibh
 *
 */

@CrossOrigin(origins="*", allowCredentials = "true")
@RestController
public class ModuleService {

	public ModuleService() {

	}
	
	@DeleteMapping("/api/modules/{mid}")
	public Course deleteModule(@PathVariable long mid, HttpSession session){
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course1 : courses) {
			for (int i=0 ; i < course1.getModules().size(); i++) {
				if (course1.getModules().get(i).getId() == mid) {
					course1.getModules().removeIf(p -> p.getId() == mid);
					return course1;
				}
			}
		}
		return null;
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(@PathVariable long mid, @RequestBody Module module, HttpSession session) {
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
	public Module findModuleById(@PathVariable long mid, HttpSession session) {
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
	public List<Module> createModule(@PathVariable long cid, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		Module module = new Module();
		
		module.setId(new Date().getTime()+1);
		
		List<Lesson> lessons = new ArrayList<>();
		module.setLessons(lessons);
		
		Lesson lesson = new Lesson();
		lessons.add(lesson);
		
		lesson.setId(new Date().getTime()+2);
		
		List<Topic> topics = new ArrayList<>();
		lesson.setTopics(topics);
		
		Topic topic = new Topic();
		topic.setId(new Date().getTime()+3);
		topics.add(topic);
		
		for (Course course : courses) {
			if (course.getId() == cid) {
				course.getModules().add(module);
				return course.getModules();
			}
		}
		return null;
	}

	@GetMapping("/api/course/{cid}/modules")
	public List<Module> findAllModules(@PathVariable long cid, HttpSession session) {
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
