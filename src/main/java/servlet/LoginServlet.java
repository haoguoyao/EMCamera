package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.DoLogin;
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8552683134862056264L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DoLogin doLogin = new DoLogin();
		String userInfo = req.getParameter("user");
		int status = doLogin.login(userInfo, req.getParameter("password"));
		Writer writer= resp.getWriter();
		writer.write(status);
		writer.flush();
		writer.close();
	}

}