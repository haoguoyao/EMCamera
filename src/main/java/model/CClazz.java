package model;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import jxl.read.biff.BiffException;
import service.ClazzFactory;

public class CClazz {
	private int id;
	private int courseID;
	private Set<Student> students;
	public CClazz() {
		// TODO Auto-generated constructor stub
	}
	public CClazz(int courseID) {
		this.courseID = courseID;
	}
	public CClazz(int courseID,String url) throws BiffException, IOException {
		this.courseID = courseID;
		ClazzFactory clazzFactory = new ClazzFactory(url,this);
		students = clazzFactory.getStudents();
		for(Student student:students) {
			System.out.println(student.name);
		}
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

}
