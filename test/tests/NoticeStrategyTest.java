package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import interfaces.NoticeRepository;
import models.Notice;
import strategy.AllNoticeStrategy;
import strategy.ImportantNoticeStrategy;
import strategy.RecentNoticeStrategy;
import strategy.UpcomingNoticeStrategy;

public class NoticeStrategyTest {

	@Test
	public void testAllNoticeStrategyForAdmin() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		AllNoticeStrategy strategy = new AllNoticeStrategy();

		strategy.getNotices(fakeRepository, 10, null);

		assertEquals("getAllNotices", fakeRepository.methodCalled);
	}

	@Test
	public void testAllNoticeStrategyForStudent() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		AllNoticeStrategy strategy = new AllNoticeStrategy();

		strategy.getNotices(fakeRepository, 10, "Junior");

		assertEquals("getStudentAllNotices", fakeRepository.methodCalled);
	}

	@Test
	public void testRecentNoticeStrategyForAdmin() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		RecentNoticeStrategy strategy = new RecentNoticeStrategy();

		strategy.getNotices(fakeRepository, 5, null);

		assertEquals("getRecent", fakeRepository.methodCalled);
	}

	@Test
	public void testRecentNoticeStrategyForStudent() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		RecentNoticeStrategy strategy = new RecentNoticeStrategy();

		strategy.getNotices(fakeRepository, 5, "Junior");

		assertEquals("getStudentRecent", fakeRepository.methodCalled);
	}

	@Test
	public void testImportantNoticeStrategyForAdmin() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		ImportantNoticeStrategy strategy = new ImportantNoticeStrategy();

		strategy.getNotices(fakeRepository, 5, null);

		assertEquals("getImportantNotices", fakeRepository.methodCalled);
	}

	@Test
	public void testImportantNoticeStrategyForStudent() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		ImportantNoticeStrategy strategy = new ImportantNoticeStrategy();

		strategy.getNotices(fakeRepository, 5, "Junior");

		assertEquals("getStudentImportantNotices", fakeRepository.methodCalled);
	}

	@Test
	public void testUpcomingNoticeStrategyForAdmin() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		UpcomingNoticeStrategy strategy = new UpcomingNoticeStrategy();

		strategy.getNotices(fakeRepository, 5, null);

		assertEquals("getUpcomingEvents", fakeRepository.methodCalled);
	}

	@Test
	public void testUpcomingNoticeStrategyForStudent() {
		FakeNoticeRepository fakeRepository = new FakeNoticeRepository();
		UpcomingNoticeStrategy strategy = new UpcomingNoticeStrategy();

		strategy.getNotices(fakeRepository, 5, "Junior");

		assertEquals("getStudentUpcomingEvents", fakeRepository.methodCalled);
	}

	private static class FakeNoticeRepository implements NoticeRepository {

		private String methodCalled = "";

		@Override
		public boolean addNotice(Notice notice) {
			return true;
		}

		@Override
		public ArrayList<Notice> getAllNotices(int limit) {
			methodCalled = "getAllNotices";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getRecent(int limit) {
			methodCalled = "getRecent";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getImportantNotices(int limit) {
			methodCalled = "getImportantNotices";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getUpcomingEvents(int limit) {
			methodCalled = "getUpcomingEvents";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentAllNotices(int limit, String studentYear) {
			methodCalled = "getStudentAllNotices";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentRecent(int limit, String studentYear) {
			methodCalled = "getStudentRecent";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentImportantNotices(int limit, String studentYear) {
			methodCalled = "getStudentImportantNotices";
			return new ArrayList<Notice>();
		}

		@Override
		public ArrayList<Notice> getStudentUpcomingEvents(int limit, String studentYear) {
			methodCalled = "getStudentUpcomingEvents";
			return new ArrayList<Notice>();
		}
	}
}