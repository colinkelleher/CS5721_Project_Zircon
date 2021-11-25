package CS5721.project.employee.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import CS5721.project.calendar.entity.Calendar;
import CS5721.project.calendar.entity.CalendarEvent;
import CS5721.project.clocking.entity.ClockingInfo;
import CS5721.project.clocking.entity.Shift;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;
import CS5721.project.reminder.entity.ReminderList;

//@Entity
public class Manager extends Employee {

	// Here we link an event to an employeeID

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
