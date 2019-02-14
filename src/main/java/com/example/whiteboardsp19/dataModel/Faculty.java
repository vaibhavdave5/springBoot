package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Person{
	private List<Course> courses;
	private List<Section> sections;
	
	public Faculty() {
		this.courses = new ArrayList<>();
		this.sections = new ArrayList<>();
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
}
