package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
	
	private List<Topic> topics;
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

	public Lesson() {
		this.topics = new ArrayList<>();
		title = "New Lesson";
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	
	
}
