package com.hgy.administrator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.repository.StudentService;
import com.hgy.tools.ExcelTool;
import com.hgy.tools.InputUtil;

import jxl.read.biff.BiffException;

public class AddClazzStudents {
	@Autowired
	private BaseDAO baseDAO;
	
	public AddClazzStudents() {
		System.out.println("input class id");
		Integer clazzId = Integer.valueOf(InputUtil.readLine());
		System.out.println("input student excel file path");
		String filepath = InputUtil.readLine();
		Set<Student> students = null;
		try {
			students = ExcelTool.getStudents(filepath);
			//look if all students exist
		} catch (BiffException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		for(Student student:students) {
			String sql = "insert into StudentInClass (studentID,classID) values ("+student.getId()+","
					+ String.valueOf(clazzId)+");";
			baseDAO.executeBySQL(sql);
		}
	}

}
