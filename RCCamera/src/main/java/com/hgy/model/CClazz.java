package com.hgy.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.annotations.Expose;

import jxl.read.biff.BiffException;

public class CClazz {
	@Expose
	private int id;
	@Expose
	private int courseID;
	@Expose
	private int teacherID;
	
	protected Set<Student> students;
	
	public CClazz() {
		// TODO Auto-generated constructor stub
	}
	public CClazz(int courseID) {
		this.courseID = courseID;
	}
//	public CClazz(int courseID,String url) throws BiffException, IOException {
//		this.courseID = courseID;
//		ClazzFactory clazzFactory = new ClazzFactory(url,this);
//		students = clazzFactory.getStudents();
//		for(Student student:students) {
//			System.out.println(student.name);
//		}
//	}
	public CClazz(int courseID,int teacherID) throws BiffException, IOException {
		this.courseID = courseID;
		this.teacherID = teacherID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

}
