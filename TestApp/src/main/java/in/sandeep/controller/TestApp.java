package in.sandeep.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Implementation Classes of Tomcat server :: \n \n ");
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		System.out.println("Implementation class of config is :: "+ request.getClass().getName());
		System.out.println("Implementation class of config is :: "+ response.getClass().getName());
		System.out.println("Implementation class of config is :: "+ config.getClass().getName());
		System.out.println("Implementation class of config is :: "+ context.getClass().getName());
	
	}

}
