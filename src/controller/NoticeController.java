package controller;
import java.time.LocalDate;
import java.util.HashMap;

import interfaces.NoticeRepository;
import models.Notice;
public class NoticeController {
	
	private NoticeRepository noticeRepository;
	private HashMap<String, Integer> weekDeadlines;
	private HashMap<String, Integer> monthDeadlines;
	
	public NoticeController(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
		
		weekDeadlines = new HashMap<String, Integer>();
		weekDeadlines.put("Next week", 1);
		weekDeadlines.put("Two weeks", 2);
		weekDeadlines.put("Three weeks", 3);

		monthDeadlines = new HashMap<String, Integer>();
		monthDeadlines.put("One month", 1);
		
	}
	public boolean createNotice(String title, String message, String category,
			String priority, String year, String deadlineChoice, int createdBy) {

		if(title.equals("") || message.equals("")) {
			return false;
		}

		String deadlineDate = getDeadlineDate(deadlineChoice);

		Notice notice = new Notice.NoticeBuilder(title, message)
				.category(category)
				.priority(priority)
				.yearLevel(year)
				.createdBy(createdBy)
				.deadlineDate(deadlineDate)
				.build();

		return noticeRepository.addNotice(notice);
	}
	public String getDeadlineDate(String deadlineChoice) {

		LocalDate today = LocalDate.now();

		Integer weeks = weekDeadlines.get(deadlineChoice);
		Integer months = monthDeadlines.get(deadlineChoice);

		if(weeks != null) {
			return today.plusWeeks(weeks).toString();
		}

		if(months != null) {
			return today.plusMonths(months).toString();
		}

		return null;
	}


}
