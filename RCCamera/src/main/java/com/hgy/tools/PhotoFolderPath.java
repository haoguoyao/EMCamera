package com.hgy.tools;

import java.io.File;

public class PhotoFolderPath {
	private static final String classPhotoPath = "classPhoto/";
	private static final String personalPhotoPath="personalPhoto/";
	
	/**
	 * 返回路径时检测路径是否存在，如果不存在，创建该路径。
	 * 
	 * */
	public static String getClassphotopath() {
		
		File file  = new File(System.getProperty("catalina.home")+"/webapps/classPhoto");
		if(!file.exists()) {
			file.mkdir();
			System.out.println("Folder not exist, has been created");
		}
		return file.getAbsolutePath();
	}
	public static String getPersonalphotopath() {
		File file  = new File(System.getProperty("catalina.home")+"/webapps/personalPhoto");
		if(!file.exists()) {
			file.mkdir();
			System.out.println("Folder not exist, has been created");
		}
		return file.getAbsolutePath();
	}
	public static String getPhotoParentPath() {
		File file  = new File(System.getProperty("catalina.home")+"/webapps");
		if(!file.exists()) {
			file.mkdir();
			System.out.println("Folder not exist, has been created");
		}
		return file.getAbsolutePath();
	}
	
}
