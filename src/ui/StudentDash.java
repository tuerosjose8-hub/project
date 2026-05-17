package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interfaces.NoticeRepository;
import models.Notice;

public class StudentDash {
	
	JFrame frame = new JFrame("Student Dashboard");
	String studentName;
	String studentYear;
	NoticeRepository noticeRepository = new repository.NoticeConnection();

	private final Color backgroundColor = new Color(245, 247, 251);
	private final Color headerColor = new Color(20, 45, 90);
	private final Color cardColor = Color.WHITE;
	private final Color primaryColor = new Color(35, 96, 191);
	private final Color textColor = new Color(35, 35, 35);
	private final Color softBorder = new Color(220, 225, 235);
	
	public StudentDash(String studentName, String studentYear) {
		
		this.studentName = studentName;
		this.studentYear = studentYear;

		frame.setSize(1100,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(backgroundColor);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		Header();
		recentNotices();
		allnotices();
		importantNotices();
		upcomingEvents();

		frame.setVisible(true);
	}
	
	public void Header() {
		
		JPanel header = new JPanel();

		header.setBounds(0, 0, 1100, 105);
		header.setLayout(null);
		header.setBackground(headerColor);
		
		JLabel title = new JLabel("CS Department Notice Board");
		title.setBounds(35,20,500,40);
		title.setFont(new Font("Arial", Font.BOLD, 28));
		title.setForeground(Color.WHITE);
		
		JLabel welcome = new JLabel("Welcome, " + studentName + " (" + studentYear + ")");
		welcome.setBounds(38,60,500,30);
		welcome.setFont(new Font("Arial",Font.PLAIN,16));
		welcome.setForeground(new Color(220, 230, 245));
		
		JLabel role = new JLabel("STUDENT VIEW");
		role.setBounds(760, 30, 140, 32);
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setFont(new Font("Arial", Font.BOLD, 12));
		role.setOpaque(true);
		role.setBackground(new Color(238, 245, 255));
		role.setForeground(headerColor);
		role.setBorder(BorderFactory.createLineBorder(new Color(238, 245, 255)));
		
		JButton logout = new JButton("Logout");
		logout.setBounds(930,30,115,32);
		logout.setFocusable(false);
		logout.setOpaque(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(Color.WHITE);
		logout.setForeground(headerColor);
		logout.setFont(new Font("Arial", Font.BOLD, 13));
		logout.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage();
			}
		});
		
		header.add(title);
		header.add(welcome);
		header.add(role);
		header.add(logout);

