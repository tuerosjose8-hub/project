package enums;

public enum UserRole {
	ADMIN("ADMIN"),
	STUDENT("STUDENT");

	private String databaseValue;

	UserRole(String databaseValue) {
		this.databaseValue = databaseValue;
	}

	public String getDatabaseValue() {
		return databaseValue;
	}
}