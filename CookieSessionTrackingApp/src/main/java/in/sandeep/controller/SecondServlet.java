package in.sandeep.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pband = request.getParameter("pband");
		String pqty = request.getParameter("pqty");
		
		Cookie c3 = new Cookie("pband", pband);
		Cookie c4 = new Cookie("pqty", pqty);
		
		response.addCookie(c3);
		response.addCookie(c4);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("form3.html");
		
		requestDispatcher.forward(request, response);
	}

}
