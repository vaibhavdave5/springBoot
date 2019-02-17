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

import com.example.whiteboardsp19.dataModel.Course;
import com.example.whiteboardsp19.dataModel.Lesson;
import com.example.whiteboardsp19.dataModel.Module;
import com.example.whiteboardsp19.dataModel.Topic;
import com.example.whiteboardsp19.dataModel.User;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")

@RestController
public class LessonService {

	public LessonService() {
	}

	@DeleteMapping("/api/lesson/{lid}")
	public List<Lesson> deleteLesson(@PathVariable("lid") long lid, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for (int i = 0; i < module.getLessons().size(); i++) {
					if (module.getLessons().get(i).getId() == lid) {
						module.getLessons().removeIf(p -> p.getId() == lid);
						return module.getLessons();
					}
				}
			}
		}
		return null;
	}

	@PutMapping("/api/lesson/{lid}")
	public Lesson updateLesson(@PathVariable("lid") long lid, @RequestBody Lesson lesson, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for (int i = 0; i < module.getLessons().size(); i++) {
					if (module.getLessons().get(i).getId() == lid) {
						module.getLessons().set(i, lesson);
						System.out.println(module.getLessons().get(i).getTitle());
						return lesson;
					}
				}
			}
		}
		return null;
	}

	@GetMapping("/api/lesson/{lid}")
	public Lesson findLessonById(@PathVariable("lid") long lid, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			for (Module module : course.getModules()) {
				for (Lesson lesson : module.getLessons()) {
					if (lesson.getId() == lid) {
						return lesson;
					}
				}
			}
		}
		return null;
	}

	@GetMapping("/api/module/{mid}/lesson")
	public List<Lesson> findAllLessons(@PathVariable("mid") long mid, HttpSession session) {
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();
		for (Course course : courses) {
			for (Module module : course.getModules()) {
				if (module.getId() == mid) {
					return module.getLessons();
				}
			}
		}
		return null;
	}

	@PostMapping("/api/module/{mid}/lesson")
	public void createLesson(@PathVariable long mid, @RequestBody Lesson lesson, HttpSession session) {

		Lesson lesson2 = new Lesson();
		
		lesson2.setId(new Date().getTime()+2);
		
		List<Topic> topics = new ArrayList<>();
		lesson2.setTopics(topics);
		
		Topic topic = new Topic();
		topic.setId(new Date().getTime()+3);
		topics.add(topic);
		
		User fac = (User) session.getAttribute("user");
		List<Course> courses = fac.getCourses();

		for (Course course : courses) {
			for (Module module : course.getModules()) {
				if (module.getId() == mid) {
					module.getLessons().add(lesson2);
				}
			}
		}
	}

}
