package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
	
	private List<Topic> topics;
	
	public Lesson() {
		this.topics = new ArrayList<>();
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	
	
}
