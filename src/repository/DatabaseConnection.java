package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mariadb://localhost:3306/users";

	// Change these values to match your local MariaDB username and password.
	
	private static final String USER = "tuerosj";
	private static final String PASSWORD = "Josefe12";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}