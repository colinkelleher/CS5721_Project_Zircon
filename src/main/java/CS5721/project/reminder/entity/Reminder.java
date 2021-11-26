package CS5721.project.reminder.entity;

import javax.persistence.*;

@Entity
public class Reminder extends ReminderAbstract {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "details")
	private String details;

	@ManyToOne()
	protected ReminderList reminderList;

	public Reminder() {

	}

	public Reminder(String _details) {
		this.details = _details;
	}

	@Override
	public String addDetails(String detail) {
		return details;
	}

	public String getDetails() {
		return details;
	}

	public void setReminderList(ReminderList reminderList) {
		this.reminderList = reminderList;
	}


}
