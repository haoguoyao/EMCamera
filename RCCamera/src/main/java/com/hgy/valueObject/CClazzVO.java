package com.hgy.valueObject;

import com.google.gson.Gson;

public class CClazzVO {
	private int id;
	private int courseId;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return new Gson().toJson(this);
	}
	

}
