package in.sandeep.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("control in servlet boss... ");
		
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		
		System.out.println(username + "  " + userpassword);
		
		if(username.equalsIgnoreCase("sandeep") && userpassword.equalsIgnoreCase("sandeep8750")) {
			
			RequestDispatcher reqdis = request.getRequestDispatcher("/home.jsp");
			reqdis.forward(request, response);
		}
		else {
			ServletContext context = request.getServletContext();
			RequestDispatcher reqdis2 = context.getRequestDispatcher("/error.jsp");
			reqdis2.forward(request, response);
		}
		
	
	
	}

}
