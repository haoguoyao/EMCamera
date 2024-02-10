package com.hgy.handler;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hgy.business.AutoRollCall;
import com.hgy.face.FaceRecognition;
import com.hgy.face.FaceSegmentation;
import com.hgy.tools.PhotoFolderPath;
@Controller
public class TeacherPhotoHandler {
	
	@Autowired
	private FaceSegmentation faceSegmentation;
	@Autowired
	private FaceRecognition faceRecognization;
	@Autowired
	private AutoRollCall autoRollCall;
	
	@RequestMapping(value = "/teacher/PhotoHandler_upload")
	@ResponseBody
	public int photoUpload(Integer id,@RequestParam MultipartFile multipartFile,Integer rollCallID,HttpServletRequest request) throws Exception {
		//文件上传并保存
		File dir = new File(PhotoFolderPath.getClassphotopath()+"/"+String.valueOf(rollCallID));
		System.out.println(dir.getAbsolutePath());
		if(!dir.exists())
			dir.mkdirs();
		String url = "classPhoto/"+String.valueOf(rollCallID)+"/"+String.valueOf(Math.random()+".jpg");
		System.out.println("url is :::::"+url);
		File file = new File(PhotoFolderPath.getPhotoParentPath()+"/"+url);
		System.out.println(file.getAbsolutePath());
		multipartFile.transferTo(file);
		//对照片进行点名
		faceSegmentation.faceSegmentation(file.getAbsolutePath(),PhotoFolderPath.getClassphotopath()+"/"+String.valueOf(rollCallID)+"/face/");
		autoRollCall.faceRecongition(PhotoFolderPath.getClassphotopath()+"/"+String.valueOf(rollCallID)+"/face/", rollCallID);
		return 1;
	}
}
