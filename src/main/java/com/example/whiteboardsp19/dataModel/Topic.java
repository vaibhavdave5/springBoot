package com.example.whiteboardsp19.dataModel;

import java.util.List;
import java.util.ArrayList;

public class Topic {

	private List<Widget> widgetList;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Topic() {
		widgetList = new ArrayList<>();
	}

	public List<Widget> getWidgetList() {
		return widgetList;
	}

	public void setWidgetList(List<Widget> widgetList) {
		this.widgetList = widgetList;
	}
}
