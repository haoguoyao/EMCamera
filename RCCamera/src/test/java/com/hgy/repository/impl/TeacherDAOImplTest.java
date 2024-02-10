package com.hgy.repository.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hgy.repository.TeacherService;
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"})
public class TeacherDAOImplTest {
	@Autowired
	private TeacherService teacherDAO;
	@Test
	public void testPwd() {
		for(int i = 1;i<3200;i++) {
			int b = i*i;
			System.out.println(b);
		}
		return;
		
	}

}
