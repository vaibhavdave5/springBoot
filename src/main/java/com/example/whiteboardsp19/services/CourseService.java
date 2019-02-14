package com.example.whiteboardsp19.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.dataModel.Course;
import com.example.whiteboardsp19.dataModel.User;

@RestController
public class CourseService {

	public CourseService() {
	}
	
	@PostMapping("/api/courses")
	public void createCourse(@RequestParam Course course, HttpSession session) {
		User fac = (User)session.getAttribute("user");
		fac.getCourses().add(course);
	}
	
	@GetMapping("/api/courses")
	public List<Course> findAllCourses(HttpSession session) {
		User fac = (User)session.getAttribute("user");
		return fac.getCourses();
	}
	
	@GetMapping("/api/courses/{cid}")
	public Course findCourseById(@PathVariable("cid") int cid, HttpSession session) {
		User fac = (User)session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		
		for(Course course : courses) {
			if(cid == course.getId()) {
				return course;
			}
		}
		return null;
	}
	
	@PutMapping("/api/courses/{cid}")
	public Course updateCourse(@PathVariable("cid") int cid,@RequestBody Course newCourse, HttpSession session) {
		User fac = (User)session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		
		for(int i=0 ; i < courses.size(); i++) {
			if(cid == courses.get(i).getId()) {
				courses.set(i, newCourse);
				return newCourse;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/courses/{cid}")
	public List<Course> deleteCourse(@PathVariable int cid, HttpSession session){
		User fac = (User)session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		courses.removeIf(p -> p.getId() == cid);
		return courses;
	}
	
	
}
