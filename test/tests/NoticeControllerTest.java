package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controller.NoticeController;
import interfaces.NoticeRepository;
import models.Notice;

public class NoticeControllerTest {

	@Test
	public void testGetDeadlineDateNextWeek() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		NoticeController controller = new NoticeController(fakeRepository);

		String expectedDate = LocalDate.now().plusWeeks(1).toString();
		String actualDate = controller.getDeadlineDate("Next week");

		assertEquals(expectedDate, actualDate);
	}

	@Test
	public void testCreateNoticeReturnsFalseWhenTitleIsEmpty() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		NoticeController controller = new NoticeController(fakeRepository);

		boolean result = controller.createNotice(
				"",
				"Message here",
				"Academic",
				"High",
				"Junior",
				"Next week",
				1
		);

		assertFalse(result);
	}

	@Test
	public void testCreateNoticeReturnsFalseWhenMessageIsEmpty() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		NoticeController controller = new NoticeController(fakeRepository);

		boolean result = controller.createNotice(
				"Exam Notice",
				"",
				"Academic",
				"High",
				"Junior",
				"Next week",
				1
		);

		assertFalse(result);
	}

	@Test
	public void testCreateNoticeSavesValidNotice() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		NoticeController controller = new NoticeController(fakeRepository);

		boolean result = controller.createNotice(
				"Exam Notice",
				"The exam is next week",
				"Academic",
				"High",
				"Junior",
				"Next week",
				1
		);

		assertTrue(result);
		assertEquals(1, fakeRepository.savedNotices.size());

		Notice savedNotice = fakeRepository.savedNotices.get(0);

		assertEquals("Exam Notice", savedNotice.getTitle());
		assertEquals("The exam is next week", savedNotice.getMessage());
		assertEquals("Academic", savedNotice.getCategory());
		assertEquals("High", savedNotice.getPriority());
		assertEquals("Junior", savedNotice.getYearLevel());
		assertEquals(1, savedNotice.getCreatedBy());
	}

	private static class FakeNoticeRepository implements NoticeRepository {

		private ArrayList<Notice> savedNotices = new ArrayList<Notice>();

		@Override
		public boolean addNotice(Notice notice) {
			savedNotices.add(notice);
			return true;
		}

		@Override
		public ArrayList<Notice> getAllNotices(int limit) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getRecent(int limit) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getImportantNotices(int limit) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getUpcomingEvents(int limit) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentAllNotices(int limit, String studentYear) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentRecent(int limit, String studentYear) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentImportantNotices(int limit, String studentYear) {
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentUpcomingEvents(int limit, String studentYear) {
			return new ArrayList<Notice>();
		}
	}
}