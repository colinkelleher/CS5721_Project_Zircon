package CS5721.project.calendar.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "calendar")
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "calendar_id", insertable = false, updatable = false)
	@JsonManagedReference
	private Set<CalendarEvent> events;

	public Calendar() {
		this.events = new HashSet<>();
	}

	public void addEvent(CalendarEvent event) {
		events.add(event);
		event.setCalendar(this);
	}

	public Set<CalendarEvent> getEvents() {
		return events;
	}

	public CalendarEvent findEvent(long id) {
		return events.stream().filter(event -> event.getId() == id).findAny().orElse(null);
	}
}
