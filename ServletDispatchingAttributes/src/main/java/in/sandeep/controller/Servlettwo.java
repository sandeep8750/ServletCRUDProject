package in.sandeep.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class Servlettwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("controll in servletTwo..");
		PrintWriter out = response.getWriter();

		out.println("<h1>lest print Attributes..</h1>");

		Enumeration<String> attributeNames = request.getAttributeNames();

		while (attributeNames.hasMoreElements()) {
			String stringname = (String) attributeNames.nextElement();
			//String value = request.getHeader(stringname);
			
			out.println("<h1>"+stringname+"</h1>");
			//out.println("<h1>"+value+"</h1>cru");
		}

		
		String name1 = (String)request.getAttribute("java");
		String name2 = (String)request.getAttribute("data");
		String name3 = (String)request.getAttribute("html");
		
		out.println("<h1>"+name1+"</h1>");
		out.println("<h1>"+name2+"</h1>");
		out.println("<h1>"+name3+"</h1>");
	}

}
