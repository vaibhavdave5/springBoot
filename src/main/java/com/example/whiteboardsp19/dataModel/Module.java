package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Module {

	private List<Lesson> chapters;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Module() {
		this.chapters = new ArrayList<>();
	}

	public List<Lesson> getChapters() {
		return chapters;
	}

	public void setChapters(List<Lesson> chapters) {
		this.chapters = chapters;
	}
	
}
