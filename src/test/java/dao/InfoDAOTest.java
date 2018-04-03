package dao;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.print.attribute.standard.DialogTypeSelection;

import org.junit.Test;

import jxl.read.biff.BiffException;
import model.CClazz;
import model.Course;
import model.Student;
import repository.CommonDAO;
import repository.InfoDAO;
import service.ClazzFactory;

public class InfoDAOTest extends InfoDAO {

//	@Test
//	public void verifyPassword() {
//		verifyPassword(1, "banana",1);
//	}
	@Test
	public void doTest() throws BiffException, IOException {
		createStudents("/Users/apple/Desktop/student1.xls");
		addCourse();
		addClazz("/Users/apple/Desktop/student1.xls");
	}
	public void addStudent(String path) throws BiffException, IOException {
		ClazzFactory clazzFactory = new ClazzFactory(path);
		CClazz clazz = clazzFactory.getClazz();
		clazz.setId(1);
		clazz.setCourseID(1);
		InfoDAO.createOrUpdateClazz(clazz);
	}
	public void addCourse() {
		Course course = new Course(1, "CS");
		CommonDAO.saveObject(course);
	}
	public void addClazz(String path) throws BiffException, IOException {
		CClazz cClazz = new CClazz(1,path);
		InfoDAO.createOrUpdateClazz(cClazz);
	}

}
