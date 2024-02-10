package com.hgy.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hgy.model.CClazz;
import com.hgy.model.Course;
import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.CClazzService;
import com.hgy.repository.CourseService;
import com.hgy.repository.impl.CClazzServiceImpl;
import com.hgy.valueObject.CClazzVO;

@Controller
public class TeacherCClazzHandler {
	
	@Autowired
	private CClazzService cClazzDAO;
	@Autowired
	private CourseService courseDAO;
	
	@RequestMapping(value = "/teacher/CClazzHandler_getCClazz")
	@ResponseBody
	public String getCClazz(Integer id) {
		System.out.println("Get class of teacher ID "+id);
		
		List<CClazz> clazzs = cClazzDAO.findClazzByTeacherId(id);
		List<CClazzVO> cClazzVOs = new ArrayList<>();
		if(!clazzs.isEmpty()) {
			for(CClazz cClazz:clazzs) {
				Course course = courseDAO.findCourseById(cClazz.getCourseID());
				CClazzVO cClazzVO = new CClazzVO();
				cClazzVO.setCourseId(course.getId());
				cClazzVO.setId(cClazz.getId());
				cClazzVO.setName(course.getName());
				cClazzVOs.add(cClazzVO);
				System.out.println(cClazzVO.toString());
			}
		}
		//Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Gson gson = new Gson();
		String clazzsString = gson.toJson(cClazzVOs);
		
		System.out.println("ClazzsString is "+clazzsString);
		return clazzsString;
		
	}

}
