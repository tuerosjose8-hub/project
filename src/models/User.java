package models;

public class User { // simple user constructor to get information of the different users
	
	private int userId;
	private String username;
	private String role;
	private String firstName;
	private String lastName;
	private String year;
	
public User(int userId, String username, String role, String firstName, String lastName, String year) {
		
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullname() {
		return firstName + " " + lastName;
	}
	public String getYear() {
		return year;
	}
	
}
