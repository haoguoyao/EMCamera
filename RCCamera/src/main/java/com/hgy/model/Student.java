package com.hgy.model;

import java.util.Set;

import com.google.gson.annotations.Expose;

public class Student {
	@Expose
	private int id;
	@Expose
	private String url;
	@Expose
	private String name;
	@Expose
	private String openid = "xxxxx@xxx.com";
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private Set<CClazz> classes;
	public Student() {}
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Set<CClazz> getClasses() {
		return classes;
	}
	public void setClasses(Set<CClazz> courses) {
		this.classes = courses;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
