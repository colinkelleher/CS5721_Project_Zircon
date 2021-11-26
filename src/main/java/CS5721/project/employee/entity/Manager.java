package CS5721.project.employee.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

@Entity
public class Manager extends Employee {

	// Here we link an event to an employeeID

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_request_mapping", joinColumns = {
			@JoinColumn(name = "company_entity_id", referencedColumnName = "company_entity_id") }, inverseJoinColumns = {
					@JoinColumn(name = "calendar_event_id", referencedColumnName = "id") })
	@MapKeyJoinColumn(name = "company_entity_id")
	private final Map<Long, CalendarEvent> requests;

	public Manager(Long id, String name, DEPARTMENT department, Shift shift, Calendar calendar,
			ClockingInfo clockingInfo, ReminderList reminderList, EventSystem eventSystem, OPERATIONS[] operations) {
		super(name, department, shift, calendar, clockingInfo, reminderList, eventSystem, operations);
		requests = new HashMap<>();
	}

	public Map<Long, CalendarEvent> getRequests() {
		return this.requests;
	}

	public void addRequest(CalendarEvent request, Long employeeID) {
		this.requests.put(employeeID, request);
	}

	public void deleteRequest(CalendarEvent request) {
		this.requests.values().remove(request);
	}

}
