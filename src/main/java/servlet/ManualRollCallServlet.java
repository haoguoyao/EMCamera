package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.RollCall;
import model.Status;
import model.Student;
import repository.RollCallDAO;
import tools.JsonTool;

public class ManualRollCallServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int type = Integer.valueOf(req.getParameter("type"));
		int rollcallID = Integer.valueOf(req.getParameter("rollCallID"));
		RollCall rollCall = RollCallDAO.retrieveRollCall(rollcallID);
		//用户请求点名对象
		if(type == 1) {
			JSONArray jsonArray = JsonTool.toJsonArray(rollCall.getStatus());
			out.write(jsonArray.toString());
		}
		//用户发送过来点名情况
		else if(type==2) {
			JSONArray statusString = new JSONArray(req.getParameter("statusString"));
			List<Status> statuses = new ArrayList<Status>();
			int size = statusString.length();
			for(int i = 0;i<size;i++) {
				statuses.add((Status)statusString.get(i));
			}
			rollCall.setStatus(statuses);
			RollCallDAO.createOrUpdateRollCall(rollCall);
			out.write("success");
		}
		
		out.flush();
		out.close();
	}
}
