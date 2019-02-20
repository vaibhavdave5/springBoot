package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.whiteboardsp19.dataModel.Module;
import com.example.whiteboardsp19.dataModel.Topic;
import com.example.whiteboardsp19.dataModel.Course;
import com.example.whiteboardsp19.dataModel.Lesson;
import com.example.whiteboardsp19.dataModel.User;

@CrossOrigin(origins="*", allowCredentials = "true")
@RestController
public class CourseService {

	public CourseService() {
	}
	
	@PostMapping("/api/courses")
	public Course createCourse(@RequestBody Course course, HttpSession session) {
		Course course1 = new Course();
		course1.setId(new Date().getTime());
		course1.setTitle("New Course");
		
		List<Module> modules = new ArrayList<>();
		course1.setModules(modules);
		
		Module module = new Module();
		modules.add(module);
		
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
		
		User fac = (User)session.getAttribute("user");
		fac.getCourses().add(course1);
		return course1;
	}
	
	@GetMapping("/api/courses")
	public List<Course> findAllCourses(HttpSession session) {
		User fac = (User)session.getAttribute("user");
		return fac.getCourses();
	}
	
	@GetMapping("/api/courses/{cid}")
	public Course findCourseById(@PathVariable("cid") long cid, HttpSession session) {
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
	public Course updateCourse(@PathVariable("cid") long cid,@RequestBody Course newCourse, HttpSession session) {
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
	public List<Course> deleteCourse(@PathVariable long cid, HttpSession session){
		User fac = (User)session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		courses.removeIf(p -> p.getId() == cid);
		return courses;
	}
	
	
}
