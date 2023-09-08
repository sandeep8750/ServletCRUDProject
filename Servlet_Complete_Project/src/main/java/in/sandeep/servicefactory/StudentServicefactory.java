package in.sandeep.servicefactory;

import in.sandeep.service.IStudentservice;
import in.sandeep.service.StudentServiceImpl;

public class StudentServicefactory {

	private StudentServicefactory() {
	
	}
	private static IStudentservice studentservice = null;
	public static IStudentservice getStudentService() {
		if (studentservice == null) {
			 studentservice  = new StudentServiceImpl();			
		}
		
		return studentservice;
	}
}
