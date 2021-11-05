package CS5721.project.entity.person;

import CS5721.project.entity.calendar.Calendar;
import CS5721.project.entity.calendar.CalendarEvent;
import CS5721.project.entity.wage.Wage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Manager extends Employee {

	// Here we link an event to an employeeID
	private Map<CalendarEvent,Long> requests;

	public Manager(Long id, String name, Wage wage, Calendar calendar) {
		super(id, name, wage, calendar);
		requests = new HashMap<>();
	}

	public Map<CalendarEvent, Long> getRequests(){
		return this.requests;
	}

	public void addRequest(CalendarEvent request, Long employeeID){
		this.requests.put(request, employeeID);
	}

	@Override
	public void update(String eventType, CalendarEvent event, Long employeeID) {

		//This check is needed because a Manager can receive a request for himself !
		if (Objects.equals(eventType, "create_request")){
			this.addRequest(event,employeeID);
		}
		else if (Objects.equals(eventType, "create_event") &&Objects.equals(this.getId(), employeeID)) {
			this.getCalendar().addEvent(event);
		}
	}

}
