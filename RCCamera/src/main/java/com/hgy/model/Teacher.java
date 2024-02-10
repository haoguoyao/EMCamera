package com.hgy.model;

public class Teacher extends User{
	private String password;
	public Teacher() {
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Teacher(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		// TODO Auto-generated constructor stub
	}

}
