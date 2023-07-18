package in.sandeep.jdbcOp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcOP {
	
	public static Connection getDbConnection() throws SQLException, IOException {
		
		FileInputStream fis = new FileInputStream("D:\\Java\\Servlet\\Servlet_Complete_Project\\src\\main\\java\\in\\sandeep\\properties\\application.properties");
		Properties getCarditialFormproProperties = new Properties();
		
		getCarditialFormproProperties.load(fis);
		
		String url = getCarditialFormproProperties.getProperty("jdbcUrl");
		String username = getCarditialFormproProperties.getProperty("user");
		String password = getCarditialFormproProperties.getProperty("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

	
	public static void resourceCleanUp(Connection connection , PreparedStatement preparedStatement , ResultSet resultSet) throws SQLException {
		
		if(connection != null)
		{
			connection.close();
		}
		if(preparedStatement!= null)
		{
			preparedStatement.close();
		}
		if(resultSet != null)
		{
			resultSet.close();
		}
	}
}


