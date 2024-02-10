package com.hgy.administrator;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgy.model.Student;
import com.hgy.repository.BaseDAO;
import com.hgy.tools.ExcelTool;
import com.hgy.tools.InputUtil;

import jxl.read.biff.BiffException;

public class ManipulateDB {
	@Autowired
	private BaseDAO baseDAO;
	
	public void executeSQL() {
		
		System.out.println("input student excel file path");
		String sql = InputUtil.readLine();
		baseDAO.executeBySQL(sql);
	}

}
