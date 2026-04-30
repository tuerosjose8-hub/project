package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	// localhost + name of the database
	private static final String url = "jdbc:mariadb://localhost:3306/users";
	private static final String user = "tuerosj";
	private static final String password = "Josefe12";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}

}
