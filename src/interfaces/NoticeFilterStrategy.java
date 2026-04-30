package interfaces;

import java.util.ArrayList;

import models.Notice;
public interface NoticeFilterStrategy { // basic interface for what is coming
	
	ArrayList<Notice> getNotices(NoticeRepository noticeRepository, int limit, String studentYear);

}
