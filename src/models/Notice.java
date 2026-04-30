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
	private String deadlineDate;
	
	private Notice (NoticeBuilder builder) {
		
		this.noticeId = builder.noticeId;
		this.title = builder.title;
		this.message = builder.message;
		this.category = builder.category;
		this.priority = builder.priority;
		this.yearLevel = builder.yearLevel;
		this.createdBy = builder.createdBy;
		this.createdByName = builder.createdByName;
		this.deadlineDate = builder.deadlineDate;
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
	
	public String getDeadlineDate() {
		return deadlineDate;
	}
	
	public static class NoticeBuilder {
		
		private int noticeId;
		private String title;
		private String message;
		private String category;
		private String priority;
		private String yearLevel;
		private int createdBy;
		private String createdByName;
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
		
		public NoticeBuilder deadlineDate(String deadlineDate) {
			this.deadlineDate = deadlineDate;
			return this;
		}
		
		public Notice build() {
			return new Notice(this);
		}
	}
}