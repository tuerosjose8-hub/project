package ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.NoticeController;
import enums.Priority;
import enums.YearLevel;

public class CreatePage {
	
	JFrame frame = new JFrame("Create Notice");
	JTextField titleField = new JTextField();
	JTextArea messageArea = new JTextArea();
	
	String[] categories = {"Academic", "Internship Opportunities", "CS Club", "Events", "Deadlines"};
	JComboBox<String> categoryBox = new JComboBox <String>(categories);
	
	String[] priorities = {
			Priority.HIGH.getDatabaseValue(),
			Priority.MEDIUM.getDatabaseValue(),
			Priority.LOW.getDatabaseValue()
	};
	JComboBox<String> priorityBox = new JComboBox <String>(priorities);
	
	String[] years = {
			YearLevel.FRESHMAN.getDatabaseValue(),
			YearLevel.SOPHOMORE.getDatabaseValue(),
			YearLevel.JUNIOR.getDatabaseValue(),
			YearLevel.SENIOR.getDatabaseValue(),
			YearLevel.GRADUATE.getDatabaseValue(),
			YearLevel.ALL.getDatabaseValue()
	};
	JComboBox<String> yearBox = new JComboBox <String>(years);
	
	String[] deadlines = {"No deadline", "Next week", "Two weeks", "Three weeks", "One month"};
	JComboBox<String> deadlineBox = new JComboBox<String>(deadlines);
	    
	JButton save = new JButton("Save Notice");
	JButton cancel = new JButton("Cancel");
	
	JLabel message = new JLabel();
	
	int createdBy;
	NoticeController noticeController = new NoticeController(new repository.NoticeConnection());
	
	public CreatePage(int createdBy) {
		
        this.createdBy = createdBy;
        frame.setSize(600,700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel title = new JLabel("Create New Notice");
		title.setBounds(30, 20, 400, 40);
		title.setFont(new Font("Arial", Font.BOLD, 26));
		title.setForeground(Color.BLUE);
		
		JLabel notice = new JLabel("Notice Title:");
		notice.setBounds(30, 90, 150, 25);
		
		titleField.setBounds(30,120,500,35);
		
		JLabel messagelabel = new JLabel("Message: ");
		messagelabel.setBounds(30,170,150,25);
		
		messageArea.setBounds(30, 200, 500, 120);
		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);
		
		JLabel category = new JLabel("Category:");
		category.setBounds(30, 340, 150, 25);
		
		categoryBox.setBounds(150,340,200,30);
		
		JLabel priority = new JLabel("Priority:");
		priority.setBounds(30,385,150,25);
		
		priorityBox.setBounds(150,385,200,30);
		
		JLabel year = new JLabel("Year:");
		year.setBounds(30,430,150,25);
		
		yearBox.setBounds(150, 430, 200, 30);
		
		JLabel deadline = new JLabel("Deadline:");
		deadline.setBounds(30, 475, 150, 25);

		deadlineBox.setBounds(150, 475, 200, 30);
		
		save.setBounds(150,535,140,35);
		save.setFocusable(false);
		save.setBackground(Color.BLUE);
		save.setForeground(Color.BLACK);
		
		cancel.setBounds(310, 535, 120, 35);
		cancel.setFocusable(false);
		cancel.setBackground(Color.BLUE);
		cancel.setForeground(Color.BLACK);
		
		message.setBounds(30,590,500,25);
		message.setFont(new Font("Arial", Font.BOLD, 14));
		

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String noticeTitle = titleField.getText();
				String noticeMessage = messageArea.getText();
				String category = String.valueOf(categoryBox.getSelectedItem());
				String priority = String.valueOf(priorityBox.getSelectedItem());
				String year = String.valueOf(yearBox.getSelectedItem());
				String deadlineChoice = String.valueOf(deadlineBox.getSelectedItem());

				if(noticeTitle.equals("") || noticeMessage.equals("")) {
					showError("Title and message cannot be empty");
					return;
				}

				boolean saved = noticeController.createNotice(
						noticeTitle,
						noticeMessage,
						category,
						priority,
						year,
						deadlineChoice,
						createdBy);
				if(saved == false) {
					showError("Error saving notice");
					return;
				}

				showSuccess("Notice saved to database");
				clearForm();
		
				
			}
		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(title);
		frame.add(titleField);
		frame.add(notice);
		frame.add(messagelabel);
		frame.add(messageArea);
		frame.add(category);
		frame.add(categoryBox);
		frame.add(priority);
		frame.add(priorityBox);
		frame.add(year);
		frame.add(yearBox);
		frame.add(deadline);
		frame.add(deadlineBox);
		frame.add(save);
		frame.add(cancel);
		frame.add(message);
		
		frame.setVisible(true);
	}
	public void showError(String text) {
		message.setForeground(Color.RED);
		message.setText(text);
	}

	public void showSuccess(String text) {
		message.setForeground(Color.BLUE);
		message.setText(text);
	}
	public void clearForm() {

		titleField.setText("");
		messageArea.setText("");
		categoryBox.setSelectedIndex(0);
		priorityBox.setSelectedIndex(0);
		yearBox.setSelectedIndex(0);
		deadlineBox.setSelectedIndex(0);
	}
	
		
		
	
}