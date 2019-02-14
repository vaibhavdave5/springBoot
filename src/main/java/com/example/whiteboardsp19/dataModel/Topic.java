package com.example.whiteboardsp19.dataModel;

import java.util.List;
import java.util.ArrayList;

public class Topic {
	
	public List<Widget> getWidgetList() {
		return widgetList;
	}

	public void setWidgetList(List<Widget> widgetList) {
		this.widgetList = widgetList;
	}

	private List<Widget> widgetList;
	
	public Topic() {
		widgetList = new ArrayList<>();
	}
}
