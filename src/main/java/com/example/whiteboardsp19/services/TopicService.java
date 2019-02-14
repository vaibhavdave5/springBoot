package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.dataModel.Course;
import com.example.whiteboardsp19.dataModel.Lesson;
import com.example.whiteboardsp19.dataModel.Module;
import com.example.whiteboardsp19.dataModel.Topic;
import com.example.whiteboardsp19.dataModel.User;

@RestController
public class TopicService {

//DELETE /api/topic/{tid}
//deleteTopic(tid)
//Delete topic whose id is tid
	public TopicService() {}

	@DeleteMapping("/api/topic/{tid}")
	public List<Topic> deleteTopic(@PathVariable int tid,HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();

		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for(Lesson lesson1 : module.getLessons()) {
					lesson1.getTopics().removeIf(p -> p.getId() == tid);
				}
			}
		}
		return null;
	}
	
	
	@PutMapping("/api/topic/{tid}")
	public Topic updateTopic(@PathVariable int tid, Topic topic, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();

		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for(Lesson lesson1 : module.getLessons()) {
					for(int i=0; i < lesson1.getTopics().size(); i++) {	
						if(lesson1.getTopics().get(i).getId() == tid) {
							lesson1.getTopics().set(i, topic);
							return topic;
						}
					}
				}
			}
		}
		return null;
	}
	
	@GetMapping("/api/topic/{tid}")
	public Topic findTopicById(@PathVariable int tid, HttpSession session){
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();

		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for(Lesson lesson : module.getLessons()) {
					for(Topic topic: lesson.getTopics()) {	
						if(topic.getId() == tid) {
							return topic;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	
	@GetMapping("/api/lesson/{lid}/topic")
	public List<Topic> findAllTopics(@PathVariable int lid, HttpSession session){
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();

		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for(Lesson lesson : module.getLessons()) {
					if(lesson.getId() == lid) {
						return lesson.getTopics();
					}
				}
			}
		}
		return null;
	}
		
	
	
	
	
	@PostMapping("/api/lesson/{lid}/topic")
	public void createTopic(@PathVariable int lid, 
							@RequestBody Topic topic, 
							HttpSession session) {

		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();

		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for(Lesson lesson : module.getLessons()) {
					if(lesson.getId() == lid) {
						lesson.getTopics().add(topic);
					}
				}
			}
		}
	}


}
