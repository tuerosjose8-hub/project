package ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import models.Notice;

public class NoticeDetails {
	
JFrame frame = new JFrame("Notice Details");
	
	public NoticeDetails(Notice notice) {
		
		frame.setSize(600, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel title = new JLabel(notice.getTitle());
		title.setBounds(30, 20, 520, 35);
		title.setFont(new Font("Arial", Font.BOLD, 22));
		title.setForeground(Color.BLUE);
		
		JLabel category = new JLabel("Category: " + notice.getCategory());
		category.setBounds(30, 70, 300, 25);
		
		JLabel priority = new JLabel("Priority: " + notice.getPriority());
		priority.setBounds(30, 100, 300, 25);
		
		JLabel year = new JLabel("Year: " + notice.getYearLevel());
		year.setBounds(30, 130, 300, 25);
		
		JLabel creator = new JLabel("Created by: " + notice.getCreatedByName());
		creator.setBounds(30, 160, 300, 25);
		
		String deadlineText = notice.getDeadlineDate();

		if(deadlineText == null) {
			deadlineText = "No deadline";
		}
		
		JLabel deadline = new JLabel("Deadline: " + deadlineText);
		deadline.setBounds(30, 190, 300, 25);
		
		JTextArea message = new JTextArea(notice.getMessage());
		message.setBounds(30, 230, 520, 170);
		message.setEditable(false);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		
		JButton close = new JButton("Close");
		close.setBounds(230, 430, 120, 35);
		close.setFocusable(false);
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
			
		});
		
		frame.add(title);
		frame.add(category);
		frame.add(priority);
		frame.add(year);
		frame.add(creator);
		frame.add(deadline);
		frame.add(message);
		frame.add(close);
		
		frame.setVisible(true);
		
	
	}
}