package in.ineuron.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read_WriteVideo")
public class Read_WriteVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		response.setContentType("video/mp4");

		File file = new File(
				"D:\\Java\\Servlet\\ResponseInfoApp\\Arijit Singh - Pal _ Official Video _ Nawazuddin Siddiqui _ Monsoon Shootout _ Rochak Kohli.mp4");
		FileInputStream fis = new FileInputStream(file);
		 byte[] b =  new byte[(int) file.length()];
		fis.read(b);
		ServletOutputStream stream = response.getOutputStream();
		stream.write(b);
		
		stream.flush();
		stream.close();
		fis.close();		
	}

}
