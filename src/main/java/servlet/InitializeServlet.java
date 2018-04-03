package servlet;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import tools.FilePath;

public class InitializeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8580847730250221720L;
	static boolean isWin = false;
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Initial the server");
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if(os.startsWith("win") || os.startsWith("Win")) {
			isWin = true;
			FilePath.setDivide("\\");
		}
		else {
			isWin = false;
			FilePath.setDivide("/");
		}
	}
			

}
