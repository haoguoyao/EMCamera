package servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CClazz;
import model.Course;
import repository.InfoDAO;
import tools.JsonTool;
import tools.ServletUtil;

public class TeacherDetailsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CClazz> cClazzs = InfoDAO.retrieveClazzByTeacher(Integer.valueOf(req.getParameter("id")));
		List<Course> courses = InfoDAO.retrieveCourseByTeacher(Integer.valueOf(req.getParameter("id")));
		Writer writer = resp.getWriter();
	//	ServletUtil.uploadList(writer, cClazzs);
		ServletUtil.uploadList(writer, courses);
		writer.close();
		
	}
	

}
