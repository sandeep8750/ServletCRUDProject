package in.sandeep.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/servletAttribute")
public class ServletAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("control in servlet_Attributes...");
		request.setAttribute("sandeep", "java");
		request.setAttribute("Pradeep", "data");
		request.setAttribute("shivam", "html");
		
		
		RequestDispatcher reqdis = request.getRequestDispatcher("/servlet2");
		reqdis.forward(request, response);
		
		System.out.println("Dispatching is success ");
	}

}
