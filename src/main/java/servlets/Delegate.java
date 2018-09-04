package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import app.Authenticate;
import util.JSONUtil;

/**
 * Servlet implementation class Delegate
 */
public class Delegate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public Delegate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String data = JSONUtil.getJsonObjectValue(request);

		String data = request.getParameter("data");
		JSONObject jsonData = new JSONObject(data);
		String value = jsonData.getString("value");
		String type = jsonData.getString("type");

		Authenticate auth = new Authenticate();
		Boolean isValueValid = auth.isValid(value, type);

		JSONObject jo = new JSONObject();
		jo.put("result", isValueValid);

		PrintWriter out = response.getWriter();
		out.print(jo);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
