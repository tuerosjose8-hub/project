package models;

public class Notice {

	private int noticeId;
	private String title;
	private String message;
	private String category;
	private String priority;
	private String yearLevel;
	private int createdBy;
	private String createdByName;
	private String createdAt;
	private String deadlineDate;

	public Notice(int noticeId, String title, String message, String category,
			String priority, String yearLevel, int createdBy, String createdByName,
			String createdAt, String deadlineDate) {

		this.noticeId = noticeId;
		this.title = title;
		this.message = message;
		this.category = category;
		this.priority = priority;
		this.yearLevel = yearLevel;
		this.createdBy = createdBy;
		this.createdByName = createdByName;
		this.createdAt = createdAt;
		this.deadlineDate = deadlineDate;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public String getCategory() {
		return category;
	}

	public String getPriority() {
		return priority;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getDeadlineDate() {
		return deadlineDate;
	}
}