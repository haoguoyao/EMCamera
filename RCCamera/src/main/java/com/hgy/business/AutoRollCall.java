package com.hgy.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgy.face.EXECUtil;
import com.hgy.face.FaceRecognition;
import com.hgy.model.CClazz;
import com.hgy.model.RollCall;
import com.hgy.model.Status;
import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StatusService;
import com.hgy.repository.StudentService;
import com.hgy.tools.PhotoFolderPath;

@Service
public class AutoRollCall {
	
	@Autowired
	private EXECUtil execUtil;
	@Autowired
	private StatusService statusService;
	@Autowired
	private BaseDAO baseDAO;
	@Autowired
	private FaceRecognition faceRecognition;
	
	
	public void faceRecongition(String folderPath,int rollCallID) {
		List<Status> statuses = statusService.getStatusByRollCallId(rollCallID);
		File file = new File(folderPath);
		for(Status status:statuses) {
			Student student = (Student)baseDAO.find(Student.class, status.getStudentID());
			for(File photo:file.listFiles()) {
				String studentUrl = student.getUrl();
				if(studentUrl==null)
					continue;
				try {
					if(faceRecognition.faceCompare(photo.getAbsolutePath(), PhotoFolderPath.getPhotoParentPath()+student.getUrl())) {
						System.out.println("detect student "+student.getId()+" arrive");
						status.setArrive(1);
						baseDAO.save(status);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}

}
