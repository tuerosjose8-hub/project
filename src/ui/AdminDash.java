package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.NoticeRepository;
import models.Notice;



public class AdminDash {
	
	JFrame frame = new JFrame("Admin Dashboard");
	String adminName;
	int adminId;
	NoticeRepository noticeRepository = new repository.NoticeConnection();

	
	public AdminDash(String adminName, int adminId) {
		
		this.adminName = adminName;
		this.adminId = adminId;
		
		
		frame.setSize(1100,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		Header();
		createNotice();
		recentNotices();
		allnotices();
		importantNotices();
		upcomingEvents();
		frame.setVisible(true);
	}
	
	public void Header() {
		
		JLabel title = new JLabel("CS Department Notice Board");
		title.setBounds(30,20,500,40);
		title.setFont(new Font("Arial", Font.BOLD, 28));
		title.setForeground(Color.BLUE);
		
		JLabel welcome = new JLabel("Welcome Admin, " + adminName);
		welcome.setBounds(30,60,500,30);
		welcome.setFont(new Font("Arial",Font.PLAIN,18));
		welcome.setForeground(Color.DARK_GRAY);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(950,30,100,35);
		logout.setFocusable(false);
		logout.setBackground(Color.GRAY);
		logout.setForeground(Color.BLACK);
		
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new LoginPage();
			}
		});
		frame.add(title);
		frame.add(welcome);
		frame.add(logout);
		
	}
	
	public void createNotice() {
		
		JButton create = new JButton("Create Notice");
		create.setBounds(820, 80, 230, 35);
		create.setFocusable(false);
		create.setBackground(Color.BLUE);
		create.setForeground(Color.BLACK);
		
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreatePage(adminId);
			}
			
		});
		frame.add(create);
	}
	
	public void recentNotices() {
		
		JPanel panel = createPanel(30, 120, 650, 170);
		JLabel subTitle = createSubtitle("Recent Notices", 20, 10, 200, 25);
		JButton viewall = new JButton("View All");
		viewall.setBounds(530, 10, 90, 25);
		viewall.setFocusable(false);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewAllPage("Recent Notices");
				
			}
			
		});
		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getRecent(3);

		addNoticeIfExists(panel, notices, 0, 20, 55, 190, 70);
		addNoticeIfExists(panel, notices, 1, 225, 55, 190, 70);
		addNoticeIfExists(panel, notices, 2, 430, 55, 190, 70);
		
		frame.add(panel);
	}
	
	public void allnotices() {
		
		JPanel panel = createPanel(30, 320, 650, 300);
		JLabel subTitle = createSubtitle("All Notices", 20, 10, 200, 25);
		JButton viewall = new JButton("View All");
		viewall.setBounds(530, 10, 90, 25);
		viewall.setFocusable(false);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewAllPage("All Notices");
				
			}
			
		});
		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getAllNotices(4);

		addNoticeIfExists(panel, notices, 0, 20, 55, 590, 45);
		addNoticeIfExists(panel, notices, 1, 20, 110, 590, 45);
		addNoticeIfExists(panel, notices, 2, 20, 165, 590, 45);
		addNoticeIfExists(panel, notices, 3, 20, 220, 590, 45);
		
		frame.add(panel);
	}
	public void importantNotices() {
		JPanel panel = createPanel(710, 120, 340, 240);
		JLabel subTitle = createSubtitle("Important Notices", 20, 10, 180, 25);
		JButton viewall = new JButton("View All");
		viewall.setBounds(230, 10, 90, 25);
		viewall.setFocusable(false);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewAllPage("Important Notices");
				
			}
			
		});
		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getImportantNotices(3);

		addNoticeIfExists(panel, notices, 0, 20, 55, 290, 45);
		addNoticeIfExists(panel, notices, 1, 20, 110, 290, 45);
		addNoticeIfExists(panel, notices, 2, 20, 165, 290, 45);
		
		frame.add(panel);
	}
	
	public void upcomingEvents() {
		
		JPanel panel = createPanel(710, 390, 340, 230);
		JLabel subTitle = createSubtitle("Upcoming Events", 20, 10, 180, 25);
		JButton viewall = new JButton("View All");
		viewall.setBounds(230, 10, 90, 25);
		viewall.setFocusable(false);
		
		viewall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewAllPage("Upcoming Events");
				
			}
			
		});
		panel.add(subTitle);
		panel.add(viewall);
		
		ArrayList<Notice> notices = noticeRepository.getUpcomingEvents(3);

		addNoticeIfExists(panel, notices, 0, 20, 55, 290, 45);
		addNoticeIfExists(panel, notices, 1, 20, 110, 290, 45);
		addNoticeIfExists(panel, notices, 2, 20, 165, 290, 45);
		
		frame.add(panel);
		
	}
	//repetitive so better to create a method
	public JPanel createPanel(int x, int y, int width, int height) {
		JPanel panel = new JPanel();
		panel.setBounds(x, y, width, height);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		return panel;
	}
	public JLabel createSubtitle(String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		return label;
	}
	public void addNoticeIfExists(JPanel panel, ArrayList<Notice>notices, int index, int x, int y, int width, int height) {
		if(notices.size() > index) {
			panel.add(createNoticeButton(notices.get(index),x,y,width,height));
		}
	}
	public JButton createNoticeButton(Notice notice, int x, int y, int width, int height) {

		JButton button = new JButton(notice.getTitle());

		button.setBounds(x, y, width, height);
		button.setFocusable(false);
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setHorizontalAlignment(JButton.LEFT);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NoticeDetails(notice);
			}
		});

		return button;
	}
}
