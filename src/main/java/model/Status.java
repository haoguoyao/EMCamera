package model;

public class Status {
	private int id;
	private int studentID;
	private int rollCallID;
	private boolean isArrive;
	public Status() {
		// TODO Auto-generated constructor stub
	}
	public Status(int rollCallID,int studentID) {
		this.studentID = studentID;
		this.rollCallID = rollCallID;
		this.isArrive = true;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getRollCallID() {
		return rollCallID;
	}
	public void setRollCallID(int rollCallID) {
		this.rollCallID = rollCallID;
	}
	public boolean isArrive() {
		return isArrive;
	}
	public void setArrive(boolean isArrive) {
		this.isArrive = isArrive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
