package CS5721.project.entity.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import CS5721.project.entity.DEPARTMENT;
import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.clock.Shift;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;

public class Manager extends Employee {

	// Here we link an event to an employeeID
	private final Map<CalendarEvent, Long> requests;

	public Manager(Long id, String name, DEPARTMENT department, Shift shift, Calendar calendar) {
		super(id, name, department, shift, calendar);
		requests = new HashMap<>();
	}

	public Map<CalendarEvent, Long> getRequests() {
		return this.requests;
	}

	public void addRequest(CalendarEvent request, Long employeeID) {
		this.requests.put(request, employeeID);
	}

	public void deleteRequest(CalendarEvent request) {
		this.requests.remove(request);
	}

	@Override
	public void update(OPERATIONS operation, CalendarEvent event, Long employeeID) {

		// This check is needed because a Manager can receive a request for himself !
		if (Objects.equals(operation, OPERATIONS.CREATE_REQUEST)) {
			this.addRequest(event, employeeID);
		}
		if (Objects.equals(operation, OPERATIONS.CREATE_EVENT) && Objects.equals(this.getId(), employeeID)) {
			this.getCalendar().addEvent(event);
		}
	}


}
