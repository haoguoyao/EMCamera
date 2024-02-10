package com.hgy.valueObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentPresenceVO {
	private String name;
    private boolean state;
    private String date;
    private String course;

    public String getName() {
        return name;
    }

    public boolean isArrivable() {
        return state;
    }

    public String getDate() {
        return date;
    }
    public String getCourse(){
        return course;
    }

    public StudentPresenceVO(String name, int state, Date date, String course) {
        this.name = name;
        if(state==0)
        		this.state = false;
        else {
			this.state = true;
		}
        this.date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        this.course = course;
    }
}
