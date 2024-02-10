package com.hgy.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hgy.model.CClazz;
import com.hgy.model.Teacher;
import com.hgy.repository.TeacherService;
@Controller
public class TeacherAccountHandler {
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/teacher/TeacherAccountHandler_verifyPwd")
	@ResponseBody
	public int verifyPwdById(Integer teacherId,String pwd) {
		if(teacherId==null||pwd==null||pwd=="") {
			return 4;
		}
		int status = teacherService.verifyPwdById(teacherId, pwd);
		System.out.println("Verify pwd status is "+ status);
		return status;
	}
	@RequestMapping(value="/teacher/TeacherAccountHandler_changePwd")
	@ResponseBody
	public int changePwdById(Integer teacherId,String pwd) {
		if(teacherId==null||pwd==null||pwd=="") {
			return 4;
		}
		Teacher teacher = teacherService.getTeacherById(teacherId);
		if(teacher==null) {
			System.out.println("not exist account");
			return 0;
		}else {
			teacher.setPassword(pwd);
			teacherService.saveOrUpdateTeacher(teacher);
			System.out.println("finish update password");
			return 1;
		}
		
	
	}
	
	
	
	
}
