package strategy;

import java.util.ArrayList;

import interfaces.NoticeFilterStrategy;
import interfaces.NoticeRepository;
import models.Notice;

public class ImportantNoticeStrategy implements NoticeFilterStrategy {
		
	public ArrayList<Notice> getNotices(NoticeRepository noticeRepository, int limit, String studentYear) {
			
		if(studentYear == null) {
			return noticeRepository.getImportantNotices(limit);
		}
			
		return noticeRepository.getStudentImportantNotices(limit, studentYear);
	}
}