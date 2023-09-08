package in.sandeep.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out  = response.getWriter();
	
		out.println("<h1>control in second servlet boss....</h1> ");
	}

}
