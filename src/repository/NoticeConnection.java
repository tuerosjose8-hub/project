package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import interfaces.NoticeRepository;
import models.Notice;



 public class NoticeConnection implements NoticeRepository {
	
	public boolean addNotice(Notice notice) {
		
		String query = "INSERT INTO notices "
				+ "(title, message, category, priority, year_level, created_by, deadline_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";	
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
		
			stmt.setString(1, notice.getTitle());
			stmt.setString(2, notice.getMessage());
			stmt.setString(3, notice.getCategory());
			stmt.setString(4, notice.getPriority());
			stmt.setString(5, notice.getYearLevel());
			stmt.setInt(6, notice.getCreatedBy());

			if(notice.getDeadlineDate() == null) {
				stmt.setNull(7, Types.DATE);
			}
			else {
				stmt.setString(7, notice.getDeadlineDate());
			}
			
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Notice> getAllNotices(int limit){
		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
						+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
						+ "FROM notices n "
						+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
						+ "ORDER BY n.created_at DESC "
						+ "LIMIT ?";
		return getNoticeList(query,limit);
	}
	public ArrayList<Notice> getRecent(int limit){
		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
						+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
						+ "FROM notices n "
						+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
						+ "ORDER BY n.created_at DESC "
						+ "LIMIT ?";
		
		return getNoticeList(query,limit);
	}
	public ArrayList<Notice> getImportantNotices(int limit){
		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
						+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
						+ "FROM notices n "
						+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
						+ "WHERE n.priority = 'High' "
						+ "ORDER BY n.created_at DESC "
						+ "LIMIT ?";
		
		return getNoticeList(query,limit);
	}
	public ArrayList<Notice> getUpcomingEvents (int limit){
		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
						+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
						+ "FROM notices n "
						+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
						+ "WHERE n.deadline_date IS NOT NULL "
						+ "AND n.deadline_date >= CURDATE() "
						+ "ORDER BY n.deadline_date ASC "
						+ "LIMIT ?";
		
		return getNoticeList(query,limit);
	}
	public ArrayList<Notice> getStudentAllNotices(int limit, String studentYear) {

		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
				+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
				+ "FROM notices n "
				+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
				+ "WHERE n.year_level = ? OR n.year_level = 'All' "
				+ "ORDER BY n.created_at DESC "
				+ "LIMIT ?";

		return getStudentNoticeList(query, studentYear, limit);
	}
	
	public ArrayList<Notice> getStudentRecent(int limit, String studentYear) {

		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
				+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
				+ "FROM notices n "
				+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
				+ "WHERE n.year_level = ? OR n.year_level = 'All' "
				+ "ORDER BY n.created_at DESC "
				+ "LIMIT ?";

		return getStudentNoticeList(query, studentYear, limit);
	}
	
	public ArrayList<Notice> getStudentImportantNotices(int limit, String studentYear) {

		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
				+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
				+ "FROM notices n "
				+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
				+ "WHERE n.priority = 'High' "
				+ "AND (n.year_level = ? OR n.year_level = 'All') "
				+ "ORDER BY n.created_at DESC "
				+ "LIMIT ?";

		return getStudentNoticeList(query, studentYear, limit);
	}
	
	public ArrayList<Notice> getStudentUpcomingEvents(int limit, String studentYear) {

		String query = "SELECT n.notice_id, n.title, n.message, n.category, n.priority, "
				+ "n.year_level, n.created_by, n.deadline_date, u.first_name, u.last_name "
				+ "FROM notices n "
				+ "JOIN usersandpasswords u ON n.created_by = u.user_id "
				+ "WHERE n.deadline_date IS NOT NULL "
				+ "AND n.deadline_date >= CURDATE() "
				+ "AND (n.year_level = ? OR n.year_level = 'All') "
				+ "ORDER BY n.deadline_date ASC "
				+ "LIMIT ?";

		return getStudentNoticeList(query, studentYear, limit);
	}
	
private ArrayList<Notice> getNoticeList(String query, int limit){
		
		ArrayList<Notice> notices = new ArrayList<Notice>();
		
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, limit);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int noticeId = rs.getInt("notice_id");
				String title = rs.getString("title");
				String message = rs.getString("message");
				String category = rs.getString("category");
				String priority = rs.getString("priority");
				String yearLevel = rs.getString("year_level");
				int createdBy = rs.getInt("created_by");
				String createdByName = rs.getString("first_name") + " " + rs.getString("last_name");
				String deadlineDate = rs.getString("deadline_date");
				
				Notice notice = new Notice.NoticeBuilder(title, message)
						.noticeId(noticeId)
						.category(category)
						.priority(priority)
						.yearLevel(yearLevel)
						.createdBy(createdBy)
						.createdByName(createdByName)
						.deadlineDate(deadlineDate)
						.build();				
				notices.add(notice);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return notices;
		
	}
	
	private ArrayList<Notice> getStudentNoticeList(String query, String studentYear, int limit) {

		ArrayList<Notice> notices = new ArrayList<Notice>();

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setString(1, studentYear);
			stmt.setInt(2, limit);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				int noticeId = rs.getInt("notice_id");
				String title = rs.getString("title");
				String message = rs.getString("message");
				String category = rs.getString("category");
				String priority = rs.getString("priority");
				String yearLevel = rs.getString("year_level");
				int createdBy = rs.getInt("created_by");
				String createdByName = rs.getString("first_name") + " " + rs.getString("last_name");
				String deadlineDate = rs.getString("deadline_date");

				Notice notice = new Notice.NoticeBuilder(title, message)
						.noticeId(noticeId)
						.category(category)
						.priority(priority)
						.yearLevel(yearLevel)
						.createdBy(createdBy)
						.createdByName(createdByName)
						.deadlineDate(deadlineDate)
						.build();
				notices.add(notice);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return notices;
	}
	
	
	
}