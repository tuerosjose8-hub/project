package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import factory.NoticeFilterFactory;
import interfaces.NoticeFilterStrategy;
import strategy.ImportantNoticeStrategy;
import strategy.RecentNoticeStrategy;
import strategy.UpcomingNoticeStrategy;

public class NoticeFilterFactoryTest {
	
	@Test
	public void testRecentNoticeStrategy() {
		
		NoticeFilterFactory factory = new NoticeFilterFactory();
		NoticeFilterStrategy strategy = factory.getStrategy("Recent Notices");

		assertTrue(strategy instanceof RecentNoticeStrategy);
	}
	
	@Test
	public void testUpcomingNoticeStrategy() {
		
		NoticeFilterFactory factory = new NoticeFilterFactory();
		NoticeFilterStrategy strategy = factory.getStrategy("Upcoming Events");

		assertTrue(strategy instanceof UpcomingNoticeStrategy);
	}

	@Test
	public void testImportantNoticeStrategy() {
		
		NoticeFilterFactory factory = new NoticeFilterFactory();
		NoticeFilterStrategy strategy = factory.getStrategy("Important Notices");

		assertTrue(strategy instanceof ImportantNoticeStrategy);
	}
}
