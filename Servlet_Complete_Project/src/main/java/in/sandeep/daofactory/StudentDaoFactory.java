package in.sandeep.daofactory;

import in.sandeep.dao.*;
import in.sandeep.dao.*;

public class StudentDaoFactory {

	private StudentDaoFactory() {
		
	}
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao() {
		
		if(studentDao == null) {
			studentDao =  new StudentDaoImpl();			
		}
		return studentDao ;
		
	}
}
