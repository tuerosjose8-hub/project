package enums;

public enum Priority {
	HIGH("High"),
	MEDIUM("Medium"),
	LOW("Low");
	
	private String databaseValue;
	
	Priority(String databaseValue) {
		this.databaseValue = databaseValue;
	}
	
	public String getDatabaseValue() {
		return databaseValue;
	}
}