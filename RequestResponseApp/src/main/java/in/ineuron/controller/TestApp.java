 package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demo")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		String msg="";
		LocalDateTime date = LocalDateTime.now();
		int hour = date.getHour();
		
		if(hour<12)
		{
		     msg+="GOOD MORNING";
		}
		else if(hour<16)
		{
			msg+="GOOD AFTERNOON";
		}
		else if(hour<20)
		{
			msg+="GOOD EVENING";
		}
		else {
			msg+="GOOD NIGHT";
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1 style='color:red;text-align:center;'>WELCOME TO SERVLET CODING......</h1>");
		out.println("<h1 style='color:blue;text-align:center;'>The current date is ::" + date + "</h1>");
		out.println("<h1 style='color:blue;text-align:center;'>Greeting from server  ::" + msg + "</h1>");
		
		out.close();
	}

}
