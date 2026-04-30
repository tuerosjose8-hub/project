package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Taskbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import factory.DashboardFactory;
import interfaces.UserRepository;
import models.User;
import repository.UserD;



public class LoginPage   {
	
	
	JFrame frame = new JFrame("Computer Science Department Notice Board");
	JLabel title = new JLabel("Computer Science Department Notice Board");
	JLabel sub = new JLabel ("Log in to view department notices");
	
	JLabel logoLabel = new JLabel();
	
	JButton loginButton = new JButton("Login");
	JButton reset = new JButton("Reset");
	
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	
	UserRepository userRepository = new repository.UserD();
	
	public LoginPage(){
		ImageIcon appIcon = new ImageIcon(getClass().getResource("/project/newpaltzsmall.png"));

		frame.setIconImage(appIcon.getImage());

		if (Taskbar.isTaskbarSupported()) {
		    Taskbar taskbar = Taskbar.getTaskbar();

		    if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
		        taskbar.setIconImage(appIcon.getImage());
		    }
		}
		
		frame.setSize(900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(240, 244, 248));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		title.setBounds(0,20,900,55);
		title.setFont(new Font ("Arial", Font.BOLD,32));
		title.setForeground(new Color(30,50,80));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		sub.setBounds(0, 75,900,30);
		sub.setFont(new Font ("Arial", Font.BOLD,16));
		sub.setForeground(new Color(90,90,90));
		sub.setHorizontalAlignment(JLabel.CENTER);
		
		logoLabel.setBounds(60,140,380,340);
		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		logoLabel.setVerticalAlignment(JLabel.CENTER);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(40,120,420,380);
		imagePanel.setBackground(new Color(220,228,240));
		imagePanel.setBorder(BorderFactory.createLineBorder(new Color(180,195,215),1));
		imagePanel.setLayout(null);
		
		int rightpanel = 520;
		
		userIDLabel.setBounds(rightpanel,160,110,30);
		userIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		userIDField.setBounds(rightpanel, 195, 290, 38);
		userIDField.setFont(new Font("Arial", Font.BOLD, 14));
		userIDField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(180,195,215),1), BorderFactory.createEmptyBorder(4,8,4,8)));
		
		userPasswordLabel.setBounds(rightpanel,255,110,30);
		userPasswordLabel.setFont(new Font("Arial", Font.BOLD,15));
		
		userPasswordField.setBounds(rightpanel, 290, 290, 38);
		userPasswordField.setFont(new Font("Arial", Font.BOLD,14));
		userPasswordField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(180,195,215),1), BorderFactory.createEmptyBorder(4,8,4,8)));
		
		loginButton.setBounds(rightpanel+150, 360, 140, 42);
		loginButton.setFocusable(false);
		loginButton.setBackground(new Color(41,128,185));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Arial", Font.BOLD,14));
		loginButton.setOpaque(true);
		loginButton.setBorderPainted(false);
		
		reset.setBounds(rightpanel, 360, 130, 42);
		reset.setFocusable(false);
		reset.setBackground(new Color(120,130,140));
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Arial", Font.BOLD,14));
		reset.setOpaque(true);
		reset.setBorderPainted(false);
		
		messageLabel.setBounds(rightpanel, 420, 290, 35);
		messageLabel.setFont(new Font("Arial", Font.BOLD,14));
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JSeparator half = new JSeparator(JSeparator.VERTICAL);
		half.setBounds(480,120,2,380);
		half.setForeground(new Color(200,210,225));
		
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/project/atrium-22-drone-at-night.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(360, 300, Image.SCALE_SMOOTH);
		logoLabel.setIcon(new ImageIcon(logoImage));
		
		
		
	
        reset.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	clearLoginForm();
		}
	});
        loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
        frame.add(logoLabel);
		frame.add(title);
		frame.add(sub);
		
		frame.add(imagePanel);
		frame.add(half);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		
		frame.add(messageLabel);
		
		frame.add(userIDField);
		frame.add(userPasswordField);
		
		frame.add(loginButton);
		frame.add(reset);
		
        frame.setVisible(true);
       		
		
	}
	
	public void clearLoginForm() {
		userIDField.setText("");
		userPasswordField.setText("");
		messageLabel.setText("");
	}

	public void login() {

		String userID = userIDField.getText();
		String password = String.valueOf(userPasswordField.getPassword());

		User user = userRepository.checkLogin(userID, password);

		if(user == null) {
			showLoginError();
			return;
		}

		showLoginSuccess();

		frame.dispose();
		DashboardFactory.openDashboard(user);
	}
	public void showLoginError() {
		messageLabel.setForeground(Color.RED);
		messageLabel.setText("Wrong username or password");
	}

	public void showLoginSuccess() {
		messageLabel.setForeground(Color.GREEN);
		messageLabel.setText("Login Successful");
	}

	
}