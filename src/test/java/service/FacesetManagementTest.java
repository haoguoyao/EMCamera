package service;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FacesetManagementTest extends FacesetManagement{

//	@Test
//	public void testFaceSetCreate() {
//		createFaceSet(1);
//	}
	@Test
	public void testAddFaceToSet() {
		File file = new File("/Users/apple/Desktop/4.jpg");
		String token1 = doDetectReturnToken(file);
		addFaceToSet(1, token1);
		File file2 = new File("/Users/apple/Desktop/1.jpg");
		String token2 = doDetectReturnToken(file2);
		addFaceToSet(1, token2);
		File file3 = new File("/Users/apple/Desktop/2.jpg");
		String token3 = doDetectReturnToken(file3);
		addFaceToSet(1, token3);
		File file4 = new File("/Users/apple/Desktop/3.jpg");
		String token4 = doDetectReturnToken(file4);
		addFaceToSet(1, token4);
		
	}

}
