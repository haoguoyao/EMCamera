package com.hgy.handler;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hgy.face.FaceCount;
import com.hgy.model.Student;
import com.hgy.repository.StudentService;
import com.hgy.tools.PhotoFolderPath;
import org.apache.commons.io.FileUtils;


/**
 * 
 * 
 * 学生将自己的一张照片上传到服务器
 * 
 * 
 * */

@Controller
public class StudentPhotoHandler
{
	@Autowired
	private FaceCount faceCount;
	@Autowired
	private StudentService studentService;
	
   
	@RequestMapping(value = "/student/PhotoHandler_upload")
	@ResponseBody
	public int photoUpload(Integer id,@RequestParam MultipartFile multipartFile,String fileName,HttpServletRequest request) throws Exception {
		//文件上传并保存	
		File dir = new File(PhotoFolderPath.getPersonalphotopath());
		if(!dir.exists())
			dir.mkdirs();
		String url = "personalPhoto/"+fileName;
		System.out.println(PhotoFolderPath.getPersonalphotopath());
		System.out.println("url is :::::"+url);
		File file = new File(PhotoFolderPath.getPhotoParentPath()+"/"+url);
		multipartFile.transferTo(file);
		//判断上传的照片是否符合要求
		System.out.println(request.getSession().getServletContext().getRealPath("/")+"/"+url);
		int faceNumber = faceCount.faceCount(request.getSession().getServletContext().getRealPath("/")+"/"+url);
		if(faceNumber==1) {
			studentService.updateUrl(id, url);			
		}else {
			file.delete();
		}
		return faceNumber;
		
	}
	
	@RequestMapping(value = "/student/PhotoHandler_get")
	@ResponseBody
	public String photoGet(Integer id,HttpServletRequest request) throws Exception {
		Student student = studentService.findById(id);
		if(student==null) {
			System.out.println("student not found");
			return null;
		}else {
			if(student.getUrl()==null)
				return null;
			else if(new File(request.getSession().getServletContext().getRealPath("/")+"/"+student.getUrl()).exists())
				return student.getUrl();
			else
				return null;
		}
		
	}

}
