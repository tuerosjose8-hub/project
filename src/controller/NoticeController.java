package controller;

import java.time.LocalDate;
import enums.DeadlineOption;

import builder.NoticeBuilder;
import interfaces.NoticeRepository;
import models.Notice;

public class NoticeController {
	
	private NoticeRepository noticeRepository;

	
	public NoticeController(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	public boolean createNotice(String title, String message, String category,
			String priority, String year, String deadlineChoice, int createdBy) {

		if(title == null || title.trim().isEmpty()) {
		    return false;
		}

		if(message == null || message.trim().isEmpty()) {
		    return false;
		}

		if(category == null || category.trim().isEmpty()) {
			return false;
		}

		if(priority == null || priority.trim().isEmpty()) {
			return false;
		}

		if(year == null || year.trim().isEmpty()) {
			return false;
		}

		if(createdBy <= 0) {
			return false;
		}

		String deadlineDate = getDeadlineDate(deadlineChoice);

		Notice notice = new NoticeBuilder(title.trim(), message.trim())
				.category(category)
				.priority(priority)
				.yearLevel(year)
				.createdBy(createdBy)
				.deadlineDate(deadlineDate)
				.build();

		return noticeRepository.addNotice(notice);
	}
	
	public String getDeadlineDate(String deadlineChoice) {

		DeadlineOption option = DeadlineOption.fromLabel(deadlineChoice);

		if(option == DeadlineOption.NO_DEADLINE) {
			return null;
		}

		return LocalDate.now().plusDays(option.getDays()).toString();
	}
}
