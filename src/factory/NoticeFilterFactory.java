package factory;
import java.util.HashMap;

import interfaces.NoticeFilterStrategy;
import strategy.AllNoticeStrategy;
import strategy.ImportantNoticeStrategy;
import strategy.RecentNoticeStrategy;
import strategy.UpcomingNoticeStrategy;
public class NoticeFilterFactory {
		
	private HashMap<String, NoticeFilterStrategy> strategies;

	public NoticeFilterFactory() {
		
		strategies = new HashMap<String, NoticeFilterStrategy>();
		
		strategies.put("All Notices", new AllNoticeStrategy());
		strategies.put("Recent Notices", new RecentNoticeStrategy());
		strategies.put("Important Notices", new ImportantNoticeStrategy());
		strategies.put("Upcoming Events", new UpcomingNoticeStrategy());
	}
	public NoticeFilterStrategy getStrategy(String pageTitle) {
		return strategies.getOrDefault(pageTitle, new AllNoticeStrategy());
	} // ordefault 
}