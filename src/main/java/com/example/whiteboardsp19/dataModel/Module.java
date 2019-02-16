package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Module {

	private List<Lesson> lessons;
	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	private long id;
	private String title;
	
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Module() {
		this.lessons = new ArrayList<>();
		this.title = "New Module";
	}

	
	
}
