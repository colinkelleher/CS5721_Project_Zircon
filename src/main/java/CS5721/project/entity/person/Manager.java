package CS5721.project.entity.person;

import java.util.*;

import CS5721.project.entity.DEPARTMENT;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.observer.OPERATIONS;
import CS5721.project.observer.publisher.EventSystem;

public class Manager extends Employee {

	// Here we link an event to an employeeID
	private final Map<Long, List<CalendarEvent>> requests;

	public Manager(Long id, String name, DEPARTMENT department, EventSystem eventSystem, OPERATIONS[] operations) {
		super(id, name, department, eventSystem, operations);
		requests = new HashMap<>();
	}

	public Map<Long, List<CalendarEvent>> getRequests() {
		return this.requests;
	}

	public void addRequest(CalendarEvent request, Long employeeID) {
		List<CalendarEvent> newRequestList;

		if (requests.containsKey(employeeID)){
			newRequestList = requests.get(employeeID);
			newRequestList.add(request);
		}
		else {
			newRequestList = new ArrayList<>(List.of(request));
		}

		requests.put(employeeID, newRequestList);
	}

	public void deleteRequestWithID(long employeeID, long eventID){
		List<CalendarEvent> requestList = requests.get(employeeID);

		requestList.removeIf(request -> request.getId() == eventID);
	}

	@Override
	public void update(OPERATIONS operation, long eventID, long employeeID) {
		if (operation.equals(OPERATIONS.VALIDATE_REQUEST)) {
			deleteRequestWithID(employeeID, eventID);
		}
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
