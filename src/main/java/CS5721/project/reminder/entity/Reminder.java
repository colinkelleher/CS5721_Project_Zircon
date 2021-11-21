package CS5721.project.reminder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reminder implements ReminderInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reminderID;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@ManyToOne()
	protected ReminderList reminderList;

	public Reminder(long reminderID, String title, String reminderDesc) {
		this.reminderID = reminderID;
		this.title = title;
		this.description = reminderDesc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getReminderID() {
		return reminderID;
	}

	public void setReminderID(long reminderID) {
		this.reminderID = reminderID;
	}

	public String printReminder() {
		return this.title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String reminderDesc) {
		this.description = reminderDesc;
	}

}
