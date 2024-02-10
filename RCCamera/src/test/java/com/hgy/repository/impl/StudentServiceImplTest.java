package com.hgy.repository.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StudentService;
import com.hgy.repository.impl.StudentServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"})
public class StudentServiceImplTest extends StudentServiceImpl{
	
	@Autowired
	StudentService studentDAO;
	@Autowired
	BaseDAO baseDAO;

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setId(1235);
		baseDAO.create(student);
//		studentDAO.createStudent(student);
	}
	@Test
	public void testUpdateStudent() {
		studentDAO.updateUrl(1236, "neu");
	}

}
