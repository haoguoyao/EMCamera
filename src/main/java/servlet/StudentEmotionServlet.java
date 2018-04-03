package servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.RollCallDAO;
import tools.FilePath;
import tools.ServletUtil;

public class StudentEmotionServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studentID = req.getParameter("ID");
		List<String> filePaths = FilePath.studentIDHead(studentID);
		ServletUtil.uploadPhotos(resp.getOutputStream(), filePaths);
	}

}
