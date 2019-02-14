package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Module {

	private List<Lesson> chapters;
	
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
