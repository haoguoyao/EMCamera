package com.hgy.face;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.model.Status;
import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StatusService;
import com.hgy.tools.PhotoFolderPath;
import com.hgy.tools.ScriptPath;
@Service
public class FaceRecognition {
	
	@Autowired
	private EXECUtil execUtil;
	@Autowired
	private StatusService statusService;
	/**
	 *  @param pafile1Path，file2Path：两张进行对比的图像的位置
	 *  
	 *  
	 *  @return 返回判断
	 * 
	 * 
	 * */
	public boolean faceCompare(String file1Path,String file2Path) throws IOException, InterruptedException {
		if(file2Path==null)
			return false;
		String[]args = {file1Path,file2Path};
		String result = execUtil.execute(ScriptPath.getFaceComparePath(), args);
		if(Integer.valueOf(result)==1) {
			return true;
		}else
			return false;
	}
	
}
