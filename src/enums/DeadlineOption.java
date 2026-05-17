package enums;

public enum DeadlineOption {

	NO_DEADLINE("No deadline", 0),
	NEXT_WEEK("Next week", 7),
	TWO_WEEKS("Two weeks", 14),
	THREE_WEEKS("Three weeks", 21),
	ONE_MONTH("One month", 30);

	private String label;
	private int days;

	DeadlineOption(String label, int days) {
		this.label = label;
		this.days = days;
	}

	public String getLabel() {
		return label;
	}

	public int getDays() {
		return days;
	}

	public static String[] getLabels() {

		String[] labels = new String[values().length];

		for(int i = 0; i < values().length; i++) {
			labels[i] = values()[i].getLabel();
		}

		return labels;
	}

	public static DeadlineOption fromLabel(String label) {

		for(DeadlineOption option : values()) {
			if(option.getLabel().equals(label)) {
				return option;
			}
		}

		return NO_DEADLINE;
	}
}