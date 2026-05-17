package factory;

import java.util.HashMap;

import enums.UserRole;
import models.User;
import ui.AdminDash;
import ui.StudentDash;

public class DashboardFactory {

	private HashMap<String, DashboardOpener> dashboards;

	public DashboardFactory() {

		dashboards = new HashMap<String, DashboardOpener>();

		dashboards.put(UserRole.ADMIN.getDatabaseValue(), new DashboardOpener() {
			@Override
			public void open(User user) {
				new AdminDash(user.getFullname(), user.getUserId());
			}
		});

		dashboards.put(UserRole.STUDENT.getDatabaseValue(), new DashboardOpener() {
			@Override
			public void open(User user) {
				new StudentDash(user.getFullname(), user.getYear());
			}
		});
	}

	public void openDashboard(User user) {

		DashboardOpener dashboard = dashboards.get(user.getRole());

		if(dashboard == null) {
			throw new IllegalArgumentException("Unknown user role: " + user.getRole());
		}

		dashboard.open(user);
	}
}