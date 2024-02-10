package com.hgy.face;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hgy.tools.ScriptPath;
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration({"/spring.xml","/springmvc.xml"}) 
public class EXECUtilTest {

	
	@Autowired
	EXECUtil execUtil;
//	@Test
//	public void test() {	
//		ArrayList<String> args = new ArrayList<String>();
//		args.add("/Users/apple/Desktop/testPhoto/1/3.jpg");
//		String[] args2 = new String[args.size()];
//		args.toArray(args2);
//		String result = execUtil.execute(ScriptPath.getUploadFaceCountPath(), args2);
//		System.out.println(result);
//	}
	@Test
	public void test2() throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec("/Users/apple/anaconda2/bin/python /Users/apple/Desktop/tensorflow-face-detection-master/inference_image_segment.py /Users/apple/Desktop/apache-tomcat-8.5.32/webapps/classPhoto/20/0.7256043702408516.jpg /Users/apple/Desktop/apache-tomcat-8.5.32/webapps/classPhoto/20/face/");
		System.out.println(process.waitFor());
	}

}
