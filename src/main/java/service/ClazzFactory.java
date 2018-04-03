package service;

import java.io.File;
import java.io.IOException;
import java.util.*;

import jxl.*;
import jxl.read.biff.BiffException;
import model.CClazz;
import model.Student;
public class ClazzFactory {
	private CClazz clazz;
	private String url = null;
	public ClazzFactory() {
		this.clazz = new CClazz();
	}
	public ClazzFactory(String url) throws BiffException, IOException {
		this.clazz = new CClazz();
	}
	public ClazzFactory(String url,CClazz clazz) throws BiffException, IOException {
		this.clazz = clazz;
		this.url = url;
	}
	
	//从excel中导入学生
	public Set<Student> getStudents(String url) throws BiffException, IOException {
		Set<Student> students= new HashSet<Student>();
		String fileName = url; // Excel文件所在路径  
        File file = new File(fileName); // 创建文件对象  
        Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）  
        Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）  
          System.out.println(sheet.getColumns());
        for (int i = 0; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容  
        		Student student = readAStudent(sheet, i);
            students.add(student);
            System.out.println(i+"is added to clazz");  
        }  
		return students;
	}
	public Set<Student> getStudents() throws BiffException, IOException {
		Set<Student> students= new HashSet<Student>();
		String fileName = url; // Excel文件所在路径  
        File file = new File(fileName); // 创建文件对象  
        Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）  
        Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）  
        for (int i = 0; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容  
        		Student student = readAStudent(sheet, i);
            students.add(student);
            System.out.println(i+"is added to clazz");  
        }  
		return students;
	}
	//读取excel文件的一行
	public static Student readAStudent(Sheet sheet, int row) {
		Student student = new Student();
		student.setId(Integer.valueOf(sheet.getCell(0,row).getContents()));
        student.setName(sheet.getCell(1,row).getContents());
        student.setPassword(sheet.getCell(2,row ).getContents());
        student.setStudentMailBox(sheet.getCell(3,row ).getContents());
        return student;
	}
	public CClazz getClazz() {
		return clazz;
	}
	public void setClazz(CClazz clazz) {
		this.clazz = clazz;
	}

}
