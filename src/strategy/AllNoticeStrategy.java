package strategy;
import java.util.ArrayList;

import interfaces.NoticeFilterStrategy;
import interfaces.NoticeRepository;
import models.Notice;

public class AllNoticeStrategy implements NoticeFilterStrategy {
	
	public ArrayList<Notice> getNotices(NoticeRepository noticeRepository, int limit, String studentYear) {
		
		if(studentYear == null) {
			return noticeRepository.getAllNotices(limit);
		}
		
			return noticeRepository.getStudentAllNotices(limit, studentYear);
	}
		
}
