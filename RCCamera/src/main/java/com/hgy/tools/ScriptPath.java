package com.hgy.tools;

public class ScriptPath {
	private static final String upload_face_count_path = "/Users/apple/Desktop/tensorflow-face-detection-master/upload_face_count.py"; 
	private static final String face_compare_path = "/Users/apple/Desktop/tensorflow-face-detection-master/face_compare.py";
	private static final String photo_segment_path = "/Users/apple/Desktop/tensorflow-face-detection-master/inference_image_segment.py";
//	private static final String upload_face_count_path = "/root/Scripts/upload_face_count.py"; 
//	private static final String face_compare_path = "/root/Scripts/face_compare.py";
//	private static final String photo_segment_path = "/root/Scripts/inference_image_segment.py";
	public static String getUploadFaceCountPath() {
		return upload_face_count_path;
	}
	public static String getPhotoSegmentPath() {
		return photo_segment_path;
	}
	public static String getFaceComparePath() {
		return face_compare_path;
	}
}
