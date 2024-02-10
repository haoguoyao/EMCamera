package com.hgy.face;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"}) 
public class FaceCountTest {
	@Autowired
	FaceCount faceCount;
	@Test
	public void test() {
		int a;
		a = faceCount.faceCount("/Users/apple/Desktop/1.png");
		System.out.println(a);
	}

}
