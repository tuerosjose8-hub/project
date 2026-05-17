package enums;

public enum Category {
	GENERAL("General"),
	ACADEMIC("Academic"),
	INTERNSHIP("Internship Opportunities"),
	CS_CLUB("CS Club"),
	EVENTS("Events"),
	DEADLINES("Deadlines");

	private String databaseValue;

	Category(String databaseValue) {
		this.databaseValue = databaseValue;
	}

	public String getDatabaseValue() {
		return databaseValue;
	}
}