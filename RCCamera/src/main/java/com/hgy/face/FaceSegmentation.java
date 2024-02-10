package com.hgy.face;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.tools.ScriptPath;
@Service
public class FaceSegmentation {
	@Autowired
	private EXECUtil execUtil;
	/**
	 *  filePath 被分割图像位置
	 *  folderPath 进行分割后小头像的存放位置
	 * 
	 * 
	 * */
	public void faceSegmentation(String filePath,String folderPath) throws IOException, InterruptedException {
		String[]args = {filePath,folderPath};
		String result = execUtil.execute(ScriptPath.getPhotoSegmentPath(), args);
	}
	
	
	

}
