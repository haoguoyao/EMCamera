package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import repository.InfoDAO;

public class RollCall {
	private int id;
	private int clazzID;
	private Date date;
	private List<Status> statuses;
	public RollCall() {
		// TODO Auto-generated constructor stub
	}
	public RollCall(int clazzID) {
		this.clazzID = clazzID;
		statuses = new ArrayList<Status>();
		List<Student> students = InfoDAO.retrieveStudentByClazz(clazzID);
		for(Student student:students) {
			Status status = new Status(id,student.id);
			statuses.add(status);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClazzIDd() {
		return clazzID;
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

	public List<Status> getStatus() {
		return statuses;
	}

	public void setStatus(List<Status> statuses) {
		this.statuses = statuses;
	}
}
