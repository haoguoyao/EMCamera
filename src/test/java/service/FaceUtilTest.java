package service;

import static org.junit.Assert.*;

import java.io.File;

import javax.sound.midi.VoiceStatus;

import org.junit.Test;

public class FaceUtilTest extends FaceUtil {

//	@Test
//	public void test() {
//		File file = new File("/Users/apple/Desktop/5.jpg");
//		doDetect(file);
//		doFace("/Users/apple/Desktop/2.jpg", "/Users/apple/Desktop/3.jpg", 1);
//		doFace("/Users/apple/Desktop/2.jpg", "/Users/apple/Desktop/4.jpg", 1);
//		doFace("/Users/apple/Desktop/4.jpg", "/Users/apple/Desktop/3.jpg", 1);
//	}
//	@Test
//	public void test2() {
//		for(int i = 1;i<100;i++)
//		doFace("/Users/apple/Desktop/4.jpg", "/Users/apple/Desktop/3.jpg", 1);
//	}
	@Test
	public void testFaceSearch() {
		for (int i = 0; i < 10; i++) {

			File file = new File("/Users/apple/Desktop/3.jpg");
			faceSearch(file, 1);
			File file2 = new File("/Users/apple/Desktop/1.jpg");
			faceSearch(file2, 1);
			File file3 = new File("/Users/apple/Desktop/2.jpg");
			faceSearch(file3, 1);
			File file4 = new File("/Users/apple/Desktop/4.jpg");
			faceSearch(file4, 1);
		}
	}

}
