package com.hgy.repository;

import com.hgy.model.Student;

public interface StudentService {
	public boolean openidBinded(String openid);
	public void createStudent(Student student);
	public Student findByOpenid(String openid);
	public Student findById(Integer id);
	public void updateUrl(Integer id,String url);

}
