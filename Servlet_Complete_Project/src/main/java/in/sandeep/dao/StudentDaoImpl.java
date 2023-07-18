package in.sandeep.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.RowSetFactory;

import in.sandeep.jdbcOp.*;
import in.sandeep.dto.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String addStudent(Student student) {
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String Sqlquery = "INSERT INTO student.student_data ( studentName, studentAge, Studentaddress) VALUES (?,?,?);";
		try {
			dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				preparedStatement = dbConnection.prepareStatement(Sqlquery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, student.getSname());
				preparedStatement.setInt(2, student.getSage());
				preparedStatement.setString(3, student.getSaddress());
			}

			int rowaffected = preparedStatement.executeUpdate();
			if (rowaffected == 1) {

				return "success";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "unsuccess";
	}

	@Override
	public Student searchStudent(Integer sid) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Student student = null;

		String sqlquery = "select * from student.student_data where StudentId=?";
		try {

			Connection dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				prepareStatement = dbConnection.prepareStatement(sqlquery);
			}

			if (prepareStatement != null) {
				prepareStatement.setInt(1, sid);
			}
			if (prepareStatement != null) {

				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {

				if (resultSet.next()) {
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					int age = resultSet.getInt(3);
					String address = resultSet.getString(4);

					student = new Student();

					if (student != null) {
						student.setSid(id);
						student.setSname(name);
						student.setSage(age);
						student.setSaddress(address);
						return student;
					}

				}

			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String updateStudent(Student student) {
		Connection dbConnection = null;
		PreparedStatement prepareStatement = null;
		int Rowaffected = 0;

		String sqlquery = "UPDATE student.student_data SET studentName = ?, studentAge = ?, Studentaddress = ?  WHERE StudentId = ?";
		try {
			dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				prepareStatement = dbConnection.prepareStatement(sqlquery);
			}

			if (prepareStatement != null) {
				prepareStatement.setString(1, student.getSname());
				prepareStatement.setInt(2, student.getSage());
				prepareStatement.setString(3, student.getSaddress());
				prepareStatement.setInt(4, student.getSid());
				Rowaffected = prepareStatement.executeUpdate();
			}

			if (Rowaffected == 1) {
				return "success";
			} else {
				return "not found";
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "fail";
	}

	@Override
	public String deleteStudent(Integer sid) {

		Connection dbConnection = null;
		PreparedStatement prepareStatement = null;
		int Rowaffected = 0;

		String sqlquery = "delete from student.student_data where StudentId=?";
		try {
			dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				prepareStatement = dbConnection.prepareStatement(sqlquery);
			}

			if (prepareStatement != null) {
				prepareStatement.setInt(1, sid);
			}
			if (prepareStatement != null) {

				Rowaffected = prepareStatement.executeUpdate();
			}

			if (Rowaffected == 1) {
				return "success";
			} else {
				return "not found";
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "fail";
	}

}
