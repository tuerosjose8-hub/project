package enums;
public enum YearLevel {
	FRESHMAN("Freshman"),
	SOPHOMORE("Sophomore"),
	JUNIOR("Junior"),
	SENIOR("Senior"),
	GRADUATE("Graduate"),
	ALL("All");

	private String databaseValue;

	YearLevel(String databaseValue) {
		this.databaseValue = databaseValue;
	}

	public String getDatabaseValue() {
		return databaseValue;
	}
}
