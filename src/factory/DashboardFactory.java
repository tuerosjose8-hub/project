package factory;

import enums.UserRole;
import models.User;
import ui.AdminDash;
import ui.StudentDash;

public class DashboardFactory {

	public static void openDashboard(User user) {
		
		if(user.getRole().equals(UserRole.ADMIN.getDatabaseValue())) {
			new AdminDash(user.getFullname(), user.getUserId());
			return;
		}

		if(user.getRole().equals(UserRole.STUDENT.getDatabaseValue())) {
			new StudentDash(user.getFullname(), user.getYear());
			return;
		}
	}
}