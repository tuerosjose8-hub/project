package builder;

import models.Notice;

public class NoticeBuilder {

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

	public NoticeBuilder(String title, String message) {
		this.title = title;
		this.message = message;
	}

	public NoticeBuilder noticeId(int noticeId) {
		this.noticeId = noticeId;
		return this;
	}

	public NoticeBuilder category(String category) {
		this.category = category;
		return this;
	}

	public NoticeBuilder priority(String priority) {
		this.priority = priority;
		return this;
	}

	public NoticeBuilder yearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
		return this;
	}

	public NoticeBuilder createdBy(int createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public NoticeBuilder createdByName(String createdByName) {
		this.createdByName = createdByName;
		return this;
	}

	public NoticeBuilder createdAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public NoticeBuilder deadlineDate(String deadlineDate) {
		this.deadlineDate = deadlineDate;
		return this;
	}

	public Notice build() {
		return new Notice(
				noticeId,
				title,
				message,
				category,
				priority,
				yearLevel,
				createdBy,
				createdByName,
				createdAt,
				deadlineDate);
	}
}