package CS5721.project.reminder.entity;

public abstract class ReminderAbstract {
	String details = "";

	public String addDetails(String detail) {
		return detail;
	}

	public Reminder newReminder(String _details) {
		return new Reminder(_details);
	}

}