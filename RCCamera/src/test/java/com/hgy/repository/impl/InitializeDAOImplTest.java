package com.hgy.repository.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hgy.repository.impl.InitializeDAOImpl;  

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"}) 
public class InitializeDAOImplTest extends InitializeDAOImpl{
	
	@Test
	public void testTruncateAll() {
		System.out.println("-------beginning-------");
		truncateAll();
	}

}
