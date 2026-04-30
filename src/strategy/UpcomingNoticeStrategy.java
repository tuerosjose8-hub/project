package strategy;

import java.util.ArrayList;

import interfaces.NoticeFilterStrategy;
import interfaces.NoticeRepository;
import models.Notice;

public class UpcomingNoticeStrategy implements NoticeFilterStrategy {
		
	public ArrayList<Notice> getNotices(NoticeRepository noticeRepository, int limit, String studentYear) {
			
		if(studentYear == null) {
			return noticeRepository.getUpcomingEvents(limit);
		}

		return noticeRepository.getStudentUpcomingEvents(limit, studentYear);
	}
}