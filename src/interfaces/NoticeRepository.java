package interfaces;

import java.util.ArrayList;

import models.Notice;

public interface NoticeRepository {
	
	boolean addNotice(Notice notice);
	ArrayList<Notice> getAllNotices(int limit);
	ArrayList<Notice> getRecent (int limit);
	ArrayList<Notice> getImportantNotices (int limit);
	ArrayList<Notice> getUpcomingEvents (int limit);
	
	ArrayList<Notice> getStudentAllNotices (int limit, String studentYear);
	ArrayList<Notice> getStudentRecent (int limit, String studentYear);
	ArrayList<Notice> getStudentImportantNotices (int limit, String studentYear);
	ArrayList<Notice> getStudentUpcomingEvents (int limit, String studentYear);


}
