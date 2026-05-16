# Department Notice Board System

## Project Description

The Department Notice Board System is a Java Swing application designed for a Computer Science department. The system allows administrators to create official department notices, and students can view notices based on categories such as recent notices, important notices, upcoming events, and all notices.

The system includes a login system with two user roles: Admin and Student. Admin users can create notices, while student users can view notices filtered by their year level.

## Main Features

- Login system for Admin and Student users
- Admin dashboard for creating notices
- Student dashboard for viewing notices
- Notice categories:
  - All Notices
  - Recent Notices
  - Important Notices
  - Upcoming Events
- Student notices filtered by year level
- MariaDB database integration
- Java Swing graphical user interface
- Unit tests for important parts of the system

## Software Engineering Principles Used

This project applies several software engineering principles:

- Separation of concerns
- Modular code organization
- Repository pattern for database access
- Strategy pattern for notice filtering
- Factory pattern for dashboard and strategy creation
- Builder pattern for creating Notice objects
- Unit testing with JUnit

## Project Structure

```text
src/
  controller/
    NoticeController.java

  enums/
    Priority.java
    UserRole.java
    YearLevel.java

  factory/
    DashboardFactory.java
    NoticeFilterFactory.java

  interfaces/
    NoticeFilterStrategy.java
    NoticeRepository.java
    UserRepository.java

  models/
    Notice.java
    User.java

  repository/
    DatabaseConnection.java
    NoticeConnection.java
    UserConnection.java

  strategy/
    AllNoticeStrategy.java
    ImportantNoticeStrategy.java
    RecentNoticeStrategy.java
    UpcomingNoticeStrategy.java

  ui/
    AdminDash.java
    CreatePage.java
    LoginPage.java
    Main.java
    StudentDash.java# Department Notice Board System

## Project Description

The Department Notice Board System is a Java Swing application designed for a Computer Science department. The system allows administrators to create official department notices, and students can view notices based on categories such as recent notices, important notices, upcoming events, and all notices.

The system includes a login system with two user roles: Admin and Student. Admin users can create notices, while student users can view notices filtered by their year level.

## Main Features

- Login system for Admin and Student users
- Admin dashboard for creating notices
- Student dashboard for viewing notices
- Notice categories:
  - All Notices
  - Recent Notices
  - Important Notices
  - Upcoming Events
- Student notices filtered by year level
- MariaDB database integration
- Java Swing graphical user interface
- Unit tests for important parts of the system

## Software Engineering Principles Used

This project applies several software engineering principles:

- Separation of concerns
- Modular code organization
- Repository pattern for database access
- Strategy pattern for notice filtering
- Factory pattern for dashboard and strategy creation
- Builder pattern for creating Notice objects
- Unit testing with JUnit

## Project Structure

```text
src/
  controller/
    NoticeController.java

  enums/
    Priority.java
    UserRole.java
    YearLevel.java

  factory/
    DashboardFactory.java
    NoticeFilterFactory.java

  interfaces/
    NoticeFilterStrategy.java
    NoticeRepository.java
    UserRepository.java

  models/
    Notice.java
    User.java

  repository/
    DatabaseConnection.java
    NoticeConnection.java
    UserConnection.java

  strategy/
    AllNoticeStrategy.java
    ImportantNoticeStrategy.java
    RecentNoticeStrategy.java
    UpcomingNoticeStrategy.java

  ui/
    AdminDash.java
    CreatePage.java
    LoginPage.java
    Main.java
    StudentDash.java# Department Notice Board System

## Project Description

The Department Notice Board System is a Java Swing application designed for a Computer Science department. The system allows administrators to create official department notices, and students can view notices based on categories such as recent notices, important notices, upcoming events, and all notices.

The system includes a login system with two user roles: Admin and Student. Admin users can create notices, while student users can view notices filtered by their year level.

## Main Features

- Login system for Admin and Student users
- Admin dashboard for creating notices
- Student dashboard for viewing notices
- Notice categories:
  - All Notices
  - Recent Notices
  - Important Notices
  - Upcoming Events
- Student notices filtered by year level
- MariaDB database integration
- Java Swing graphical user interface
- Unit tests for important parts of the system

## Software Engineering Principles Used

This project applies several software engineering principles:

- Separation of concerns
- Modular code organization
- Repository pattern for database access
- Strategy pattern for notice filtering
- Factory pattern for dashboard and strategy creation
- Builder pattern for creating Notice objects
- Unit testing with JUnit

## Project Structure

```text
src/
  controller/
    NoticeController.java

  enums/
    Priority.java
    UserRole.java
    YearLevel.java

  factory/
    DashboardFactory.java
    NoticeFilterFactory.java

  interfaces/
    NoticeFilterStrategy.java
    NoticeRepository.java
    UserRepository.java

  models/
    Notice.java
    User.java

  repository/
    DatabaseConnection.java
    NoticeConnection.java
    UserConnection.java

  strategy/
    AllNoticeStrategy.java
    ImportantNoticeStrategy.java
    RecentNoticeStrategy.java
    UpcomingNoticeStrategy.java

  ui/
    AdminDash.java
    CreatePage.java
    LoginPage.java
    Main.java
    StudentDash.javaNeed mariadb referenced libraries and have mariadb database.
CREATE DATABASE IF NOT EXISTS users;
USE users;

DROP TABLE IF EXISTS notices;
DROP TABLE IF EXISTS usersandpasswords;

Queries:
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
	year VARCHAR(20)
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

	FOREIGN KEY (created_by) REFERENCES usersandpasswords(user_id)
);
