package com.hgy.repository;

import com.hgy.model.Teacher;

public interface TeacherService {
	public int verifyPwdById(Integer id,String pwd);
	public Teacher getTeacherById(Integer id);
	public int saveOrUpdateTeacher(Teacher teacher);

}
