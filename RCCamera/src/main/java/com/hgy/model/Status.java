package com.hgy.model;

public class Status {
	private int id;
	private int studentID;
	private int isArrive;
	private int rollCallID;
	
	public Status() {

	}
	public int getRollCallID() {
		return rollCallID;
	}
	public void setRollCallID(int rollCallID) {
		this.rollCallID = rollCallID;
	}
	public void setArrive(int isArrive) {
		this.isArrive = isArrive;
	}
	public Status(int studentID) {
		this.studentID = studentID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getIsArrive() {
		return isArrive;
	}
	public void setIsArrive(int isArrive) {
		this.isArrive = isArrive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
