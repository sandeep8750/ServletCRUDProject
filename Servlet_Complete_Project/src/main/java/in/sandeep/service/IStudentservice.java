package in.sandeep.service;

import in.sandeep.dto.Student;

public interface IStudentservice {

    public String  addStudent(Student student);
	
	public Student searchStudent(Integer sid ); 
	
	public String updateStudent(Student student);

	public String deleteStudent(Integer sid );
	
	
}
