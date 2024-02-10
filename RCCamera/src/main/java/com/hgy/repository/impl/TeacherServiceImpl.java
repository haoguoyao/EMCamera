package com.hgy.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.model.Teacher;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private BaseDAO baseDAO;

	
	@Override
	public Teacher getTeacherById(Integer id) {
		Teacher teacher = (Teacher) baseDAO.find(Teacher.class, id);
		return teacher;
	}


	@Override
	public int verifyPwdById(Integer id, String pwd) {
		Teacher teacher = (Teacher) baseDAO.find(Teacher.class, id);	
		if(teacher==null)
			return 2;
		else {
			System.out.println(teacher.getPassword());
			System.out.println(pwd);
			if(teacher.getPassword().equals(pwd)) {
				return 1;
			}else {
				return 0;
			}
		}
	}


	@Override
	public int saveOrUpdateTeacher(Teacher teacher) {
		baseDAO.save(teacher);
		return 1;
	}

}
