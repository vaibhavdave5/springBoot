package com.example.whiteboardsp19.dataModel;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private List<Module> modules;
	private List<Section> sections;
	
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Course() {
		modules = new ArrayList<>();
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
}
