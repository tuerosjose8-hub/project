CREATE DATABASE IF NOT EXISTS users;
USE users;

DROP TABLE IF EXISTS notices;
DROP TABLE IF EXISTS usersandpasswords;

CREATE TABLE usersandpasswords (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    student_id VARCHAR(20),
    major VARCHAR(100),
    year VARCHAR(20),

    CONSTRAINT chk_user_role CHECK (role IN ('ADMIN', 'STUDENT')),
    CONSTRAINT chk_user_year CHECK (
        year IS NULL OR year IN ('Freshman', 'Sophomore', 'Junior', 'Senior', 'Graduate')
    )
);

CREATE TABLE notices (
    notice_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    message TEXT NOT NULL,
    category VARCHAR(50) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    year_level VARCHAR(30) NOT NULL,
    created_by INT NOT NULL,
    deadline_date DATE NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_notice_creator
        FOREIGN KEY (created_by) REFERENCES usersandpasswords(user_id),
	
	CONSTRAINT chk_notice_category CHECK (
    category IN ('General', 'Academic', 'Internship Opportunities', 'CS Club', 'Events', 'Deadlines')
),
    CONSTRAINT chk_notice_priority CHECK (priority IN ('High', 'Medium', 'Low')),
    CONSTRAINT chk_notice_year CHECK (
        year_level IN ('Freshman', 'Sophomore', 'Junior', 'Senior', 'Graduate', 'All')
    )
);

INSERT INTO usersandpasswords
(username, password, role, first_name, last_name, email, student_id, major, year)
VALUES
('admin', 'admin123', 'ADMIN', 'Admin', 'User', 'admin@newpaltz.edu', NULL, NULL, NULL),
('student', 'student123', 'STUDENT', 'Student', 'User', 'student@newpaltz.edu', 'N00000001', 'Computer Science', 'Junior');

INSERT INTO notices
(title, message, category, priority, year_level, created_by, deadline_date)
VALUES
-- NOTE: passwords should be hashed in production (e.g. BCrypt)
('Welcome to the CS Notice Board', 'This board shows official Computer Science department notices.', 'General', 'Medium', 'All', 1, NULL),
('Advising Reminder', 'Juniors should meet with their advisor before registration.', 'Academic', 'High', 'Junior', 1, DATE_ADD(CURDATE(), INTERVAL 2 WEEK)),
('Department Event', 'There will be a department event next week.', 'Events', 'Low', 'All', 1, DATE_ADD(CURDATE(), INTERVAL 1 WEEK));

