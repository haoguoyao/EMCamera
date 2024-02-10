package com.hgy.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.model.Course;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private BaseDAO baseDAO;

	@Override
	public Course findCourseById(int id) {
		return (Course) baseDAO.find(Course.class, id);
	}
}
