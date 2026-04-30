package ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import factory.NoticeFilterFactory;
import interfaces.NoticeFilterStrategy;
import interfaces.NoticeRepository;
import models.Notice;

public class ViewAllPage {
	
	JFrame frame = new JFrame();
	String pageTitle;
	String studentYear;
	NoticeRepository noticeRepository = new repository.NoticeConnection();
	NoticeFilterFactory factory = new NoticeFilterFactory();
	
	public ViewAllPage(String pageTitle) {
		this.pageTitle = pageTitle;
		setupPage();
	}
	public ViewAllPage(String pageTitle, String studentYear) {
		this.pageTitle = pageTitle;
		this.studentYear = studentYear;
		setupPage();
	}
public void setupPage() {
		
		frame.setTitle(pageTitle);
		frame.setSize(700, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel title = new JLabel(pageTitle);
		title.setBounds(30, 20, 400, 40);
		title.setFont(new Font("Arial", Font.BOLD, 26));
		title.setForeground(Color.BLUE);
		
		JPanel noticesPanel = new JPanel();
		noticesPanel.setBackground(Color.WHITE);
		noticesPanel.setLayout(new GridLayout(0, 1, 5, 5));
		
		JScrollPane scroll = new JScrollPane(noticesPanel);
		scroll.setBounds(30, 90, 620, 330);
		
		ArrayList<Notice> notices = getNotices();
		
		displayNotices(noticesPanel, notices);
		JButton close = new JButton("Close");
		close.setBounds(280, 450, 120, 30);
		close.setFocusable(false);
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
		
		frame.add(title);
		frame.add(scroll);
		frame.add(close);
		
		frame.setVisible(true);
}
public ArrayList<Notice> getNotices() {

		NoticeFilterStrategy strategy = factory.getStrategy(pageTitle);

		return strategy.getNotices(noticeRepository, 50, studentYear);	
}

public void displayNotices(JPanel noticesPanel, ArrayList<Notice> notices) {

		if(notices.size() == 0) {
		JLabel empty = new JLabel("No notices found.");
		empty.setFont(new Font("Arial", Font.PLAIN, 16));
		noticesPanel.add(empty);
		return;
	}

	for(int i = 0; i < notices.size(); i++) {
		
		Notice notice = notices.get(i);
		
		JButton noticeButton = new JButton(notice.getTitle());
		noticeButton.setFocusable(false);
		noticeButton.setHorizontalAlignment(JButton.LEFT);
		
		noticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NoticeDetails(notice);
			}
		});
		
		noticesPanel.add(noticeButton);
	}
}

}