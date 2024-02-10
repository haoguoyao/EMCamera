package com.hgy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class RollCall {
	private int id;
	private int clazzID;
	private Date date;
	private boolean onRollCall = true;
	protected Set<Status> statuses;
	
	public RollCall() {

	}

	public boolean isOnRollCall() {
		return onRollCall;
	}

	public void setOnRollCall(boolean onRollCall) {
		this.onRollCall = onRollCall;
	}
	public RollCall(CClazz clazz) {
		clazzID = clazz.getId();
		statuses = new HashSet<Status>();
		this.date = new Date();
	}
	public RollCall(CClazz clazz,Set<Status> statuses) {
		this.clazzID = clazz.getId();
		this.statuses = statuses;
		this.date = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getClazzID() {
		return clazzID;
	}

	public void setClazzID(int clazzID) {
		this.clazzID = clazzID;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
	}
//	public void setStudentStatus(Student student,boolean isArrive) {
//		setStudentStatus(student.getId(),isArrive);
//	}
//	public void setStudentStatus(int studentID,boolean isArrive) {
//		boolean isChanged = false;
//		for(Status status:statusesa) {
//			if(status.getStudentID()==studentID) {
//				isChanged = true;
//				status.setIsArrive(isArrive);
//				break;
//			}
//		}
//		if(isChanged==false) {
//			Status status = new Status(studentID);
//			status.setIsArrive(isArrive);
//			statusesa.add(status);
//		}
//	}
}
