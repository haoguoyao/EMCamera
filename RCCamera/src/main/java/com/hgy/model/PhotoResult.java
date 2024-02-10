package com.hgy.model;

public class PhotoResult {
	private int studentID;
	private String photoURL;
	public PhotoResult() {
		// TODO Auto-generated constructor stub
	}
	public PhotoResult(int id, String photoURL) {
		this.studentID = id;
		this.photoURL = photoURL;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
