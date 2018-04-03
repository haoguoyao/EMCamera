package repository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.CClazz;
import model.Course;
import model.Student;
import model.Teacher;
import model.User;
import service.ClazzFactory;
public class InfoDAO {
	@SuppressWarnings("deprecation")
	public int verifyPassword(int userID, String password,int type) {
		SessionFactory sessionFactory= HibernateSessionFactory.getInstance();
		System.out.println(sessionFactory==null);
		Session session = sessionFactory.openSession();
		String sql;
		if(type == 1) {
			sql = "from Student as s "
				+ "where s.id = ? and s.password = ?";
			}
		else
			sql = "from Teacher as t "
					+ "where t.id = ? and t.password = ?";
		Query<Student> query = session.createQuery(sql);
		query.setParameter(0, userID,IntegerType.INSTANCE);
		query.setParameter(1, password,StringType.INSTANCE);
		List<Student> oneStudent= query.list();
		if(oneStudent.size() ==0) {
			System.out.println("No user found");
			return 101;
		}
		else	 if (oneStudent.get(0).getPassword().equals(password)) {
			System.out.println("One student login success");
			return 100;
		}
		else{
			System.out.println("Password is not correct");
			return 102;
		}
	}
	public int verifyPassword(String mailBox, String password,int type) {
		SessionFactory sessionFactory= HibernateSessionFactory.getInstance();
		System.out.println(sessionFactory==null);
		Session session = sessionFactory.openSession();
		
		String sql;
		if(type == 1) 
			sql = "from Student as s "
				+ "where s.mailbox = ? and s.password = ?";
		else
			return 103;
		Query query = session.createQuery(sql);
		query.setParameter(0, mailBox,StringType.INSTANCE);
		query.setParameter(1, password,StringType.INSTANCE);
		List<Student> oneStudent= query.list();
		if(oneStudent.size() ==0) {
			System.out.println("No user found");
			return 101;
		}
		else	 if (oneStudent.get(0).getPassword().equals(password)) {
			System.out.println("One student login success");
			return 100;
		}
		else{
			System.out.println("Password is not correct");
			return 102;
		}
	}
	
	
	public static String retrievePassword(String mailBox) {
		Session session = HibernateSessionFactory.getSession();
		List<Student> oneStudent = session.createCriteria(Student.class)
			    .add( Restrictions.eq("mainBox", mailBox) )
			    .list();
		if(oneStudent.isEmpty())
			return null;
		else
			return oneStudent.get(0).getPassword();
	}
	public static String retrievePassword(int id) {
		Session session = HibernateSessionFactory.getSession();
		List<User> oneUser;
		if(id>=100000000)
			oneUser = session.createCriteria(Student.class)
			    .add( Restrictions.eq("id", id) )
			    .list();
		else
			oneUser = session.createCriteria(Teacher.class)
		    .add( Restrictions.eq("id", id) )
		    .list();
		session.close();
		if(oneUser.isEmpty())
			return null;
		else
			return oneUser.get(0).getPassword();
	}
	public static Student retrieveStudent(int studentID) {
		Session session = HibernateSessionFactory.getSession();
		Student student = session.get(Student.class, studentID);
		session.close();
		if(student==null)
			return null;
		else
		{
			System.out.println("User exist");
			return student;
		}
		
	}
	public static int createStudent(Student newStudent) {
		System.out.println("####");
		System.out.println(newStudent.getId());
		System.out.println(newStudent.getName());
		System.out.println(newStudent.getPassword());
		System.out.println(newStudent.getMailBox());
		Student student = retrieveStudent(newStudent.getId());
		if(student!=null&&student.getId()!=0)
			return 201;
		else{
			System.out.println("Creating user......");
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(newStudent);
			tx.commit();
			session.close();
			return 200;
		}
	}

	public static void addStudentToClass(Student student, int clazzID) {
		Session session = HibernateSessionFactory.getSession();
		CClazz clazz = session.get(CClazz.class,clazzID);
		Set<Student> students = clazz.getStudents();
		if(!students.contains(student))
			students.add(student);
		clazz.setStudents(students);
		session.saveOrUpdate(clazz);
	}
	public static void removeStudentFromClass(Student student, int clazzID) {
		Session session = HibernateSessionFactory.getSession();
		CClazz clazz = session.get(CClazz.class,clazzID);
		Set<Student> students = clazz.getStudents();
		if(students.contains(student))
			students.remove(student);
		clazz.setStudents(students);
		session.saveOrUpdate(clazz);
	}
	public static void createOrUpdateClazz(CClazz clazz) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(clazz); 
		tx.commit();
		session.close();
	}
	public static void createStudents(String url) throws BiffException, IOException {
		String fileName = url; // Excel文件所在路径  
        File file = new File(fileName); // 创建文件对象  
        Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）  
        Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）  
          System.out.println(sheet.getColumns());
        for (int i = 0; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容  
        		Student student =ClazzFactory.readAStudent(sheet, i);
            createStudent(student);
        }  
	}
	public static List<CClazz> retrieveClazzByTeacher(int teacherID){
		Session session = HibernateSessionFactory.getSession();
		List<CClazz> cClazzs = session.createCriteria(CClazz.class)
			    .add( Restrictions.eq("teacherID",teacherID) )
			    .list();
		session.close();
		return cClazzs;
	}
	public static List<Course> retrieveCourseByTeacher(int teacherID){
		List<CClazz> cClazzs = retrieveClazzByTeacher(teacherID);
		List<Course> courses = new ArrayList<Course>();
		for(CClazz cClazz :cClazzs) {
			Course course = retrieveCourseByID(cClazz.getCourseID());
			courses.add(course);
		}
		return courses;
	}
	public static List<Student> retrieveStudentByClazz(int clazzID){
		Session session = HibernateSessionFactory.getSession();
		List<Student> students = session.createCriteria(Student.class)
			    .add( Restrictions.eq("clazzID",clazzID) )
			    .list();
		session.close();
		return students;
	}
	public static Course retrieveCourseByID(int courseID) {
		Session session = HibernateSessionFactory.getSession();
		Course course = session.get(Course.class, courseID);
		return course;
	}

}
