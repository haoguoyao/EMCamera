package com.hgy.repository.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hgy.model.CClazz;
import com.hgy.repository.CClazzService;
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"}) 
public class CClazzServiceImplTest {
	@Autowired
	private CClazzService clazzService;
	@Test
	public void test() {
		List<CClazz> cClazzs = clazzService.findClazzByTeacherId(123);
		for(CClazz clazz:cClazzs) {
			System.out.println(clazz.getId());
		}
	}
	@Test
	public void testFindClazzById() {
		CClazz cClazz = clazzService.findClazzById(2019000101);
		System.out.println(cClazz.getStudents().size());
	}

}
