package myPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usrEmail = request.getParameter("email1");
		String usrName = request.getParameter("name1");
		String usrGender = request.getParameter("gender1");
		String usrMobile = request.getParameter("mobile1");
		String usrPassword = request.getParameter("password1");
		String usrCity = request.getParameter("city1");

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String sqlURL = "jdbc:mysql://url";
			String sqlUsername = "username";
			String sqlPassword = "password";

			Connection con = DriverManager.getConnection(sqlURL, sqlUsername, sqlPassword);
			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");

			ps.setString(1, usrEmail);
			ps.setString(2, usrName);
			ps.setString(3, usrGender);
			ps.setString(4, usrMobile);
			ps.setString(5, usrPassword);
			ps.setString(6, usrCity);

			int result = ps.executeUpdate();

			if (result > 0) {

				response.setContentType("text/html");
				out.print("<h2 style='color:green'>Success    </h2>");
				RequestDispatcher rd = request.getRequestDispatcher("indexLogin.jsp");
				rd.include(request, response);
			}

			else {
				response.setContentType("text/html");
				out.print("<h2 style='color:red'>Try Again    </h2>");
				RequestDispatcher rd = request.getRequestDispatcher("indexRegister.jsp");
				rd.include(request, response);

			}
		

		} catch (Exception e) {

			response.setContentType("text/html");
			out.print("<h2 style='color:red'>Try Again     </h2>");
			RequestDispatcher rd = request.getRequestDispatcher("indexRegister.jsp");
			rd.include(request, response);
		}

	}

}