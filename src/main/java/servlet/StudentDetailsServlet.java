package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.Student;
import repository.InfoDAO;

public class StudentDetailsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("ID");
		Student student = InfoDAO.retrieveStudent(Integer.valueOf(id));
		JSONObject jsonStudent = new JSONObject(student);
		Writer writer = resp.getWriter();
		writer.write(jsonStudent.toString());
		writer.flush();
	}

}
