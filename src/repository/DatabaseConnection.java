package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:mariadb://localhost:3306/users";

	private static final String USER = "tuerosj"; // change to your local username
	private static final String PASSWORD = "Josefe12"; // change to your local password

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}