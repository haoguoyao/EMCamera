package com.hgy.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hgy.model.CClazz;
import com.hgy.model.Course;
import com.hgy.model.RollCall;
import com.hgy.model.Status;
import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StatusService;
import com.hgy.repository.StudentService;
import com.hgy.valueObject.StatusVO;
import com.hgy.valueObject.StudentPresenceVO;

@Controller
public class StudentInfoHandler {
	@Autowired
	private StudentService studentService;
	@Autowired
	private BaseDAO baseDAO;
	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = "/student/studentInfoHandler/getStudentInfo")
	@ResponseBody
	public String getStudentInfo(Integer id) throws Exception {
		System.out.println("get Student Info id is "+id);
		Student student = studentService.findById(id);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		System.out.println(gson.toJson(student));
		return gson.toJson(student);
//		if(id!=null) {
//			
//			return student;
//		}
//		else {
//			return null;
//		}
	}
	@RequestMapping(value = "/student/studentInfoHandler/getStudentPresenceVO")
	@ResponseBody
	private String getStudentPresenceVO(Integer studentID) {
		List<Status> statuses = statusService.getStatusByStudentId(studentID);
		List<StudentPresenceVO> studentPresenceVOs = new ArrayList<>();
		for(Status status:statuses) {
			RollCall rollCall = (RollCall) baseDAO.find(RollCall.class, status.getRollCallID());
			CClazz cClazz =(CClazz) baseDAO.find(CClazz.class, rollCall.getClazzID());
			Course course=  (Course) baseDAO.find(Course.class, cClazz.getCourseID());
			Student student = (Student)baseDAO.find(Student.class, status.getStudentID());
			StudentPresenceVO studentPresenceVO = new StudentPresenceVO(student.getName(),status.getIsArrive(), rollCall.getDate(), course.getName());
			studentPresenceVOs.add(studentPresenceVO);
		}
		Gson gson = new Gson();
		return gson.toJson(studentPresenceVOs);
	}
}
