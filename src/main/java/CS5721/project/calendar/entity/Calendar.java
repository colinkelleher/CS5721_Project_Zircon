package CS5721.project.calendar.entity;

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
@Table(name = "calendar")
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany()
	@JoinColumn(name = "calendar_id", insertable = false, updatable = false)
	private Set<CalendarEvent> events;

	public Calendar() {
		this.events = new HashSet<>();
	}

	public void addEvent(CalendarEvent event) {
		events.add(event);
	}

	public Set<CalendarEvent> getEvents() {
		return events;
	}

	public CalendarEvent findEvent(long id) {
		return events.stream().filter(event -> event.getId() == id).findAny().orElse(null);
	}
}
