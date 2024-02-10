package com.hgy.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hgy.model.Student;
import com.hgy.repository.StudentService;

@Controller

public class StudentAccountHandler {
	@Autowired
	private StudentService studentDAO;
	
	@RequestMapping(value = "/wechat/studentAccountHandler/checkIdExist")
	@ResponseBody
	public Boolean checkIdExist(Integer id) throws Exception {
		if(id==null)
			return false;
		Student student = studentDAO.findById(id);
		if(student!=null) {
			return true;
		}else
			return false;
	}
	
	
}
