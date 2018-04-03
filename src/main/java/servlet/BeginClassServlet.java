package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RollCall;
import repository.RollCallDAO;

public class BeginClassServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RollCall rollCall= new RollCall(Integer.valueOf(req.getParameter("classID")));
		int status = RollCallDAO.createOrUpdateRollCall(rollCall);
		Writer writer = resp.getWriter();
		writer.write(rollCall.getId());
		writer.flush();
		writer.close();
	}

}
