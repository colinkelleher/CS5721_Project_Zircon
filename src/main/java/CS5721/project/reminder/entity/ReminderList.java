package CS5721.project.reminder.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reminder_list")
public class ReminderList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany()
	@JoinColumn(name = "reminder_list_id", insertable = false, updatable = false)
	private final Set<Reminder> reminders;

	public ReminderList() {
		this.reminders = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addReminder(Reminder reminder) {
		reminders.add(reminder);
	}

	public Set<Reminder> getReminderList() {
		return reminders;
	}

}
