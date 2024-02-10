package com.hgy.model;

public class RollCallPhoto {
	private int id;
	private int callOverID;
	private String photoURL;
	public RollCallPhoto() {
		// TODO Auto-generated constructor stub
	}
	public RollCallPhoto(int callOverID, String photoURL) {
		this.callOverID = callOverID;
		this.photoURL = photoURL;
	}
	public int getCallOverID() {
		return callOverID;
	}
	public void setCallOverID(int callOverID) {
		this.callOverID = callOverID;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
