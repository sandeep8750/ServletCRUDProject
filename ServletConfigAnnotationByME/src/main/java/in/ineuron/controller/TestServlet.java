package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/sandeep"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root123")
		}, loadOnStartup = 10)


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement prepareStatement;
	private PrintWriter out;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loading successfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void init() throws ServletException {
		String jdbcUrl = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");

		try {
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection established succesfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String userage = request.getParameter("userage");
		String useraddress = request.getParameter("useraddr");

		String sqlInsertQuery = "INSERT INTO `sandeep`.`employee` ( `name`, `age`, `address`) VALUES (?, ?,?);";
		try {
			if (connection != null)
				prepareStatement = connection.prepareStatement(sqlInsertQuery);
			if (prepareStatement != null) {
				prepareStatement.setString(1, username);
				prepareStatement.setInt(2, Integer.parseInt(userage));
				prepareStatement.setString(3, useraddress);
			}
			if (prepareStatement != null) {
				int rowAffected = prepareStatement.executeUpdate();
				PrintWriter out = null;
				out = response.getWriter();
				if (rowAffected == 1) {
					out.println("<h1 style='color:green;text-align:center;'>REGISTRATION SUCCESFULL</h1>");
				} else {
					out.println(
							"<h1 style='color:red; text-align;center;'>REGISTRATION FAILED TRY AGAIN WITH THE FOLLOWING LINK</h1>");
					out.println("<a href='./reg.html'/>|REGISTRATION|</a>");
				}
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void distroy() {

		if (connection != null) {
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	

}