		frame.add(header);
	}
	
	public void recentNotices() {
		
		JPanel panel = createPanel(30, 140, 630, 185);

		JLabel subTitle = createSubtitle("Recent Notices", 20, 18, 250, 25);
		JButton viewall = createSmallButton("View All", 510, 18, 90, 28);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllPage("Recent Notices", studentYear);
			}
		});

		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getStudentRecent(3, studentYear);

		addNoticeIfExists(panel, notices, 0, 25, 70, 170, 70);
		addNoticeIfExists(panel, notices, 1, 230, 70, 170, 70);
		addNoticeIfExists(panel, notices, 2, 435, 70, 170, 70);
		
		frame.add(panel);
	}
	
	public void allnotices() {
		
		JPanel panel = createPanel(30, 350, 630, 285);

		JLabel subTitle = createSubtitle("All Notices", 20, 18, 250, 25);
		JButton viewall = createSmallButton("View All", 510, 18, 90, 28);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllPage("All Notices", studentYear);
			}
		});

		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getStudentAllNotices(4, studentYear);

		addNoticeIfExists(panel, notices, 0, 25, 65, 575, 45);
		addNoticeIfExists(panel, notices, 1, 25, 115, 575, 45);
		addNoticeIfExists(panel, notices, 2, 25, 165, 575, 45);
		addNoticeIfExists(panel, notices, 3, 25, 215, 575, 45);
		
		frame.add(panel);
	}
	
	public void importantNotices() {

		JPanel panel = createPanel(700, 195, 360, 195);

		JLabel subTitle = createSubtitle("Important Notices", 20, 18, 190, 25);
		JButton viewall = createSmallButton("View All", 245, 18, 90, 28);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllPage("Important Notices", studentYear);
			}
		});

		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getStudentImportantNotices(3, studentYear);

		addNoticeIfExists(panel, notices, 0, 25, 65, 310, 40);
		addNoticeIfExists(panel, notices, 1, 25, 110, 310, 40);
		addNoticeIfExists(panel, notices, 2, 25, 155, 310, 40);
		
		frame.add(panel);
	}
	
	public void upcomingEvents() {
		
		JPanel panel = createPanel(700, 420, 360, 215);

		JLabel subTitle = createSubtitle("Upcoming Events", 20, 18, 190, 25);
		JButton viewall = createSmallButton("View All", 245, 18, 90, 28);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllPage("Upcoming Events", studentYear);
			}
		});

		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getStudentUpcomingEvents(3, studentYear);

		addNoticeIfExists(panel, notices, 0, 25, 65, 310, 40);
		addNoticeIfExists(panel, notices, 1, 25, 115, 310, 40);
		addNoticeIfExists(panel, notices, 2, 25, 165, 310, 40);
		
		frame.add(panel);
	}
	
	public JPanel createPanel(int x, int y, int width, int height) {

		JPanel panel = new JPanel();

		panel.setBounds(x, y, width, height);
		panel.setBackground(cardColor);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(softBorder),
				new EmptyBorder(8, 8, 8, 8)));

		return panel;
	}
	
	public JLabel createSubtitle(String text, int x, int y, int width, int height) {

		JLabel label = new JLabel(text);

		label.setBounds(x, y, width, height);
		label.setFont(new Font("Arial", Font.BOLD, 17));
		label.setForeground(textColor);

		return label;
	}
	
	public JButton createSmallButton(String text, int x, int y, int width, int height) {

		JButton button = new JButton(text);

		button.setBounds(x, y, width, height);
		button.setFocusable(false);
		button.setOpaque(true);
		button.setContentAreaFilled(true);
		button.setBackground(new Color(245, 248, 255));
		button.setForeground(primaryColor);
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBorder(BorderFactory.createLineBorder(new Color(205, 220, 245)));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));

		return button;
	}
	
	public void addNoticeIfExists(JPanel panel, ArrayList<Notice>notices, int index, int x, int y, int width, int height) {

		if(notices.size() > index) {
			panel.add(createNoticeCard(notices.get(index), x, y, width, height));
		}
		else {
			JLabel empty = new JLabel("No notice available");
			empty.setBounds(x, y, width, height);
			empty.setFont(new Font("Arial", Font.PLAIN, 12));
			empty.setForeground(Color.GRAY);
			empty.setHorizontalAlignment(SwingConstants.CENTER);
			empty.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235)));
			panel.add(empty);
		}
	}
	
	public JPanel createNoticeCard(Notice notice, int x, int y, int width, int height) {

		JPanel card = new JPanel();

		card.setBounds(x, y, width, height);
		card.setLayout(null);
		card.setBackground(new Color(250, 252, 255));
		card.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(getPriorityColor(notice.getPriority()), 2),
				new EmptyBorder(5, 8, 5, 8)));

		card.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel title = new JLabel(shorten(notice.getTitle(), 30));
		title.setBounds(10, 6, width - 20, 18);
		title.setFont(new Font("Arial", Font.BOLD, 13));
		title.setForeground(textColor);

		JLabel category = new JLabel(shorten(notice.getCategory(), 24));
		category.setBounds(10, height - 22, width / 2, 16);
		category.setFont(new Font("Arial", Font.PLAIN, 11));
		category.setForeground(new Color(80, 80, 80));

		JLabel priority = new JLabel(notice.getPriority());
		priority.setBounds(width - 80, height - 22, 70, 16);
		priority.setHorizontalAlignment(SwingConstants.RIGHT);
		priority.setFont(new Font("Arial", Font.BOLD, 11));
		priority.setForeground(getPriorityColor(notice.getPriority()));

		card.add(title);
		card.add(category);
		card.add(priority);

		card.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new NoticeDetails(notice);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				card.setBackground(new Color(240, 245, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				card.setBackground(new Color(250, 252, 255));
			}
		});

		return card;
	}
	
	public String shorten(String text, int limit) {

		if(text == null) {
			return "";
		}

		if(text.length() <= limit) {
			return text;
		}

		return text.substring(0, limit) + "...";
	}
	
	public Color getPriorityColor(String priority) {

		if(priority != null && priority.equals("High")) {
			return new Color(210, 70, 70);
		}

		if(priority != null && priority.equals("Medium")) {
			return new Color(220, 145, 45);
		}

		return new Color(85, 145, 95);
	}
}