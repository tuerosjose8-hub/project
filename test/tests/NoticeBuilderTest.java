package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import models.Notice;

public class NoticeBuilderTest {
	
	@Test
	public void testNoticeBuilderCreatesNotice() {
		
		Notice notice = new Notice.NoticeBuilder("Exam", "is next week")
				.category("Academic")
				.priority("High")
				.yearLevel("Junior")
				.createdBy(1)
				.deadlineDate("2026-05-15")
				.build();
		
		assertEquals("Exam", notice.getTitle());
		assertEquals("is next week", notice.getMessage());
		assertEquals("Academic", notice.getCategory());
		assertEquals("High", notice.getPriority());
		assertEquals("Junior", notice.getYearLevel());
		assertEquals(1, notice.getCreatedBy());
		assertEquals("2026-05-15", notice.getDeadlineDate());
	}
}
