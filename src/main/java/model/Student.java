package model;

import java.util.Set;

public class Student extends User{
	private String mailBox = "xxxxx@xxx.com";
	private Set<CClazz> classes;
	public Student() {}
	public Student(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.password = pwd;
	}
	public String getStudentMailBox() {
		return mailBox;
	}
	public void setStudentMailBox(String studentMailBox) {
		this.mailBox = studentMailBox;
	}
	public String getMailBox() {
		return mailBox;
	}
	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}
	public Set<CClazz> getCourses() {
		return classes;
	}
	public void setCourses(Set<CClazz> courses) {
		this.classes = courses;
	}

}
