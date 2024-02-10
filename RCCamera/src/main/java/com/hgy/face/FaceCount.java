package com.hgy.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.tools.ScriptPath;
@Service
public class FaceCount {
	@Autowired
	private EXECUtil execUtil;
	
	public int faceCount(String filePath) {
		String[]args = {filePath};
		String result = execUtil.execute(ScriptPath.getUploadFaceCountPath(),args);
		
		return Integer.valueOf(result);
	}
}
