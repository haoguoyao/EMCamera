package com.hgy.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	BaseDAO baseDAO;
	
	
	@Override
	public boolean openidBinded(String openid) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("openid", openid);
		criterions.add(criterion1);
		List<Student> students = baseDAO.queryByCriteria(Student.class, criterions);
		if(students.isEmpty())
			return false;
		else
			return true;
	}
	@Override
	public Student findByOpenid(String openid) {
		List<Criterion> criterions = new ArrayList<>();
		Criterion criterion1 = Restrictions.eq("openid", openid);
		criterions.add(criterion1);
		List<Student> students = baseDAO.queryByCriteria(Student.class, criterions);
		if(students.isEmpty())
			return null;
		else
			return students.get(0);
	}
	@Override
	public Student findById(Integer id) {
		Student student = (Student) baseDAO.find(Student.class, id);
		return student;
	}
	@Override
	public void updateUrl(Integer id,String url) {
		Student student = findById(id);
		student.setUrl(url);
		System.out.println(student.getId());
		baseDAO.save(student);
	}
	@Override
	public void createStudent(Student student) {
		baseDAO.create(student);
	}

}
