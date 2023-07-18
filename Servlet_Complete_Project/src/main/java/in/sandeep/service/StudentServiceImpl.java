package in.sandeep.service;

import in.sandeep.dao.IStudentDao;
import in.sandeep.daofactory.*;
import in.sandeep.dto.Student;


public class StudentServiceImpl implements IStudentservice {

	@Override
	public String addStudent(Student student) 
	{
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer sid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		Student searchStudent = studentDao.searchStudent(sid);
		return searchStudent;
	}

	@Override
	public String updateStudent(Student student) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		String updateStudent = studentDao.updateStudent(student);
		return updateStudent;
	}

	@Override
	public String deleteStudent(Integer sid) {

		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		String deleteStudent = studentDao.deleteStudent(sid);
		return deleteStudent;
	}

}
