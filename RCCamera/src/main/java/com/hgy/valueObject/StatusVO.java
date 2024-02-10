package com.hgy.valueObject;

import com.hgy.model.Status;

public class StatusVO extends Status{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StatusVO(Status status){
		this.setArrive(status.getIsArrive());
		this.setRollCallID(status.getRollCallID());
		this.setStudentID(status.getStudentID());
		this.setId(status.getId());
	}
	public Status getStatus() {
		Status status = new Status();
		status.setArrive(getIsArrive());
		status.setRollCallID(getRollCallID());
		status.setStudentID(getStudentID());
		status.setId(getId());
		return status;
	}

}
