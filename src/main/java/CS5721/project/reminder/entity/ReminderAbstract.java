package CS5721.project.reminder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

public abstract class ReminderAbstract {

	@Column(name = "details")
	String details = "";

	public String addDetails(String detail) {
		return detail;
	}

	public Reminder newReminder(String _details) {
		return new Reminder(_details);
	}

}