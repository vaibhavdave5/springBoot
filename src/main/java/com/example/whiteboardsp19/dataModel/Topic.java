package com.example.whiteboardsp19.dataModel;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Topic {

	private List<Widget> widgets;
	private long id;
	private String title;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Topic() {
		widgets = new ArrayList<>();
		title = "New Topic";
		id = new Date().getTime();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
}
