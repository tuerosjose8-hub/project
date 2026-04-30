package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.UserRepository;
import models.User;



public class UserD implements UserRepository{
	// check login with database using queries ? is placeholder
	public User checkLogin(String username, String password) {

		String query = 	"SELECT user_id, username, role, first_name, last_name, year "
						+"FROM usersandpasswords "
						+"WHERE username = ? AND password = ?";		
		try {
			
			Connection conn = DatabaseConnection.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int userId = rs.getInt("user_id");
				String usernamedb = rs.getString("username");
				String role = rs.getString("role");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String year = rs.getString("year");
				
				User user = new User(userId, usernamedb, role, firstName, lastName, year);;
				rs.close();
				stmt.close();
				conn.close();
				
				return user;	// we return user with all the data
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
}
